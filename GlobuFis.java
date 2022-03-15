// Importing Java ArrayList and Random classes
import java.util.ArrayList;
import java.util.Random;

// Declaring class GlobuFis extending from abstract class Microb
class GlobuFis extends Microb {  
  // Initializing static variable
  static private int objNumber = 0;
  
  // Defining overloaded constructor
  public GlobuFis(ArrayList<Microb> fellowMicrobs){
    // Assign values to instance variables and increment objNumber
    super(fellowMicrobs, 15, 20); //<- last two values will be overriden
    this.health = determineHealth();
    this.name = this.name + String.valueOf(objNumber);
    objNumber++;
  } // End of overloaded constructor 
  
} // End of class GlobuFis extending from abstract class Microb