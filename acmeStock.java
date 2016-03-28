// Jason Guo

public class acmeStock{
  public static void main (String[] args){
    int sharesPurchased = 1000;
    double purchasePrice = 32.87;
    double purchaseCommission = 0.02;
    
    int sharesSold = 1000;
    double salePrice = 33.92;
    double saleCommission = 0.02;
    
    System.out.println("Joe paid $" + sharesPurchased*purchasePrice + " for the stocks.");
    System.out.println("Joe paid his broker $" + sharesPurchased*purchasePrice*purchaseCommission + " when he bought the stocks.");
    System.out.println("Joe sold the stocks for $" + sharesSold*salePrice + ".");
    System.out.println("Joe paid his broker $" + sharesSold*salePrice*saleCommission + " when he sold the stocks.");
    System.out.println("Joe's net profit was $" + ((sharesSold*salePrice*(1-saleCommission))-(sharesPurchased*purchasePrice*(1+purchaseCommission))) + ".");
  }
}

/*
 Welcome to DrJava.  Working directory is F:\Current\Computer Science
 > run acmeStock
 Joe paid $32870.0 for the stocks. 
 Joe paid his broker $657.4 when he bought the stocks. 
 Joe sold the stocks for $33920.0. 
 Joe paid his broker $678.4 when he sold the stocks. 
 Joe's net profit was $-285.8000000000029. 
 > */