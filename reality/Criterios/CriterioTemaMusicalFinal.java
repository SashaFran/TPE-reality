package reality.Criterios;

import java.util.ArrayList;

import reality.ElementoReality;
import reality.TemaMusical;

public class CriterioTemaMusicalFinal extends CriterioTemaMusical {

	
	public CriterioTemaMusicalFinal(TemaMusical t) {
		super(t);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public boolean cumple(ElementoReality p) {
		if(super.cumple(p)){
			ArrayList<String> insP = p.getInstrumentos();
	//		ArrayList<String> insTM = t.getInstrumentos();
		}
		return false;
	}

}
