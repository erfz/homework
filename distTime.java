import java.util.Scanner;

public class distTime{
  public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    int hours = 0;
    double speed = 0;
    boolean loopBool = false;
    while (!loopBool){
      System.out.println("Please the speed in miles per hour");
      while (!input.hasNextDouble()){
        System.out.println("You did not enter a valid speed.");
        input.next();
      }
      speed = input.nextDouble();
      System.out.println("Please enter the number of hours traveled for.");
      while (!input.hasNextInt()){
        System.out.println("You did not enter a valid number of hours.");
        input.next();
      }
      hours = input.nextInt();
      if (hours > 0 && speed > 0){
        loopBool = true;
      }
    }
    input.close();
    System.out.println("Hour        Distance");
    for (int i = 1; i <= hours; ++i){
      System.out.println(i + "           " + (i*speed));
    }
  }
}

/* Welcome to DrJava.  Working directory is F:\Current\Computer Science
> run distTime
Please the speed in miles per hour 
 [DrJava Input Box]
Please enter the number of hours traveled for. 
 [DrJava Input Box]
Hour        Distance 
1           50.0 
2           100.0 
3           150.0 
> */