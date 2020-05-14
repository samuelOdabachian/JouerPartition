package Ondes; 
/**
 * Tous les methode de calcule mathematique 
 * et conversion d'onde se trouvent ici.
 *
 * @author (Odabachian Samuel)
 * @version (03/01/2020)
 */
public class MathDesOndes{
    
    
    /**
     * Calcule de la periode d'onde.
     * 
     * @param frequanceEchantillonage du note en question
     * @return la periode calculee.
     */
    public static double periode (double frequanceEchantillonage){
        
        return 1/frequanceEchantillonage;
    }
}
