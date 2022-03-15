// Declaring class healSpell
class healSpell{
  // Initializing static variable 
  private static int HEAL_INDEX = 2; 
  
  // Defining heal method 
  public static void heal(Microb m){
    // Heal given microb 
    if (m.getEvoLived() > 10){
      m.heal(HEAL_INDEX-1);
    }
    else {
      m.heal(HEAL_INDEX);
    }

  } // End of heal method
  
} // End of class healSpell