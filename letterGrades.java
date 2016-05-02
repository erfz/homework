import java.util.Scanner;
import java.text.DecimalFormat;

public class letterGrades{
  public static void main (String[] args){
    boolean loopingParameter = false;
    double[] gradeArray = null;
    DecimalFormat df = new DecimalFormat("#.00");
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
        for (String value : inputParts){
          System.out.println(value);
        }
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
      String numericIndicator = "";
      if ((i+1) % 10 == 1){ // wrong -- bad for (i+1) % 100 = 11, 12 or 13. check AsteriskChart
        numericIndicator = "st";
      }
      else if ((i+1) % 10 == 2){
        numericIndicator = "nd";
      }
      else if ((i+1) % 10 == 3){
        numericIndicator = "rd";
      }
      else{
        numericIndicator = "th";
      }
      System.out.println("Your " + (i+1) + numericIndicator + " grade was: " + df.format(gradeArray[i]) + "%");
    }
    System.out.println("Your grade average was: " + df.format(arrayAverage(gradeArray)) + "%\nYour letter grade was: " + returnGradeLetter(arrayAverage(gradeArray)));
  }
  public static double arrayAverage(double... vars){
    double sum = 0;
    for (int i = 0; i < vars.length; ++i){
      sum += vars[i];
    }
    return sum/vars.length;
  }
  public static char returnGradeLetter(double value){
    char gradeLetter = '\0';
    if (value >= 90){
      gradeLetter = 'A';
    }
    else if (value >= 80){
      gradeLetter = 'B';
    }
    else if (value >= 70){
      gradeLetter = 'C';
    }
    else if (value >= 60){
      gradeLetter = 'D';
    }
    else if (value >= 0){
      gradeLetter = 'F';
    }
    else{
      gradeLetter = '!'; //denote bad input falling through -- should never happen.
    }
    return gradeLetter;
  }
}

/*
 * Welcome to DrJava.  Working directory is C:\Users\Jguo.HS-C24-S-06\Downloads\homework-master\homework-master
> run letterGrades
Please enter your grades (separated by spaces and/or commas). 
 [DrJava Input Box]
java.lang.IllegalArgumentException 
You did not enter a valid set of grades. Each grade must be in valid numbers and between 0 and 100.
 
Please enter your grades (separated by spaces and/or commas). 
 [DrJava Input Box]
java.lang.IllegalArgumentException 
You did not enter a valid set of grades. Each grade must be in valid numbers and between 0 and 100.
 
Please enter your grades (separated by spaces and/or commas). 
 [DrJava Input Box]
java.lang.IllegalArgumentException 
You did not enter a valid set of grades. Each grade must be in valid numbers and between 0 and 100.
 
Please enter your grades (separated by spaces and/or commas). 
 [DrJava Input Box]
30 
40 
50 
Your 1st grade was: 30.00% 
Your 2nd grade was: 40.00% 
Your 3rd grade was: 50.00% 
Your grade average was: 40.00%
Your letter grade was: F 
> run letterGrades
Please enter your grades (separated by spaces and/or commas). 
 [DrJava Input Box]
30 
40 
50 
Your 1st grade was: 30.00% 
Your 2nd grade was: 40.00% 
Your 3rd grade was: 50.00% 
Your grade average was: 40.00%
Your letter grade was: F 
> run letterGrades
Please enter your grades (separated by spaces and/or commas). 
 [DrJava Input Box]
30 
40 
50 
Your 1st grade was: 30.00% 
Your 2nd grade was: 40.00% 
Your 3rd grade was: 50.00% 
Your grade average was: 40.00%
Your letter grade was: F 
> */
