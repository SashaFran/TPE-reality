package reality.Criterios;

import reality.ElementoReality;

public class CriterioAND extends Criterio {
	
	private Criterio c1, c2;
	
	public CriterioAND(Criterio c1, Criterio c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	@Override
	public boolean cumple(ElementoReality p1) {
		return (c1.cumple(p1))&&(c2.cumple(p1));
	}
}
