// Jason Guo

import java.util.Scanner;

public class salesTax{
  public static void main (String [] args){
    
    double stateSalesTax = 0.04;
    double countySalesTax = 0.02;
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter the purchase price: ");
    double purchasePrice = input.nextDouble();
    input.close();
    double totalPrice = purchasePrice + purchasePrice*(stateSalesTax + countySalesTax);
    
    System.out.println("Purchase price: $" + purchasePrice);
    System.out.println("State sales tax: $" + purchasePrice*stateSalesTax);
    System.out.println("County sales tax: $" + purchasePrice*countySalesTax);
    System.out.println("Total sales tax: $" + purchasePrice*(stateSalesTax + countySalesTax));
    System.out.println("Total sale: $" + totalPrice);
  }
}

/*
 Welcome to DrJava.  Working directory is F:\Current\Computer Science
 > run salesTax
 Enter the purchase price:  
 [DrJava Input Box]
 Purchase price: $10.0 
 State sales tax: $0.4 
 County sales tax: $0.2 
 Total sales tax: $0.6 
 Total sale: $10.6 
 > */