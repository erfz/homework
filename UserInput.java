import java.util.Scanner;

public class UserInput{
  public static void main (String [] args){
    
    Scanner input = new Scanner (System.in);
    
    System.out.println("What is your name?");
    String name = input.nextLine();
    
    System.out.println("What is your age?");
    int age = input.nextInt();
    
    System.out.println("What is your annual pay (no $ or ,)");
    double annualPay = input.nextDouble();
    
    System.out.println("My name is " + name + ", my age is " + age + "\nand I hope to earn $" + annualPay + " each year.");
    
    input.close();
    
  }
}

/*
 Welcome to DrJava.  Working directory is F:\Current\Computer Science
 > run UserInput
 What is your name? 
 [DrJava Input Box]
 What is your age? 
 [DrJava Input Box]
 What is your annual pay (no $ or ,) 
 [DrJava Input Box]
 My name is chicken, my age is 289
 and I hope to earn $9.201830198E9 each year. 
 >
 */