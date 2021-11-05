package reality.Criterios;

import reality.ElementoReality;

public class CriterioEdad extends Criterio {

	final int EDAD = 18;
	
	public CriterioEdad(){
		
	}
	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.getEdad() > EDAD;
	}

}
