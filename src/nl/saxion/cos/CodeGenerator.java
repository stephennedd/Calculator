package nl.saxion.cos;

import java.util.ArrayList;

/**
 * Code generator.
 * Visits each node in the tree of an expression a generates the code needed to
 * evaluate that expression.
 *
 * TODO: Expand this, so that it actually calculates the correct value.
 */
public class CodeGenerator extends CalcBaseVisitor< Void > {
	private ArrayList<String> jasminCode = new ArrayList<>();

	public ArrayList<String> getJasminCode() {
		return jasminCode;
	}

    @Override
	public Void visitStart( CalcParser.StartContext ctx ) {
	    // Main method
	    jasminCode.add(".method public static main([Ljava/lang/String;)V");
	    jasminCode.add(".limit stack 99");
	    jasminCode.add(".limit locals 99");
	    jasminCode.add("");

	    // TODO: Make sure the value is printed here!

	    jasminCode.add("return");
	    jasminCode.add(".end method");

		return null;
    }
}
