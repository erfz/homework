import java.util.Scanner;

public class minMaxNum{
  public static void main (String[] args){
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    String inputVar = "";
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter a series of integers (q to exit)");
    while(!(inputVar.equals("q"))){
      inputVar = input.next();
      if (!inputVar.equals("q")){
        if (inputVar.matches("^-?\\d+$")){
          if (Integer.parseInt(inputVar) < min){
            min = Integer.parseInt(inputVar);
          }
          if (Integer.parseInt(inputVar) > max){
            max = Integer.parseInt(inputVar); 
          }
        }
        else{
          System.out.println("Not a valid integer.");
        }
      }
    }
    input.close();
    System.out.println("\nThe smallest value is: " + min + "\nThe largest value is: " + max);
  }
}