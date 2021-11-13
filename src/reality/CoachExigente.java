package reality;

import Criterios.Criterio;

public class CoachExigente extends Coach {


	private Criterio c;


	public CoachExigente(String nombre, Criterio c) {
		super(nombre);
		this.c = c;
	}

	@Override
	public void add(ElementoReality p){
		if (c.cumple(p)) {
			super.add(p);
		}
	}

}
