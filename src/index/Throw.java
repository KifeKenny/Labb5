package index;

public class Throw {
  
  public int throwOrder, score;
  public int[] bothThrows;
  public boolean validThrow, strike, spare;
  
  public Throw(int[] kast) {
    bothThrows = kast;
    
    score = bothThrows[0] + bothThrows[1];
    validThrow = isValid();
    
    strike = isStrike(bothThrows[0]);
    spare  = isSpare(score);
  }
  
  public boolean isValid() {
    boolean result = true;
   
    if(score > 10 || score < 0) {
      result = false;
    } else if(bothThrows[0] > 10 || bothThrows[0] < 0) {
      result = false;
    } else if(bothThrows[1] > 10 || bothThrows[1] < 0) {
      result = false;
    }
    
    return result;
  }
  
  public boolean isStrike(int firstThrow) {
    boolean result = false;
   
    if(firstThrow == 10) {
      result = true;
    }
    return result;
  }
  
  public boolean isSpare(int score) {
    boolean result = false;
    
    if(score == 10 && !strike) {
      result = true;
    }

    return result;
  }
}
