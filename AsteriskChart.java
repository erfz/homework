import java.util.Scanner;

public class AsteriskChart{
  public static void main(String[] args){
    int numStores = 0;
    boolean loopBool = false;
    Scanner input = new Scanner(System.in);
    System.out.println("How many stores do you want to display?");
    while (!loopBool){
      while (!input.hasNextInt()){
        System.out.println("You did not enter a valid number of stores. Try again.");
        input.next();
      }
      numStores = input.nextInt();
      if (numStores > 0){
        loopBool = true;
      }
    }
    double[] saleArray = new double[numStores];
    loopBool = false;
    
    for (int i = 0; i < numStores; ++i){
      double tempVar = 0;
      System.out.println("What is today's sale for the " + (i+1) + getNumericIndicator(i) + " store?");
      while (!loopBool){
        while (!input.hasNextDouble()){
          System.out.println("You did not enter a valid sale amount. Try again.");
          input.next();
        }
        tempVar = input.nextDouble();
        if (tempVar >= 0){
          saleArray[i] = tempVar;
          loopBool = true;
        }
        else{
          System.out.println("The amount you entered was less than zero.");
        }
      }
      loopBool = false;
    }
    input.close();
    for (int j = 0; j < numStores; ++j){
      String asteriskString = "";
      while (asteriskString.length() < Math.floor(saleArray[j]/100.0)){
        asteriskString = asteriskString.concat("*");
      }
      System.out.println((j+1) + getNumericIndicator(j) + " Store: " + asteriskString);
    }
  }
  public static String getNumericIndicator(int num){
      String numericIndicator = "";
      if ((num+1) % 100 >= 11 && (num+1) % 100 <= 13){
        numericIndicator = "th";
      }
      else if ((num+1) % 10 == 1){
        numericIndicator = "st";
      }
      else if ((num+1) % 10 == 2){
        numericIndicator = "nd";
      }
      else if ((num+1) % 10 == 3){
        numericIndicator = "rd";
      }
      else{
        numericIndicator = "th";
      }
      return numericIndicator;
  }
}