import java.util.Scanner;
import java.text.DecimalFormat;

public class serviceBill{
  public static void main (String[] args){
    char packageLetter;
    int hours = 0;
    double cost, cheapestCost = 0;
    DecimalFormat df = new DecimalFormat("#.00");
    df.setGroupingUsed(true);
    df.setGroupingSize(3);
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the letter of your subscription package.");
    String tempString = input.next().toLowerCase();
    while (!(tempString.equals("a") || tempString.equals("b") || tempString.equals("c"))){
      System.out.println("You did not enter a valid character.");
      System.out.println("\nPlease enter the letter of your subscription package.");
      tempString = input.next().toLowerCase();
    }
    packageLetter = tempString.charAt(0);
    input.nextLine();
    System.out.println("Please enter the number of hours used as an integer.");
    do{
      if (hours < 0){
        System.out.println("The number of hours cannot be less than zero.");
        System.out.println("\nPlease enter the number of hours used as an integer.");
      }
      while (!input.hasNextInt()){
        System.out.println("You did not enter a valid number of hours.");
        System.out.println("\nPlease enter the number of hours used as an integer.");
        input.next();
      }
      hours = input.nextInt();
    } while (!(hours >= 0));
    input.close();
    cost = getCost(packageLetter, hours);
    cheapestCost = findMin(getCost('a', hours), getCost('b', hours), getCost('c', hours));
    System.out.println("\nYour package is: " + Character.toUpperCase(packageLetter) + ".\nYou used: " + hours + " hours of service." + "\nThe total cost was: $" + df.format(cost) + ".");
    if (cost != cheapestCost){
      System.out.println("You could have saved $" + df.format(cost - cheapestCost) + " by switching to package " + getCheapestPackageLetter(hours) + ".");
    }
    else{
      System.out.println("Your package was the cheapest for the number of hours used.");
    }
  }
  public static double getCost(char packageletter, int hours){
    double cost;
    if (packageletter == 'a'){
      if (hours < 10){
        cost = 9.95;
      }
      else{
        cost = 9.95 + 2*(hours - 10);
      }
    }
    else if (packageletter == 'b'){
      if (hours < 20){
        cost = 13.95;
      }
      else{
        cost = 13.95 + (hours - 20);
      }
    }
    else{
      cost = 19.95;
    }
    return cost;
  }
  public static double findMin(double... vals) {
   double min = Double.POSITIVE_INFINITY;

   for (double d : vals) {
      if (d < min) min = d;
   }

   return min;
  }
  public static String getCheapestPackageLetter(int hours){
    String returnString = "";
    double minCost = findMin(getCost('a', hours), getCost('b', hours), getCost('c', hours));

    if ((minCost == getCost('a', hours)) && ((minCost != getCost('b', hours)) && (minCost != getCost('c', hours)))){
      returnString = "A";
    }
    else if ((minCost == getCost('b', hours)) && ((minCost != getCost('a', hours)) && (minCost != getCost('c', hours)))){
      returnString = "B";
    }
    else if ((minCost == getCost('c', hours)) && ((minCost != getCost('a', hours)) && (minCost != getCost('b', hours)))){
      returnString = "C";
    }
    else if ((minCost == getCost('a', hours) && minCost == getCost('b', hours)) && (minCost != getCost('c', hours))){
      returnString = "A or B";
    }
    else if ((minCost == getCost('a', hours) && minCost == getCost('c', hours)) && (minCost != getCost('b', hours))){
      returnString = "A or C";
    }
    else if ((minCost == getCost('b', hours) && minCost == getCost('c', hours)) && (minCost != getCost('a', hours))){
      returnString = "B or C";
    }
    else{
      returnString = "bad logic";
    }
    return returnString;
  }
}