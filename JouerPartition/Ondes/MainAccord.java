package Ondes;

import Notes.Accord;
import Notes.GenerateurAccord;


public class MainAccord {

	public static void main(String[] args) {
	
		GenerateurAccord g = new GenerateurAccord();
		//Note n = new Note("C4",500.0);
		
	    Accord C = g.obtenirAccord("C", 500.0);
		/*Accord Dm = new Accord();
		Accord Em = new Accord();
		Accord F = new Accord();
		Accord G = new Accord();
		Accord Am = new Accord();
		Accord B7 = new Accord();*/
		
		System.out.println( g.obtenirAccord("Cm", 500.0));
		//Accord.jouer(C);
	}

}
