package reality.Criterios;

import reality.ElementoReality;


public class CriterioGenero extends Criterio{

	private String genero;
	
	public CriterioGenero(String g){
		this.genero = g;
	}
	
	public String getGenero() {
		return genero;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.contieneGeneros(genero);
	}

	
}
