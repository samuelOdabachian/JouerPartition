package Ondes; 

/**
 * Type d'onde sinus
 * 
 * 
 * @author Odabachian Samuel
 * @version (03/01/2020)
 *  
 */

import java.lang.Math;


public class FormeSinus extends FormeOnde {

public static final double PI = 3.14;   
    
	
	/**
 	* Constructeur par defaut sans paramettre
 	*/
    public FormeSinus() {
    
        super();
    }

    
    /**
	 * Cree un nouvelle forme sinus personnalise
	 * 
	 * @param f est la frequance
	 * @param fe est la frequance 
	 */
    public FormeSinus(double f, double fe) {
        
        super(f,fe);
    }

    /**
	 * Constructeur par copie
	 * 
	 * @param f est l'objet FormeSinus 
	 */
    public FormeSinus(FormeSinus f) {
    
        super(f);  
        
    
    }
    
    
    /**
	 * Calcule pour trouver echantillon de l'onde en queston
	 * 
	 * @param i est ieme fois que la fonction va etre appeler
	 * @return Retourne le ième échantillon de la forme d’ondes.
	 */
    public double echantillon(int i) {
    
        double periode =  MathDesOndes.periode(super.getFrequenceEchantillonnage());
        double r;
       
        
        r = Math.IEEEremainder((i/super.getFrequence()),periode);
        
        if(r < 0) {
            
            r += periode;
        }
    
        return Math.sin(2*PI * super.getFrequenceEchantillonnage() * r);
        
       
    }
        
}
