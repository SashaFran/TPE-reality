package reality;

import reality.Criterios.Criterio;

public class CoachExigente extends Coach {

	private Criterio c;
	
	public CoachExigente(String nombre, String apellido, Criterio c) {
		super(nombre, apellido);
		this.c = c;
	}
	
	public void addAlEquipo(ElementoReality p){
		if (c.cumple(p)) {
			super.addAlEquipo(p);
		}
	}

	
}
