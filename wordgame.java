// Jason Guo

import java.util.Scanner;

public class wordgame{
  public static void main (String [] args){
    Scanner chicken = new Scanner(System.in);
    System.out.println("What is your age?");
    int age = chicken.nextInt();
    chicken.nextLine();
    System.out.println("What is your name?");
    String name = chicken.nextLine();
    System.out.println("What is the name of a city you can think of?");
    String city = chicken.nextLine();
    System.out.println("What is the name of a college you can think of?");
    String college = chicken.nextLine();
    System.out.println("What is the name of a profession you can think of?");
    String profession = chicken.nextLine();
    System.out.println("What is a type of animal you can think of?");
    String animal = chicken.nextLine();
    System.out.println("What is a pet's name?");
    String petName = chicken.nextLine();
    
    System.out.println("There once was a person named " + name + " who lived in " + city + ". At the age of " + age + ", " + name + " graduated and went to college at " + college + ". "+ name +" graduated and went to work as a " + profession + ". Then, "+name+" adopted a(n) " + animal + " named " + petName + ". They both lived happily ever after.");
    chicken.close();
  }
}

/*
 Welcome to DrJava.  Working directory is F:\Current\Computer Science
 > run wordgame
 What is your age? 
 [DrJava Input Box]
 What is your name? 
 [DrJava Input Box]
 What is the name of a city you can think of? 
 [DrJava Input Box]
 What is the name of a college you can think of? 
 [DrJava Input Box]
 What is the name of a profession you can think of? 
 [DrJava Input Box]
 What is a type of animal you can think of? 
 [DrJava Input Box]
 What is a pet's name? 
 [DrJava Input Box]
 There once was a person named Jason who lived in East Brunswick. At the age of 15, Jason graduated and went to college at Harvard. Jason graduated and went to work as a Professor. Then, Jason adopted a(n) Chicken named Gobble. They both lived happily ever after. 
 > */
