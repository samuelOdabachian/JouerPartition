package Musique;

/**
 * Class dans lequel les information pertinente
 * d'une pière est sauvegardé pour jouer ensuite
 * la pirèce.
 *
 * @author (Samuel Odabachian)
 * @version (03/01/2020)
 */

import Notes.Accord;
import java.util.Vector;

public class PieceMusicale{
   
	// titre tel que fourni au constructeur
    private String titre;
    // rythme tel que fourni au constructeur
    private double rythme;
    // liste d'accords à étre joué
    private Vector<Accord> accords;
    
    
    /**
     * Crée un nouvelle objet Pièce Musicale
     * 
     * @param titre est le titre du chanson
     * @param rythme est le rythme du chanson
     */
    public PieceMusicale(String titre,double rythme){
        
        this.titre = titre;
        this.rythme = rythme;
        this.accords = new Vector<Accord>();
    }
    
    
    /**
     * Remplie le tableau avec des objets accords
     * 
     * @param accords est l'objet de type accord
     */
    public void addAccord(Accord accords){
        this.accords.add(accords);
    }
    
     /**
     * Permet de pauser l'application pour donner du temps à 
     * un autre processus dans un univers multitâches.
     * 
     * @param duree Le temps de la pause.
     */    
    private void pause(int duree) {
        
    	try {
    		Thread.sleep(duree);
            
    	} catch (InterruptedException e) {
            
    		e.printStackTrace();
    	}
        
    }
    
   
    /**
     * 
     * Permet de jouer un liste d'accords
     * 
     * @param accords est le tableaux d'accord a parcourir
     * @param duree est le temps en ms de chaque accord
     * 
     */
    public void jouer(Vector<Accord> accords, int duree){
        
        for (int i = 0; i < accords.size(); i++){
            
            Accord.jouer(accords.elementAt(i));
            pause(duree);
        }
        
    }
    
    
    /**
     * Avoir les nom d'accords ainsi que leurs notes
     * 
     * @return String des noms et notes d'accords.
     */
    public String toString(){

             String retour = null;
             
             for (int i = 0; i <= accords.size(); i++) {
            	 
            	 //Pour chaque accord cherche les noms des Notes
            	 retour += accords.elementAt(i).toString(); 
            	 
            	 if(i % 4 == 0) {
            		 retour += "\n";
            	 }
             }
       
             return retour;
             
     }
    
    
}
    

