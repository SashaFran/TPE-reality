package reality;

import criterios.Criterio;

public class CoachExigente extends Coach {

	private Criterio c;

	public CoachExigente(String nombre, Criterio c) {
		super(nombre);
		this.c = c;
	}

	public void setC(Criterio c) {
		this.c = c;
	}

	@Override
	public boolean add(ElementoReality p){
		if (c.cumple(p)) {
			super.add(p);
			return true;
		} else {
			return false;
		}
	}

}
