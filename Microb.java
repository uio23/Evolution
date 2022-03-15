// Importing Java ArrayList and Random classes
import java.util.ArrayList;
import java.util.Random;

// Declaring abstract class Microb
abstract class Microb {
  // Declaring/initializing instance variables
  protected int health;
  protected boolean isAlive;
  protected int evoLived = 0;
  protected String name;
  protected String type;
  protected Microb target;
  protected int minHealth, maxHealth;
  protected int[] behaviourBalance;

  // Defining overloaded constructctor 
  public Microb(ArrayList<Microb> fellowMicrobs, int minHealth, int maxHealth){
    // Assign values to instance variables, most are dependant on what class is calling 
    if (this.getClass().getSimpleName() == "FungiMeri") {
      this.behaviourBalance = new int[]{0, 2, 2, 2, 2, 2, 2, 1, 1, 1};
    }
    else if (this.getClass().getSimpleName() == "FlungSil"){
    this.behaviourBalance = new int[]{0, 0, 0, 1, 1, 1, 1, 1, 1, 2};
    }
    else if (this.getClass().getSimpleName() == "GlobuFis"){
      this.behaviourBalance = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 2 };
    }
    this.minHealth = minHealth;
    this.maxHealth = maxHealth;
    this.health = determineHealth();
    this.name = this.getClass().getSimpleName();
    this.type = this.getClass().getSimpleName();
  } // End of overloaded constructor 

  
  // Defining displayStats method
  public String getStats(){
    // Return a string containign all the basic stats of a microb
    return (this.name + " of type " + this.getClass().getName() + " is alive and well with " + this.health + " hp.\n The microb has lived for " + this.evoLived + " evolutions. ");
  } // End of displayStats method

  
  // Defining isAlive method
  public void checkIsAlive(){
    // Check if microb still has health remaining
    if (this.health<=0){
      this.isAlive = false;
    } // End of if statment
    else {
      this.isAlive =  true;
    } // End of else statemnt
  } // End of isAliveMethod


  // Defining determineHealth method
  public int determineHealth(){
    // Randomly generate microb's starting health within given range
    Random r = new Random();   
    return r.ints(this.minHealth, this.maxHealth+1).findFirst().getAsInt();
  } // End of determineHealth method


  // Defining getTarget method
  public Microb getTarget(ArrayList<Microb> fellowMicrobs){
    // Find weakest microb and target it
    ArrayList<Microb> withoutMe = new ArrayList<>();
    for (Microb m : fellowMicrobs){
      if(m != this){
          withoutMe.add(m);
        }
    }
    target = withoutMe.get(0);
    for (Microb m : withoutMe){
      if(m.getHealth()<target.getHealth() && m.getIsAlive()){
        target = m;
      } // End of if statment
      
    } // End of for loop
    return target;
  } // End of getTarget method


  // Defining behave method
  public String behave(ArrayList<Microb> fellowMicrobs){
    // Choose what to do during evolution, chances for every action are different amoung microbs
    Random r = new Random();
    int choice = this.behaviourBalance[r.nextInt(this.behaviourBalance.length)];
    if (choice == 0){
      return this.name + " chose to be passive";
    } // End of if statment
    else if (choice == 1){
      Microb t = getTarget(fellowMicrobs);
      damageSpell.dealDamage(t);
      String status  = (t.getIsAlive()) ? "down to " + t.getHealth() : "destroyed";
      return this.name + " chose to be aggresive, attacking " + t.getName() + " who is now " + status;
    } // End of else if statment
    else if (choice == 2){
      healSpell.heal(this);
      return this.name + " chose to heal, healing up to " + this.health + " hp";
    } // End of else if statment
    else {
      return "Error with choosing behavior, " + this.name + " is skipping the turn";
    }
  } // End of behave method


  // Defining livedThroughEvo method
  public void livedThroughEvo(){
    // Incriment evolution count
    evoLived++;
  } // End of livedThroughEvo method

  
  // Defining health- setter method
  public void damage(int amount){
    this.health -= amount;
  } // End of health- setter methdod


  // Defining health+ setter method
  public void heal(int amount) {
    this.health += amount;
  } // End of health+ setter method


  // Defining getter method
  public String getName(){
    return this.name;
  } // End of setter method

  // Definig getter method
  public int getHealth(){
    return this.health;
  } // End of getter method


  // Defining getter method
  public boolean getIsAlive(){
    this.checkIsAlive();
    return this.isAlive;
  } // End


  // Definging
  public int getEvoLived(){
    return evoLived;
  }

} // End of abstract class Microb