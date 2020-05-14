package Utile;

import Musique.PieceMusicale;
import Notes.GenerateurAccord;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.util.Scanner;

/**
 * Write a description of class Fichier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fichier{
    
    
    public static PieceMusicale obtenirChanson(){
    //public static void main (String[] args) throws FileNotFoundException {	
    	PieceMusicale pm = null;
    	File file; 
    	
    	
    	JButton open = new JButton();
    	
    	//Create a file chooser
    	final JFileChooser fc = new JFileChooser();
    	
    	//Endroit de filechoser par default
    	fc.setCurrentDirectory(new java.io.File("C:/Users/client/Desktop"));
    	
    	fc.setDialogTitle("Bonjour");
    	
    	//fc.setFileSelectionMode(JFileChooser.);
    	
    	file = new File(fc.getSelectedFile().getAbsolutePath());
    	//fc.getSelectedFile().getName();
    	
    	try {
    		Scanner scanner = new Scanner(file);
    		GenerateurAccord generateur = new GenerateurAccord();
    		pm = new PieceMusicale(scanner.nextLine(),scanner.nextInt());
    		String accordScanne;
    		double dureeScanne;
    		
    		while(scanner.hasNext()) {
    			accordScanne = scanner.next();
    			dureeScanne = 
    					Conversion.BpmToMilliseconde(scanner.nextDouble());
    			
    			generateur.obtenirAccord(accordScanne,dureeScanne);
    			
    		}
    		scanner.close();
    	
    	}
    	catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	
    	//In response to a button click:
    	int returnVal = fc.showOpenDialog(open);
    	
    	return pm;
    }
}
