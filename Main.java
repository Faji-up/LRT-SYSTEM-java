package Lrt;

import java.util.Scanner;

public class Main {

  public static void print(Object val) {
    System.out.print(val);
  }

  public static void println(Object val) {
    System.out.println(val);
  }
  
  public static void newline(){
    System.out.println();
  }
  
  public static void line(){
    System.out.println("================================================");
  }

  public static int scan_I() {
    Scanner scan = new Scanner(System.in);

    return scan.nextInt();
  }

  public static String scan_S() {
    Scanner scan = new Scanner(System.in);

    return scan.nextLine();
  }

  public static int use_card_values[][] = {
    {13, 15, 16, 18, 19, 21, 22, 23, 25, 26, 28, 31, 33},
    {15, 13, 15, 17, 18, 19, 21, 22, 24, 25, 27, 29, 32},
    {16, 15, 13, 15, 16, 18, 19, 20, 22, 23, 26, 28, 30},
    {18, 17, 15, 13, 15, 16, 17, 19, 20, 22, 24, 26, 29},
    {19, 18, 16, 15, 13, 14, 16, 17, 19, 20, 22, 25, 27},
    {21, 19, 18, 16, 14, 13, 15, 16, 18, 19, 21, 23, 26},
    {22, 21, 19, 17, 16, 15, 13, 15, 16, 18, 20, 22, 25},
    {23, 22, 20, 19, 17, 16, 15, 13, 15, 16, 18, 20, 22},
    {25, 24, 22, 20, 19, 18, 16, 15, 13, 14, 17, 19, 22},
    {26, 25, 23, 22, 20, 19, 18, 16, 14, 13, 16, 18, 20},
    {28, 27, 26, 24, 22, 21, 20, 19, 17, 16, 13, 15, 18},
    {31, 29, 28, 26, 25, 24, 23, 22, 21, 19, 18, 15, 13},
    {33, 32, 30, 28, 27, 26, 25, 23, 21, 20, 18, 16, 13}
  };

  public static int use_single_values[][] = {
    {15, 15, 20, 20, 20, 25, 25, 25, 25, 30, 30, 35, 35},
    {15, 15, 15, 20, 20, 20, 25, 25, 25, 25, 30, 30, 35},
    {20, 15, 15, 15, 20, 20, 20, 25, 25, 30, 30, 30, 20},
    {20, 20, 15, 15, 15, 20, 20, 20, 25, 25, 30, 30, 20},
    {20, 20, 20, 15, 15, 15, 20, 20, 20, 25, 25, 30, 20},
    {25, 20, 20, 20, 15, 15, 15, 20, 20, 20, 25, 25, 20},
    {25, 25, 20, 20, 20, 15, 15, 15, 20, 20, 20, 25, 20},
    {25, 25, 25, 20, 20, 20, 15, 15, 15, 20, 20, 25, 20},
    {25, 25, 25, 25, 20, 20, 20, 15, 15, 15, 20, 25, 20},
    {30, 25, 30, 25, 25, 20, 20, 20, 15, 15, 20, 25, 25},
    {30, 30, 30, 30, 25, 25, 20, 20, 20, 15, 15, 20, 25},
    {35, 30, 30, 30, 30, 25, 25, 25, 20, 20, 15, 15, 20},
    {35, 35, 20, 30, 30, 30, 30, 25, 25, 25, 20, 15, 15}
  };
  
  public static  String[] locations = {
      "Recto",
      "Legarda",
      "Pureza",
      "V.Mapa",
      "J. Ruiz",
      "Gilmore",
      "Betty Go Belmonte",
      "Araneta Center Cubao",
      "Anonas",
      "Katipunan",
      "Santolan",
      "Marikina-Pasig",
      "Antipolo"
    };
    

  public static boolean iterator = true;
  public static int beep_Card_value = 0;
  public static int single_value;
  public static int payment;
  public static int change;
  public static double discount;
  public static int current;
  public static int destination;
  public static int bef;

