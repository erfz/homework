import java.util.Scanner;

public class calculatorBMI{
  public static void main (String[] args){
    double weight = 0;
    double height = 0;
    double BMI = 0;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your weight in pounds");
    while (!input.hasNextDouble()){
      System.out.println("You did not enter a valid weight.");
      input.next();
    }
    weight = input.nextDouble();
    System.out.println("Please enter your height in inches");
    while (!input.hasNextDouble()){
      System.out.println("You did not enter a valid height.");
      input.next();
    }
    height = input.nextDouble();
    BMI = weight * 703 / (height * height);
    System.out.println("Your weight is: " + weight + "\nYour height is: " + height + "\nYour BMI is: " + BMI);
    if (BMI < 18.5){
      System.out.println("You are considered underweight.");
    }
    else if (BMI >= 18.5 && BMI <= 25){
      System.out.println("Your weight is considered optimal.");
    }
    else{
      System.out.println("You are considered overweight.");
    }
    input.close();
  }
}

/*
 * Welcome to DrJava.  Working directory is F:\Current\Computer Science
> run calculatorBMI
Please enter your weight in pounds 
 [DrJava Input Box]
Please enter your height in inches 
 [DrJava Input Box]
Your weight is: 100.0
Your height is: 50.0
Your BMI is: 28.12 
You are considered overweight. 
> */