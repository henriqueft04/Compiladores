package bloco2.b2_01;
@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
       
      // dar print de olá e o ID
      System.out.println("Olá " + ctx.ID().getText());

      return null;
      //return res;
   }
}
