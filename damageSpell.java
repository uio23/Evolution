// Declaring damageSpell class
class damageSpell{
  // Initializing static variable
  private static int DAMAGE = 2; 

  // Defining dealDamage method
  public static void dealDamage(Microb m){
    // damage given microb
    if (m.getEvoLived() >=10) {
    m.damage(DAMAGE+2);
    }
    else {
      m.damage(DAMAGE);
    }
  } // End of dealDamage method
  
} // End of class damageSpell