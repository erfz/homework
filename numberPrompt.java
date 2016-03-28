// Jason Guo

import java.util.Scanner;

public class numberPrompt{
  public static void main (String[] args){
    int numberInput=0;
    String romanNumeral = "";
    boolean getInputBoolean = false;
    Scanner input = new Scanner(System.in);
    while (!getInputBoolean){
      try{
        System.out.println("Please enter an integer between 1 and 10");
        numberInput = input.nextInt();
        if (numberInput >= 1 && numberInput <= 10){
          getInputBoolean = true;
          switch (numberInput){
            case 1: romanNumeral = "I";
            break;
            case 2: romanNumeral = "II";
            break;
            case 3: romanNumeral = "III";
            break;
            case 4: romanNumeral = "IV";
            break;
            case 5: romanNumeral = "V";
            break;
            case 6: romanNumeral = "VI";
            break;
            case 7: romanNumeral = "VII";
            break;
            case 8: romanNumeral = "VIII";
            break;
            case 9: romanNumeral = "IX";
            break;
            case 10: romanNumeral = "X";
            break;
          }
        }
        else{
          System.out.println("\nYou did not enter an integer in this range");
          input.nextLine();
        }
      }
      catch (Exception e){
        System.err.println(e);
        System.out.println("\nYou did not enter a valid integer input.");
        input.nextLine();
      }
    }
    input.close();
    System.out.println("The number you inputted was: " + numberInput + ".");
    System.out.println("The corresponding Roman Numeral is: " + romanNumeral + ".");
  }
}

/*
 * Welcome to DrJava.  Working directory is F:\Current\Computer Science
 > run numberPrompt
 Please enter an integer between 1 and 10 
 [DrJava Input Box]
 java.util.InputMismatchException 
 
 You did not enter a valid integer input. 
 Please enter an integer between 1 and 10 
 [DrJava Input Box]
 java.util.InputMismatchException 
 
 You did not enter a valid integer input. 
 Please enter an integer between 1 and 10 
 [DrJava Input Box]
 The number you inputted was: 5. 
 The corresponding Roman Numeral is: V. 
 > */



