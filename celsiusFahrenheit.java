import java.util.Scanner;
import java.text.DecimalFormat;

public class celsiusFahrenheit{
  public static void main (String[] args){
    double tempInterval = 0;
    double startVal = 0;
    double endVal = 0;
    DecimalFormat df = new DecimalFormat("0.0");
    boolean loopBool = false;
    Scanner input = new Scanner(System.in);
    while(!loopBool){
      System.out.println("Please enter an interval for the celsius temperature values.");
      while (!input.hasNextDouble()){
        System.out.println("You did not enter a valid interval value.");
        input.next();
      }
      tempInterval = input.nextDouble();
      if (tempInterval > 0){
        loopBool = true;
      }
      else{
        System.out.println("You did not enter a positive interval. Try again.\n");
      }
    }
    loopBool = false;
    while(!loopBool){
      System.out.println("Please enter a starting value for the celsius temperature values.");
      while (!input.hasNextDouble()){
        System.out.println("You did not enter a valid starting value.");
        input.next();
      }
      startVal = input.nextDouble();
      System.out.println("Please enter an ending value for the celsius temperature values.");
      while (!input.hasNextDouble()){
        System.out.println("You did not enter a valid ending value.");
        input.next();
      }
      endVal = input.nextDouble();
      if (endVal > startVal){
        loopBool = true;
      }
      else{
        System.out.println("Your ending value cannot be smaller than your starting value.\n");
      }
    }
    input.close();
    System.out.print("Celsius:    ");
    for (double i = startVal; i <= endVal; i = i + tempInterval){
      String celsiusString = df.format(i);
      while (celsiusString.length() < df.format((9.0/5.0 * i) + 32.0).length() + 1){
        celsiusString = celsiusString.concat(" ");
      }
      System.out.print(celsiusString);
    }
    System.out.print("\nFahrenheit: ");
    for (double i = 9.0/5.0 * startVal; i <= 9.0/5.0 * endVal; i = i + 9.0/5.0 * tempInterval){
      System.out.print(df.format(i + 32.0) + " ");
    }
  }
}

// length = current fahrenheit_val_length + 1