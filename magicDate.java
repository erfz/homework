import java.util.Scanner;

public class magicDate{
  public static void main(String[] args){
    int month = 0;
    int day = 0;
    String year = "";
    Scanner input = new Scanner(System.in);
    while (true){
      try{
        System.out.println("Please enter a month in numeric form");
        month = input.nextInt();
        System.out.println("Please enter a day in numeric form");
        day = input.nextInt();
        System.out.println("Please enter a two-digit year");
        if (input.hasNextInt()){
          year = input.next();
        }
        else{
          throw new java.util.InputMismatchException();
        }
        break;
      }
      catch(Exception e){
        System.err.println(e);
        System.out.println("\nOne of your inputs was not valid.");
        input.next();
      }
    }
    input.close();
    System.out.println("\nYour month is: " + month + "\nYour day is: " + day + "\nYour year is: " + year);
    System.out.println("Your date is: " + month + "/" + day + "/" + year);
    if (month * day == Integer.parseInt(year)){
      System.out.println("Your date is magic.");
    }
    else{
      System.out.println("Your date is not magic.");
    }
  }
}

/*
 * Welcome to DrJava.  Working directory is F:\Current\Computer Science
> run magicDate
Please enter a month in numeric form 
 [DrJava Input Box]
Please enter a day in numeric form 
 [DrJava Input Box]
java.util.InputMismatchException 

One of your inputs was not valid. 
Please enter a month in numeric form 
 [DrJava Input Box]
Please enter a day in numeric form 
 [DrJava Input Box]
Please enter a two-digit year 
 [DrJava Input Box]

Your month is: 8
Your day is: 2
Your year is: 16 
Your date is: 8/2/16 
Your date is magic. 
> */