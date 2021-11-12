package Criterios;


import reality.ElementoReality;
import reality.TemaMusical;

public class CriterioTemaMusical extends Criterio{

	protected TemaMusical t;
	
	public CriterioTemaMusical(TemaMusical t){
		this.t = t;
	}
	
	
	@Override
	public boolean cumple(ElementoReality p) {
		return t.cumple(p);
		
	}
}
