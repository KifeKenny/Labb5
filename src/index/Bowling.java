package index;


public class Bowling {
  
  public int frame = 10;
  public int invalid = -1;
  public Throw throw1 = new Throw(new int[] {2, 4});
  public String mes;
  
  
  
  public int playGame(Throw[] gameThrows) {
    System.out.print("Game start!! \n");
    int score = 0;
    

    for(int i=0; i<gameThrows.length; i++) {
      
      if(i > 9 && !gameThrows[i].spare && !gameThrows[i].strike) {
        System.out.print("Invalid amount of throws game ending \n");
        return invalid;
      }
      
      if(!gameThrows[i].validThrow) {
        if(i == 9 && gameThrows[i].strike && gameThrows[i].bothThrows[0] >= 10 && gameThrows[i].bothThrows[1] >= 10) {
          System.out.print("");
        } else {
          System.out.print("Invalid throw, game ending \n");
          return invalid;
        }
      }
      
      if(gameThrows[i].strike) {
        
        if(i == 9) {
          if(gameThrows.length != 11) {
            System.out.print("Invalid amount of throws game ending \n");
            return invalid;
          }
          score += 10 + gameThrows[i + 1].bothThrows[0] + gameThrows[i + 1].bothThrows[1];
          
          mes = "Throws: [" + gameThrows[i].bothThrows[0] + ", " + gameThrows[i].bothThrows[1]; 
          mes += "] Current Score: " + score + "\n";
          mes += "Throws: [" + gameThrows[i + 1].bothThrows[0] + ", " + gameThrows[i + 1].bothThrows[1]; 
          mes += "] Current Score: " + score + "\n";
          
          System.out.print(mes);
          
          return score;
        }
        
        score = multiStrike(i, score, gameThrows);
        
        if(i == 9) {
          if(gameThrows.length != 11) {
            System.out.print("Invalid amount of throws game ending \n");
            return invalid;
          }
          mes = "Throws: [" + gameThrows[i].bothThrows[0] + ", " + gameThrows[i].bothThrows[1]; 
          mes += "] Current Score: " + score + "\n";
          mes += "Throws: [" + gameThrows[i + 1].bothThrows[0] + ", " + gameThrows[i + 1].bothThrows[1]; 
          mes += "] Current Score: " + score + "\n";
          
          System.out.print(mes);
          return score;
        }
        
        
      } else if(gameThrows[i].spare) {
        score += 10 + gameThrows[i + 1].bothThrows[0];
        
        if(i == 9) {
          if(gameThrows.length != 11) {
            System.out.print("Invalid amount of throws game ending \n");
            return invalid;
          }
          
          mes = "Throws: [" + gameThrows[i].bothThrows[0] + ", " + gameThrows[i].bothThrows[1]; 
          mes += "] Current Score: " + score + "\n";
          mes += "Throws: [" + gameThrows[i + 1].bothThrows[0]; 
          mes += "] Current Score: " + score + "\n";
          
          System.out.print(mes);
          
          return score;
        }
        
      } else {
        score += gameThrows[i].score; 
      }
      
      mes = "Throws: [" + gameThrows[i].bothThrows[0] + ", " + gameThrows[i].bothThrows[1]; 
      mes += "] Current Score: " + score + "\n";
      System.out.print(mes);  
    }
    
    return score;
  }
  
  public int multiStrike(int i, int score, Throw[] gameThrows) {
    int x = 0;
    
    while(i != 10) {
      if(gameThrows[i + 1].strike) {
        if (x == 20) {
          x = 10 + 10 + 10;
          return score + x;
        }
        x = 10 + 10;
      } else {
        if (x == 20) {
          x = 20 + gameThrows[i + 1].bothThrows[0];
          return score + x;
        }
        x = 10 + gameThrows[i + 1].bothThrows[0] + gameThrows[i + 1].bothThrows[1];
        return score + x;
      }
      i += 1;
    }
    
    return -1;
  }
}
