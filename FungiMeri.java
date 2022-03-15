// Importing Java ArrayList and Random classes
import java.util.ArrayList;
import java.util.Random;
  
// Declaring class FungiMeri extending from abstract class Microb
class FungiMeri extends Microb {
  // Initializing static variable
  static private int objNumber = 0;
  
  // Defining overloaded constructor
  public FungiMeri(ArrayList<Microb> fellowMicrobs){
    // Assign values to instance variables and increment objNumber
    super(fellowMicrobs, 10, 15);
    this.name = this.name + String.valueOf(objNumber);
    objNumber++;
  } // End of overloaded constructor
  
} // End of class FungiMeri extending from abstract class Microb