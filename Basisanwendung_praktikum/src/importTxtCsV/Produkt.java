package importTxtCsV;

import java.io.IOException;

import business.Fahrrädern;

public abstract class Produkt {
	

	public abstract void schliesseDatei() throws IOException;
	

	public abstract String [] leseVonDateiAus() throws IOException;
	
	
}
