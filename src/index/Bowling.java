package index;


public class Bowling {
  
  public int frame = 10;
  public int invalid = -1;
  public Throw throw1 = new Throw(new int[] {2, 4});
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
     System.out.print("s");
      
  }
  
  
  public int playGame(Throw[] gameThrows) {
    System.out.print("Game start!! \n");
    int score = 0;
    
    if(gameThrows.length != frame) {
      System.out.print("invalid amount of throws, game ending \n");
      return invalid;
    }
    
    for(int i=0; i<gameThrows.length; i++) {
      
      if(!gameThrows[i].validThrow) {
        System.out.print("Invalid throw, game ending \n");
        return invalid;
      }
      
      if(gameThrows[i].strike) {
        score += 10 + gameThrows[i + 1].score;
      } else {
        score += gameThrows[i].score; 
      }
      
      String mes = "Throws: [" + gameThrows[i].bothThrows[0] + ", " + gameThrows[i].bothThrows[1]; 
      mes += "] Current Score: " + score + "\n";
      System.out.print(mes);  
    }
    
    return score;
  }
}
