package Ondes; 

/**
 * N'importe quel type d'onde est definis par sa frequance et frequance d'echantillonage
 * 
 * 
 * @author Odabachian Samuel
 * @version (03/01/2020)
 * 
 */


public class FormeOnde {

	// Freqence de la note en question en Hertz
    private double frequence;
    
    // pour la transformation d’un signal analogique en un signal numérique (en Hertz)
    private double frequenceEchantillonnage;
    
     
    /**
     * Cree une nouvelle Onde
     */
    public FormeOnde() {
    	frequence = 0;
    	frequenceEchantillonnage = 0;
        
    }
    
    
    /**
     * Cree une nouvelle onde avec paramettre personnel
     * 
     * 
     * @param frequenceEchantillonnage est celui trouver pour transformer la note en question
     * @param frequence est celui du note en question
     */
    public FormeOnde(double frequence, double frequenceEchantillonnage) {
    	this.frequence = frequence;
    	this.frequenceEchantillonnage = frequenceEchantillonnage;
      
    }
    
    
    /**
     * Constructeur par copie
     * @param f est l'objet FormeOnde deja cree
     */
    public FormeOnde( FormeOnde f) {
        this(f.frequence,f.frequenceEchantillonnage);
    }
    
    
    /**
     * Accesseur du Freqence 
     * 
     * @return la Freqence de la note
     */
    public double getFrequence() {
        
        return frequence;
    }
    
    
    /**
     * Accesseur du Freqence d'echantillonage
     * 
     * @return la Freqence d'echantillonage de la note
     */
    public double getFrequenceEchantillonnage() {
        
        return frequenceEchantillonnage;
    }
    

}
