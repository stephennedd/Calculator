package nl.saxion.cos;

import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simple calculator demonstrating the ANTLR visitor.
 */
public class Calculator {
	private static ArrayList<String> errors = new ArrayList<>();

	/**
	 * Main method.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while( true ) {
			// Ask for expression
			System.out.print("CALC> ");
			String line = s.nextLine();
			if( line.equals("exit") )
				break;

			// Eval
			generateByteCode(line);
		}
		System.out.println("KTHNXBYE");
	}

	/**
	 * Evaluate the entered line.
	 * @param line  A line conforming to the grammar Calc.g4
	 */
	private static void generateByteCode( String line ) {
		// Reset errors
		errors.clear();

		// Create lexer and run scanner to create stream of tokens
		CharStream charStream = CharStreams.fromString(line);
		CalcLexer lexer = new CalcLexer(charStream);
		setupErrorListener(lexer);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Create parser and feed it the tokens
		CalcParser parser = new CalcParser(tokens);
		setupErrorListener(parser);
		CalcParser.StartContext parseTree = parser.start();

		// Have there been errors? Bail out
		if( errors.size() > 0 ) {
			for( String e : errors )
				System.out.println(e);
			return;
		}

		// Generate code
		CodeGenerator codeGenerator = new CodeGenerator();
		codeGenerator.visit(parseTree);

		try {
			// Write to file
			PrintWriter out = new PrintWriter(new File("Sum.j"));

			out.println(".class public Sum");
			out.println(".super java/lang/Object");
			out.println();

			for( String codeLine : codeGenerator.getJasminCode() )
				out.println(codeLine);

			out.close();
		} catch( IOException error ) {
			System.err.println("Error writing file: " + error.getMessage() );
		}
	}

	private static void setupErrorListener( Recognizer<?, ?> lexerOrParser ) {
		lexerOrParser.removeErrorListeners();
		lexerOrParser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
			                        int line, int charPositionInLine,
			                        String msg, RecognitionException e ) {
				errors.add( "ERROR at pos " + charPositionInLine + ": " + msg );
			}
		});
	}
}
