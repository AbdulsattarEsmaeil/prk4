package business;

public class Fahrr�dern {
	
	
	
	
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private String Fahrradtyp;
    private int Rahmennummer;
    // Strasse und Hausnummer des Buergeramtes
    private String Mensch;
   
    // Dienstleistungen des Buergeramtes
    private String[] gr��en;

  
	public Fahrr�dern(String name, String fahrradtyp, int rahmennummer, String mensch, String[] gr��en) {
		super();
		this.name = name;
		Fahrradtyp = fahrradtyp;
		Rahmennummer = rahmennummer;
		Mensch = mensch;
		this.gr��en = gr��en;
		
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFahrradtyp() {
		return Fahrradtyp;
	}

	public void setFahrradtyp(String fahrradtyp) {
		Fahrradtyp = fahrradtyp;
	}

	public int getRahmennummer() {
		return Rahmennummer;
	}

	public void setRahmennummer(int rahmennummer) {
		Rahmennummer = rahmennummer;
	}

	public String getMensch() {
		return Mensch;
	}

	public void setMensch(String mensch) {
		Mensch = mensch;
	}

	public String[] getGr��en() {
		return gr��en;
	}

	public void setGr��en(String[] gr��en) {
		this.gr��en = gr��en;
	}

	public String getfahrradAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getGr��en().length - 1; i++) {
			ergebnis = ergebnis + this.getGr��en()[i] + trenner; 
		}
		return ergebnis	+ this.getGr��en()[i];
	}
	
	public String gibFahrradZurueck(char trenner){
  		return this.getName() + trenner 
  			+this.getFahrradtyp() + trenner
  		    + this.getRahmennummer()  + trenner
  		    + this.getMensch() + trenner
  		    + this.getfahrradAlsString(trenner);
  	}


}

