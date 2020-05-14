package Ondes; 

/**
 * Type d'onde aleatoire
 * 
 * 
 * @author Odabachian Samuel
 * @version (03/01/2020)
 *  
 */



import java.lang.Math;
public class FormeAleatoire extends FormeOnde{

	
	/**
	 * Constructeur par defaut sans paramettre
	 */
	public FormeAleatoire() {
		
		super();
	}
	
	/**
	 * Cree un nouvelle forme Aleatroir personnalise
	 * 
	 * @param f est la frequance
	 * @param fe est la frequance 
	 */
	public FormeAleatoire(double f, double fe) {
		
		super(f,fe);
	}
	
	
	/**
	 * Constructeur par copie
	 * 
	 * @param f est l'objet FormeAleatoire 
	 */
	public FormeAleatoire(FormeAleatoire f) {
		
		super(f);
	}
	
	/**
	 * Calcule pour trouver echantillon de l'onde en queston
	 * 
	 * @param i est ieme fois que la fonction va etre appeler
	 * @return Retourne le ième échantillon de la forme d’ondes.
	 */
	public double echantillon(int i) {
		
		return 2 * Math.random() - 1;
		
		
	}
}
