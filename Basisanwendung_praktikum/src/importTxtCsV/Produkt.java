package importTxtCsV;

import java.io.IOException;

import business.Fahrr�dern;

public abstract class Produkt {
	

	public abstract void schliesseDatei() throws IOException;
	

	public abstract String [] leseVonDateiAus() throws IOException;
	
	
}
