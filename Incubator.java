// Importing Java ArrayList and Collections classes
import java.util.ArrayList;
import java.util.Collections;

// Declaring class Incubator
class Incubator {
  // Initializing instance variable
  private ArrayList<Microb> Microbs = new ArrayList<>();
   

  
  // Defining createMicrobs method
  public void createMicrobs(int GFToCreate, int FMToCreate, int FSToCreate){
    // Initializing local variables
    int GFCreated = 0;
    int FMCreated = 0; 
    int FSCreated = 0;
    
    // Create all types of microbs in their required quantities
    for (int i = 0; i < (GFToCreate+FMToCreate+FSToCreate); i++){
      if (GFCreated < GFToCreate){
        Microbs.add(new GlobuFis(Microbs));
        GFCreated++;
      } // End of if statment 
      else if (FMCreated < FMToCreate){
        Microbs.add(new FungiMeri(Microbs));
        FMCreated++;
      } // End of else if statment 
      else if(FSCreated < FSToCreate){
        Microbs.add(new FlungSil(Microbs));
        FSCreated++;
      } // End of final else if statment
      
    } // End of for loop

  } // End of createMicrobs method

  
  // Declaring displayMicrobsStats
  public String displayMicrobsStats(){
    // Collect stats of every microb and apend them to return string
    String stats = "";
    for (Microb m : Microbs){
        stats = stats + "\n" + m.getStats();
        } // End of for loop
    stats += "\n";
    return stats;    
  } // End of displayMicrobsStats method


  // Defining updateMicrobList method
  public void updateMicrobList(){
    // Initializing local varibale
    ArrayList<Microb> toRemove = new ArrayList<>();

    // for every microb, check if its alive and if not remove it
    System.out.println("Incubator status update:");
    for (Microb m : Microbs){
        if (m.getHealth() <= 0){
         System.out.println(m.getName() + " got destroyed..."); 
        toRemove.add(m);
        } // End of if statment    
      
      }// End of for loop
    for (Microb m : toRemove){
      Microbs.remove(m);
    } // End of for loop
    if (toRemove.size() == 0){
      System.out.println("All microbs survived");
    }
    toRemove = null;
  } // End of updateMicrobList method

  public void act(){
    // Each microb decied what to do and does so, desplay effect
    updateMicrobList();
    for (Microb m : Microbs){
      if (m.getIsAlive()){      
        System.out.println(m.behave(Microbs));
        System.out.println("-");
        } // End of if statment
      } // End of for loop
    updateMicrobList();
    for (Microb m : Microbs){
      m.livedThroughEvo();
    }
  } // End of getTargets method


  // Defining isAWinner method
  public Microb isAWinner(){
    if (Microbs.size()==1){
      return Microbs.get(0);
    } // End of is statment
    return null;
  } // End of isAWinner method
  
} // End of class Incubator