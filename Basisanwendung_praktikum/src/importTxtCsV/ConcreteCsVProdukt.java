package importTxtCsV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import business.Fahrrädern;

public class ConcreteCsVProdukt extends Produkt{

	BufferedReader bf ;
	
	
	public ConcreteCsVProdukt() throws FileNotFoundException {
		super();
		this.bf = new BufferedReader(new FileReader("fahr.csv"));
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		bf.close();
	}

	@Override
	public String [] leseVonDateiAus() throws IOException {
		
		String[] zeile = bf.readLine().split(";");
        return zeile;
        
	
	}
	    

}
