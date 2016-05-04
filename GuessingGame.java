import java.util.Random;
import java.util.Scanner;

public class GuessingGame{
  public static void main(String[] args){
    Random randomGenerator = new Random();
    Scanner input = new Scanner(System.in);    
    int randomInt = randomGenerator.nextInt(10);
    int userInt = 0;
    boolean loopBool = false;
    while (!loopBool){
      System.out.println("Please enter a valid numeric guess.");
      while (!input.hasNextInt()){
        System.out.println("You did not enter a valid number. Try again.");
        input.next();
      }
      userInt = input.nextInt();
      if (userInt == randomInt){
        loopBool = true;
        System.out.println("Your guess: " + userInt + "\nYour guess is correct!\n");
      }
      else if (userInt > randomInt){
        System.out.println("Your guess: " + userInt + "\nYour guess was too high -- guess lower.\n");
      }
      else if (userInt < randomInt){
        System.out.println("Your guess: " + userInt + "\nYour guess was too low -- guess higher.\n");
      }
      else{
        System.out.println("Input leaked through.");
      }
    }
    input.close();
  }
}

/*
C:\Users\mguo1\Downloads>java GuessingGame
Please enter a valid numeric guess.
dsjk
You did not enter a valid number. Try again.
dsaj
You did not enter a valid number. Try again.
jlew
You did not enter a valid number. Try again.
1290
Your guess: 1290
Your guess was too high -- guess lower.

Please enter a valid numeric guess.
38
Your guess: 38
Your guess was too high -- guess lower.

Please enter a valid numeric guess.
27
Your guess: 27
Your guess was too high -- guess lower.

Please enter a valid numeric guess.
10
Your guess: 10
Your guess was too high -- guess lower.

Please enter a valid numeric guess.
9
Your guess: 9
Your guess was too high -- guess lower.

Please enter a valid numeric guess.
8
Your guess: 8
Your guess is correct!
*/