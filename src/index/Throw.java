package index;

public class Throw {
  
  public String test = "test";
  public int throwOrder, score;
  public int[] bothThrows;
  
  
  public Throw(int order, int[] kast) {
    throwOrder = order;
    bothThrows = kast;
    
    score = bothThrows[0] + bothThrows[1];
  }
}
