import java.util.Scanner;
import java.text.DecimalFormat;

public class letterGrades{
  public static void main (String[] args){
    boolean loopingParameter = false;
    double[] gradeArray = null;
    DecimalFormat df = new DecimalFormat("#.0");
    Scanner input = new Scanner(System.in);
    while (!loopingParameter){
      try{
        String[] inputParts = null;
        System.out.println("Please enter your grades (separated by spaces and/or commas).");
        String inputLine = input.nextLine();
        if ((inputLine.contains(",") || inputLine.contains(" ")) && !inputLine.matches("\\s+")){ // Hi Mr. Cohen -- I did this because for some reason
          inputParts = inputLine.split("\\s*(,*\\s+)|(,+)");                                     // parseDouble for empty input gives a replacement character
        } // the regex splits by optional spaces --> optional commas and 1 or more spaces OR 1 or more commas
        else{
          // System.out.println("String check failed!");
          throw new IllegalArgumentException();
        }
        // for (String value : inputParts){
        //   System.out.println(value);
        // }
        if (inputParts.length > 0){
          gradeArray = new double[inputParts.length];
        }
        else{
          throw new IllegalArgumentException();
        }
        for (int i = 0; i < inputParts.length; ++i){
          if (Double.parseDouble(inputParts[i]) >= 0 && Double.parseDouble(inputParts[i]) <= 100){
            gradeArray[i] = Double.parseDouble(inputParts[i]);
          }
          else{
              throw new java.util.InputMismatchException(); // this is arbitrary
          }
        }
        loopingParameter = true;
      }
      catch (Exception e){
        System.err.println(e);
        System.out.println("You did not enter a valid set of grades. Each grade must be in valid numbers and between 0 and 100.\n");
      }
    }
    input.close();
    for (int i = 0; i < gradeArray.length; ++i){
      System.out.println("Your " + (i+1) + getNumericIndicator(i) + " grade was: " + df.format(gradeArray[i]) + "% (" + determineGrade(gradeArray[i]) + ")");
    }
    System.out.println("Your grade average was: " + df.format(calcAverage(gradeArray)) + "% (" + determineGrade(calcAverage(gradeArray)) + ")");
  }
  public static double calcAverage(double... vars){ // accepts a set of arguments (including arrays) and computes the average of the values as a double
    double sum = 0;
    for (int i = 0; i < vars.length; ++i){
      sum += vars[i];
    }
    return sum/vars.length;
  }
  public static char determineGrade(double value){ // accepts a double and returns the corresponding grade letter as a char 
    if (value >= 90){
      return 'A';
    }
    else if (value >= 80){
      return 'B';
    }
    else if (value >= 70){
      return 'C';
    }
    else if (value >= 60){
      return 'D';
    }
    else if (value >= 0){
      return 'F';
    }
    else{
      return '!'; //denote bad input falling through -- should never happen.
    }
  }
  public static String getNumericIndicator(int num){ // accepts an int and returns the corresponding suffix from the english language as a string
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

/*
  C:\Users\mguo1\Downloads>java letterGrades
  Please enter your grades (separated by spaces and/or commas).
  10 20 30 40 50
  Your 1st grade was: 10.0% (F)
  Your 2nd grade was: 20.0% (F)
  Your 3rd grade was: 30.0% (F)
  Your 4th grade was: 40.0% (F)
  Your 5th grade was: 50.0% (F)
  Your grade average was: 30.0% (F)
*/