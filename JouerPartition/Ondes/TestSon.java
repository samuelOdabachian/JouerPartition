package Ondes; 

/**
 * Dans cette class, on cree des notes, on ouvre des lignes 
 * de sons pour pouvois ensuite jouer la game de DO (C4)
 * 
 * @author Samuel Odabachian
 * @version (03/01/2020)
 */


import java.lang.Thread;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
    
    public class TestSon {
    
    	/**
    	 * Jouer le sont sur la ligne ouvert a la frequence 
    	 * du note desire
    	 * 
    	 * 
    	 * @param ligne sur lequel le sons va etre joué
    	 * @param nom de la note
    	 * @param niveau est le niveau du sons de la note
    	 * @param duree est la durée en ms de la note
    	 */
        public static void jouer(SourceDataLine ligne, String nom, double niveau, double duree){
            
            Note n = new Note(nom,duree);
            n.jouer(ligne, niveau);
            
        }    
        
        public static void main(String[] args) {
        
        
            
            AudioFormat audioFmt = new AudioFormat(20500, 16, 1, true, true);
            SourceDataLine ligne;
    
            try {	
    		ligne = AudioSystem.getSourceDataLine(audioFmt);
    		ligne.open(audioFmt);  
    	        Thread t = new Thread (new Runnable() {

			@Override
			public void run() {

			    // Démarre la production de son
			    ligne.start();  

			    // Joue la gamme de do majeure à une intensité de 
			    // 30% pendant une demie seconde.  Le 4 signifie
			    // la gamme au centre du piano.  C3 est plus grave et // C5 est plus aigu.
			    jouer(ligne, "C4",.3, 500);  
			    jouer(ligne, "D4",.3, 500);
			    jouer(ligne, "E4",.3, 500);
			    jouer(ligne, "F4",.3, 500);
			    jouer(ligne, "G4",.3, 500);
			    jouer(ligne, "A4",.3, 500);
			    jouer(ligne, "B4",.3, 500);
			    jouer(ligne, "C5",.3, 1000); // do plus aigu, 1 seconde

			}
		});

		
                t.start();

    
    		} catch (LineUnavailableException lue) {
    			System.out.println("# Erreur : impossible de trouver une" 
    	                          + " ligne de sortie audio au format :");
    			System.out.println("#          " + audioFmt);
    			System.exit(1);
    		}
                  
  
            
        }
        
      
    
    
    
    
}

    
    

   
