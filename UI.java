// Importing Java Scanner class
import java.util.Scanner;

// Declaring class UI
class UI {
  // Declaring/Initializing instance variables
  private Incubator inc = new Incubator();
  private Scanner scanner = new Scanner(System.in);
  private int FSToCreate;
  private int FMToCreate; 
  private int GFToCreate;
  private String input;
  private boolean inputValid = false;

  // Defing interact method
  public void interact(){
    // Create microbs based on user input and then run simulations
    defineMicrobs();
    runEvo();
  }

  private void defineMicrobs(){
    // Welcome user and ask how much microbs of each type to create, create the microbs
    System.out.println(String.format("%60s", "Welcome to MicrobSimualtor!"));
    System.out.println(String.format("%60s", "---------------------------\n"));
    do {
      try {
        System.out.print("How much GlobuFiss would you like to start of with? \n> ");
        GFToCreate = Integer.parseInt(scanner.nextLine());
        System.out.print("How much FungiMeris would you like to start of with? \n> ");
        FMToCreate = Integer.parseInt(scanner.nextLine());
        System.out.print("How much FlungSils would you like to start of with? \n> ");
        FSToCreate = Integer.parseInt(scanner.nextLine());
        inc.createMicrobs(GFToCreate, FMToCreate, FSToCreate);
        inputValid = true;
      }
      catch (NumberFormatException e){
        System.out.println("\nOps...\nPlease try again, be sure to enter integers only!\n");
      }
    } while (!inputValid);
    System.out.println("Incubator created"); 
    System.out.println(String.format("%60s", "---------------------------"));
  }

  // Defining runEvo method
  private void runEvo(){
    // Forever untill user exits program run evolutions on enter key-press
    while(true){
      System.out.print("\nHit enter to run an evolution or: \nv: Display information about every microb \nq: Exit program \n> ");
     input = scanner.nextLine(); 
      if (input.equals("q")) {
        System.out.println("Shutting down");
        System.exit(0);
      } // End of if statment 
      else if (input.equals("v")){          
        System.out.println("Displaying information about every living microb...");
        System.out.print(inc.displayMicrobsStats()); 
      } // End of else if statment
      else if (input.equals("")){     
        inc.act();
        if (inc.isAWinner() != null){
          System.out.println(String.format("%60s", "---------------------------\n"));
          System.out.println( inc.isAWinner().getName() + " is the super-microb!!!");
          System.exit(0);
        } // End of if statment
  
      } // End of else if statment
      else {
        System.out.println("\nOps...\nPlease try again, be sure to give a valid input!");
        System.out.println(input);
      } // End of else statemn
      
    } // End of while loop
    
  } // End of runEvo method
  
} // End of class UI