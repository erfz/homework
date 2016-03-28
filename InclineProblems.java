import java.util.Scanner;

public class InclineProblems{
  public static void main (String [] args){
    double theta;
    double f_g;
    double f_n;
    double f_a;
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the angle of incline from the horizontal");
    theta = in.nextDouble();
    System.out.println(theta);
    in.close();
  }
}