  public static void main(String[] args) {

  
    println("******************* LRT 2 *******************");
    newline();
   
    do {
 
        System();              
      
    } while (iterator);
  }

  public static void use_beep_card() {
  
    payment = use_card_values[current][destination];
    if(beep_Card_value >= payment){
      beep_Card_value -= payment;
      println("Fare Price : "+payment);
      println("Your Beep Card Balance is : " + beep_Card_value );
    }else{
      println("Insufficient Balance ");
      newline();
      println("Do you want to load beep card?");
      print("[0] Yes [1]No : ");
      int choice = scan_I();
      newline();
      if(choice == 0){
        load_beep_card();
      }else if(choice == 1){
       println("Do you want to use single journey?");
       print("[0] Yes [1]No : ");
       
       int chc = scan_I();
       if(chc == 0){
         try{
           println("Proceeding to Single Journey");
           Thread.sleep(500);
           
           
         }catch(InterruptedException e){
           println(e);
         }
         use_single_journey();
       }else if(choice == 1){
        System();
        }
      }else{
        println("Invalid Choice ! ");
        System();
      }
      newline();
      
    }
   
  }

  public static void use_single_journey() {
    payment = use_single_values[current][destination];
    
    line();
    newline();
    
    print("Enter Amount : ");
    single_value = scan_I();
    newline();
    if(single_value >= payment){
       println("Please Enter Your Age: ");
       print(">> ");
       int age = scan_I();
       
       if(age >= 60){
         discount = 0.2 * payment ;
         bef = payment;
         payment -= (int)discount ;
         
         change = single_value - payment;
         single_value -= payment;
         newline();
         
         println("Fare Price : "+ bef);
         println("Discount : " + discount);
         println("Payment : " + payment);
         println("Change Amount : " + change);
          
         
       }else{
         change = single_value - payment;
         single_value -= payment;
         newline();
         println("Fare Price : "+payment);
         println("Discount : " + discount);
        println("Change Amount : " + change);
         
       }
       
       
      
    }else{
      println("Oops! It looks like your payment is a bit short.\nPlease make sure the amount entered meets or exceeds the required payment.");
      println("Try Again");
      newline();
      
      System();
      line();
    }
    
    
  }

  
  

  public static void load_beep_card() {
    line();
    newline();
    
    print("Enter Amount : ");
    beep_Card_value = scan_I();
    newline();
    
    try{
      println("Load Beep Card Please Wait...");
      Thread.sleep(800);     
      
    }catch (InterruptedException e){
      print(e);
    }
    
    use_beep_card();
  }
  
  public static void System(){
         
       int id = 0;
       println("Locations / Terminals  ");
       newline();
      for(String locate:locations){
      
         println("[" + id + "] " + ": " + locate);
         id += 1;
      }
      line();
      newline();
      newline();
      
      print("Choose Your Current Location : ");
      current = scan_I();
      newline();
      
      print("Choose Your Destination : ");
      destination = scan_I();
      newline(); 
        
      if(current > 13 || destination > 13){
        println("Invalid Choice ! ");
        System();
      }  
      line();
    
      
      println("Payment Options");
      newline();
      
      println("[0] : Beep Card");
      println("[1] : Single Journey");
      newline();
      newline();
      
      print(">>> ");
      int choice = scan_I();
      if(choice == 0){
        use_beep_card();
      }else if(choice == 1){
        use_single_journey();
      }else{
        println("Invalid Choice ! ");
        System();
      }  
      
      line();
      newline();
       
       println("Please Wait for the train to arrive"); 
       newline();
       
       
     
      newline();
      line();
      newline();
      
      println("Another Journey?");
      print("[0] Yes [1] Exit : ");
      choice = scan_I();
      
      if(choice == 0){
         newline();
         line();
      }else if(choice == 1){
        iterator = false;
        println("Thank You ! ");
        
      }else{
        println("Invalid Choice ! ");
        System();
      }
        
      
      
      
      
      
      
  }
}
