package txtimport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends ProductTxt {
	
	BufferedReader bf;
	
	
	
	
	public ConcreteProductB() throws IOException {
		super();
		this.bf = new BufferedReader(new FileReader("datei.txt"));
	}




	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		
		String[] ergebnisZeile = new String[5];
		String zeile = bf.readLine();
		int i = 0;
		while(i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = bf.readLine();
			i++;
		}
		bf.close();
		
		
		return ergebnisZeile;
	
	}

}
