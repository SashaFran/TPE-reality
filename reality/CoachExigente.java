package reality;

import reality.Criterios.Criterio;

public class CoachExigente extends Coach {

	private Criterio c;
	
	public CoachExigente(String nombre, String apellido, Criterio c/*, String instrumento, String idioma, String genero*/) {
		super(nombre, apellido);
		this.c = c;
	}
	
	public void addAlEquipo(Participante p){
		if (c.cumple(p)) {
			super.addAlEquipo(p);
		}
	}

	
}
