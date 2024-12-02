package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import importTxtCsV.ConcreteCsVCreator;

import importTxtCsV.Creator;
import importTxtCsV.Produkt;
import ownUtil.Oberservable;
import ownUtil.Oberserver;

import txtimport.ConcreteCreatorA;
import txtimport.CreatorTxt;
import txtimport.ProductTxt;


public class FahrradModel implements Oberservable {
	
	
	//observer
		private Vector<Oberserver> observers = new Vector<Oberserver>();
		
		
	Fahrrädern farradgeschäft;
	String [] fahr;
	

	private static FahrradModel instance;
	
	
	private FahrradModel() {}
	
	
	
	public static FahrradModel getInstance() {
			
			if(instance == null) {
				instance = new FahrradModel();
			}
			return instance;
		}


	
	public String[] getFahrArray() {
		return fahr;
	}


	public Fahrrädern getFarradgeschäft() {
		return farradgeschäft;
	}


	public void setFarradgeschäft(Fahrrädern farradgeschäft) {
		this.farradgeschäft = farradgeschäft;
		notifyObservers();
	}


	public void leseAusDateiTxt() throws IOException {
		
		CreatorTxt ctxt = new ConcreteCreatorA();
		ProductTxt cpro = ctxt.factoryMethode();
		this.fahr = cpro.leseAusDatei();
		notifyObservers();
		
	}
	
	
	
	public void leseAusDateiM() throws IOException {
	
				Creator ccsv = new ConcreteCsVCreator();
				Produkt pcsv = ccsv.factoryMethode();
				this.fahr = pcsv.leseVonDateiAus();
				pcsv.schliesseDatei();
				notifyObservers();
		
	}
	
	
	public void schreibeFarradInCsvDateiM() throws IOException {
		
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("fahr.csv", true));
		aus.write(getFarradgeschäft().gibFahrradZurueck(';'));
		aus.flush();
		aus.close();


		
		
	}



	@Override
	public void addObserver(Oberserver obs) {
		// TODO Auto-generated method stub

				observers.addElement(obs);
	}



	@Override
	public void removeObserver(Oberserver obs) {
		// TODO Auto-generated method stub
			observers.removeElement(obs);
	}



	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Oberserver observer : observers) {
			observer.update();
		}
	}



	
	

}
