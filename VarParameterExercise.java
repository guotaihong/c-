public class VarParameterExercise{
  public static void main(String[]args){
      HspMethod hm  = new HspMethod();
      System.out.println ( hm.showScore("milan",90.1,80.0));

 class HspMethod{
     public String showScore(String name,double...scores){
      double  totalscore = 0; 
      int i = 0;
      
      for(i = 0 ; i <  scores.length; i ++ ){
        totalscore +=  scores [i];
      }  return name + "有" + scores.length +"门课总分为" + totalscore;
     }
   }
  }
}