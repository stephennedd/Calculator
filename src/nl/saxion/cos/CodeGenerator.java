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

		jasminCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
		visit(ctx.expression());
		jasminCode.add("invokevirtual java/io/PrintStream/println(I)V");

	    jasminCode.add("return");
	    jasminCode.add(".end method");

		return null;
    }

	@Override
	public Void visitExIntLiteral(CalcParser.ExIntLiteralContext ctx) {
		jasminCode.add("ldc " + ctx.getText());
		return null;
	}

	@Override
	public Void visitExNegate(CalcParser.ExNegateContext ctx) {
		visit(ctx.expression());
		jasminCode.add("ineg");
		return null;
	}

	@Override
	public Void visitExAddOp(CalcParser.ExAddOpContext ctx) {
		visit(ctx.left);
		visit(ctx.right);

		if (ctx.op.getText().equals("+")) {
			jasminCode.add("iadd");
		}
		else {
			jasminCode.add("isub");
		}
		return null;
	}

	@Override
	public Void visitExMulOp(CalcParser.ExMulOpContext ctx) {
		visit(ctx.left);
		visit(ctx.right);

		jasminCode.add("imul");

		return null;
	}

	@Override
	public Void visitExTernary(CalcParser.ExTernaryContext ctx) {
		visit(ctx.left);
		visit(ctx.right);
		//TODO add labels to jump to
		if (ctx.op.getText().equals(">")) {
			jasminCode.add("if_icmpgt then");
			jasminCode.add("goto else");
			visit(ctx.trueVal);
		} else if (ctx.op.getText().equals("<")) {
			jasminCode.add("if_icmplt then");
			jasminCode.add("goto else");
		} else if (ctx.op.getText().equals(">=")) {
			jasminCode.add("if_icmpge then");
			jasminCode.add("goto else");
		} else if (ctx.op.getText().equals("<=")) {
			jasminCode.add("if_icmple then");
			jasminCode.add("goto else");
		} else if (ctx.op.getText().equals("==")) {
			jasminCode.add("if_icmpeq then");
			jasminCode.add("goto else");
		} else if (ctx.op.getText().equals("!=")) {
			jasminCode.add("if_icmpne then");
			jasminCode.add("goto else");
		} else {
			jasminCode.add("else:");
			visit(ctx.falseVal);
		}
		return null;
	}
}
