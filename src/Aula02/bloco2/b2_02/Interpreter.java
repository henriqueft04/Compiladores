@SuppressWarnings("CheckReturnValue")
public class Interpreter extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      Double res = visit(ctx.expr());

      if (res != null) {
         System.out.println(">" + res);
      }
      
      return null;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      Double res = null;
      res = Double.parseDouble(ctx.Number().getText());
      return res;
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;
      
      Double a = visit(ctx.expr(0));
      Double b = visit(ctx.expr(1));
      String op = ctx.op.getText();

      switch (op) {
         case "+":
            res = a + b;
            break;
         case "-":
            res = a - b;
            break;
         case "*":
            res = a * b;
            break;
         case "/":
            if (b == 0) {
               throw new IllegalArgumentException("Cannot divide by zero");
            }
            res = a / b;
            break;
      }

      return res;
   }
}
