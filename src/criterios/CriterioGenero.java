package criterios;

import reality.ElementoReality;

public class CriterioGenero extends Criterio{

	private String genero;
	
	public CriterioGenero(String genero){
		this.genero = genero;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.contieneGenero(genero);
	}

	
}
