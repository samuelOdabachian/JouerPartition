package Ondes; 

/**
 * Type d'onde carree
 * 
 * 
 * @author Odabachian Samuel
 * @version (03/01/2020)
 *  
 */

public class FormeCarre extends FormeOnde{

	/**
	 * Constructeur par defaut sans paramettre
	 */
    public FormeCarre() {
        
        super();
    
    }
    
    /**
	 * Cree un nouvelle forme carree personnalise
	 * 
	 * @param f est la frequance
	 * @param fe est la frequance 
	 */
    public FormeCarre(double f, double fe) {
        
        super(f,fe);
    
    }
    
    
    /**
	 * Constructeur par copie
	 * 
	 * @param f est l'objet FormeCarre 
	 */ 
    public FormeCarre(FormeCarre f) {
        
        super(f);
    }
    
    
    /**
	 * Calcule pour trouver echantillon de l'onde en queston
	 * 
	 * @param i est ieme fois que la fonction va etre appeler
	 * @return Retourne le ième échantillon de la forme d’ondes.
	 */
    public double echantillon(int i) {
        
        //Reste du division
        double r;
        double periode = MathDesOndes.periode(super.getFrequenceEchantillonnage());
        
        
        r = Math.IEEEremainder(i/super.getFrequenceEchantillonnage(),periode);
        
        if( r < 0){
           r += periode;
        }
        
        if(r < periode/2){
         r = 1.0;   
        }
        else{
            r = -1.0;
        }
        return r; 
        
        
    }
    
}
