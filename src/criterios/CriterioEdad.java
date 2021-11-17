package criterios;

import reality.ElementoReality;

public class CriterioEdad extends Criterio {

	private int limiteEdad;
	
	public CriterioEdad(int edad){
		this.limiteEdad = edad;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.getEdad() > limiteEdad;
	}

}
