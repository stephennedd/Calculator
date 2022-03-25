package nl.saxion.cos;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class TypeChecker extends CalcBaseVisitor<DataType> {

    private final ParseTreeProperty<DataType> types;

    public TypeChecker(ParseTreeProperty<DataType> types) {
        this.types = types;
    }

    public ParseTreeProperty<DataType> getTypes() {
        return types;
    }

    @Override
    public DataType visitExIntLiteral(CalcParser.ExIntLiteralContext ctx) {
        return DataType.INT;
    }

    @Override
    public DataType visitExAddOp(CalcParser.ExAddOpContext ctx) {
        DataType leftType = visit(ctx.left);
        DataType rightType = visit(ctx.right);
        if (leftType != rightType) {
//            throw new CompilerException("ERROR: The values are not of the same type");
        }

        types.put(ctx, leftType);
        return leftType;
    }

    //TODO write methods here to check the types before creating jasminCode
}
