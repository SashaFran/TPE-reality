package Criterios;

import reality.ElementoReality;

public class CriterioInstrumento extends Criterio {

	private String instrumento;
	
	public CriterioInstrumento(String instrumento){
		this.instrumento = instrumento;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.contieneInstrumento(instrumento);
	}

}
