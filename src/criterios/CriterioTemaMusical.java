package criterios;

import reality.ElementoReality;
import reality.TemaMusical;

public class CriterioTemaMusical extends Criterio{

	protected TemaMusical tema;
	
	public CriterioTemaMusical(TemaMusical tema){
		this.tema = tema;
	}

	@Override
	public boolean cumple(ElementoReality p) {
		return tema.cumple(p);
		
	}
	
}
