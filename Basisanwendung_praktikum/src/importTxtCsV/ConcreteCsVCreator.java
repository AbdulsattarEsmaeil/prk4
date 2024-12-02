package importTxtCsV;

import java.io.IOException;

public class ConcreteCsVCreator extends Creator {

	@Override
	public Produkt factoryMethode() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteCsVProdukt();
	}

	
	
}
