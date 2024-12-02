package gui.guifahrraeder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.sun.org.apache.bcel.internal.generic.ClassGen;
import com.sun.org.apache.bcel.internal.generic.ClassObserver;

import business.FahrradModel;
import business.Fahrrädern;
import javafx.stage.Stage;
import ownUtil.Oberserver;

public class FahrradControl implements Oberserver {

		public Fahrradview pview;
		public FahrradModel pModel;
		
		
		public FahrradControl(Stage st) {
			this.pModel = FahrradModel.getInstance();
			this.pview = new Fahrradview(this, st, pModel);
			this.pModel.addObserver(this);
		}
		
		
		
		//methoden ... 
		
		public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      				pModel.leseAusDateiM();
	      	  			pview.zeigeInformationsfensterAn(
	      	  	   			"Die Fahrrad wurden gelesen!");
	      		}
	       		else{
	       			pModel.leseAusDateiTxt();
	       			pview.zeigeInformationsfensterAn(
		   				"Die Fahrrad wurden gelesen!");
		   		}
			}
			catch(IOException exc){
				pview.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				exc.printStackTrace();
				pview.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		public void schreibeFarradtInCsvDatei() {
			try {
				pModel.schreibeFarradInCsvDateiM();
				pview.zeigeInformationsfensterAn(
		   			"Die Fahrrad wurden gespeichert!");
			}	
			catch(IOException exc){
				pview.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				exc.printStackTrace();
				pview.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}



		public void update() {
			// TODO Auto-generated method stub
			pview.zeigeFarradan();
		}



	
		
		
		
	
}
