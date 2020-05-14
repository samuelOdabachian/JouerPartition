package Ondes;  

/**
 * Type d'onde triangle
 * 
 * 
 * @author Odabachian Samuel
 * @version (03/01/2020)
 *  
 */


public class FormeTriangle extends FormeOnde{

	
	
	
	/**
	 * Constructeur par defaut sans paramettre
	 */
	public FormeTriangle() {
		
		super();
	}
	
	
	/**
	 * Cree un nouvelle forme triangle personnalise
	 * 
	 * @param f est la frequance
	 * @param fe est la frequance 
	 */
	public FormeTriangle(double f, double fe) {
		
		super(f,fe);
	}
	
	/**
	 * Constructeur par copie
	 * 
	 * @param f est l'objet FormeTriangle
	 */
	public FormeTriangle(FormeTriangle f) {
		
		super(f);
	}
	
	
	/**
	 * Calcule pour trouver echantillon de l'onde en queston
	 * 
	 * @param i est ieme fois que la fonction va etre appeler
	 * @return Retourne le ième échantillon de la forme d’ondes.
	 */
	public double echantillon(int i) {
		
		double periode = MathDesOndes.periode(super.getFrequenceEchantillonnage());
		// reste du division
		double r;
		double valeur;
		
		r = Math.IEEEremainder((i/super.getFrequenceEchantillonnage()),periode);
		
		if (r < 0) {
			
			valeur = r + periode;
		}
		else if (r <= periode/4) {
			
			valeur = r * 4/periode;
		}
		else if(r <= 3*periode/4) {
			
			r-= periode/4;
			valeur = 1 - r * 4/periode;
		}
		
		else {
			
			r -= 3*periode/4;
			valeur = -1 + r * 4/periode;
		}
		
		return valeur;
		
		
		
		
	}
	
}
