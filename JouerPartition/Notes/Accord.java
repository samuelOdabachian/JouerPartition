package Notes;
 

/**
 * 
 * Les attributs d'un accord pour pouvoir le jouer
 * ensuite se retrouvent ici.
 * 
 * @author Odabachian Samuel
 * @version (03/01/2020)
 * 
 */



import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import Ondes.Note;
import Ondes.TestSon;


public class Accord {

public static final int NB_MAX_NOTES_ACCORD = 7;

    private String nomAccord;
    private Note []tabNote;
    
    /**
     * constructeur par defaut sans paramettre
     */
    public Accord() {
        
    	nomAccord = null;
    	tabNote = new Note[NB_MAX_NOTES_ACCORD];
    }
    
    /**
     * constructeur par defaut avec paramettre
     * 
     * @param nomAccord est le nom de l'accord (Majeur/mineur)
     * @param tabNote est les notes qui constituent l'accord
     */
    public Accord (String nomAccord,  Note tabNote[]) {
        
        this.nomAccord = nomAccord;
        this.tabNote = tabNote;
        
    }
        
    
    /**
     * Muttateur du nom d'accord.
     * 
     * @param a est le nom d l'accord.
     */
    public void setAccord(String a) {
        
        nomAccord = a;
    }
    
    
    /**
     * Muttateur des notes dans l'accord.
     * 
     * @param n est le note a mettre.
     * @param position est l'index du tableau à remplire.
     */
    public void setNote(Note n, int position) {
        
        tabNote[position] = n;
    }
    
    
    /**
     * Accesseur du nom D'accord.
     * 
     * @return le nom de l'accord.
     */
    public String getAccord() {
        
        return nomAccord;
    }
    
    
    /**
     * Accesseur des objets Note d'un tableux.
     * 
     * @param position est l'index de laquel la note est désiré.
     * @return l'objet Note.
     */
    public Note getNote(int position) {
        
    		return tabNote[position];
    	
    }
    
    
    /**
     * Accesseur d' nom de la note.
     * 
     * @param position est l'index de laquel la note est désiré.
     * @return le nom de la note.
     */
    public String getNomNote(int position) {
    	
    	return tabNote[position].getNom_();
    	
    }
    
    
    /**
     * Compter le nombre element dans un tableau
     * 
     * @return Nombre d'élements du tableau. 
     */
    public int size() {
    	
    	int size = tabNote.length;
    	
    	return size;
    }
    
    /**
     * Verification de l'égalité des objets.
     *   
     * @param arg0 est l'accord a comparer.
     * @return vrai si les accords sont les mêmes.
     */
    public boolean equals(Accord arg0) {
        
        return nomAccord == arg0.nomAccord;
    }
    
    
    /**
     * cree des lignes dependant de nbr de note voulant jouer.
     * 
     * @param accord est la sequence des notes a jouer.
     */
    public static void jouer(Accord accord) {
        
        AudioFormat audioF = new AudioFormat(20500, 16, 1, true, true);
        //ArrayList<SourceDataLine> tabLignes = new ArrayList<SourceDataLine>();
        SourceDataLine ligne [] = new SourceDataLine[NB_MAX_NOTES_ACCORD];
        //SourceDataLine ligne;
       
        
        for( int i = 1; i <accord.size(); i++) {
            
            try {
            
                ligne[i] = AudioSystem.getSourceDataLine(audioF);
                ligne[i].open(audioF); 
                //tabLignes.add(i,ligne);
                //line[i] = ligne;
            
            } catch (LineUnavailableException lue) {
                System.out.println("# Erreur : impossible de trouver une "
                                   + " ligne de sortie audio au format :");
                System.out.println("#          " + audioF);
                System.exit(1);
            }
            
        } 
            
        for( int i = 0; i < accord.size(); i++){ 
            int j = i;
            Thread t = new Thread(new Runnable(){
                                
            @Override
            public void run() {
                        
   
                 ligne[j].start();
                   
                 TestSon.jouer(ligne[j],accord.getNomNote(j),.3, 500.0);
                 
                }

            });

                // Démarrage du Thread.
            t.start();
        }
            
        
    }
            
    
  //avec getAccord
    
    public String toString(){
	  
    	String retour= "Nom de l'accord :" + this.getAccord() + "\n" 
    			+ "Notes";
    	
    	for (int i = 0 ; i< tabNote.length; i++) {
	   	 retour +=   " "  + this.getNote(i).toString(); 
    	}
    	return retour;
   }
   
   
    
}
