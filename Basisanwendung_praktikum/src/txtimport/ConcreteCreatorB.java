package txtimport;

import java.io.IOException;

public class ConcreteCreatorB extends CreatorTxt{

	@Override
	public ProductTxt factoryMethode() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteProductB();
	}
	
	


	
}
