package reality;

import criterios.Criterio;

public class CoachExigente extends Coach {

	/*
		El jurado exigente sigue existiendo solo que ahora solo permite agregar a su equipo participantes
	(solistas, grupos o bandas) que al menos toquen un determinado instrumento, conozcan ciertos idiomas
	y/o prefieran un determinado género (...) Es posible que este jurado cambie en tiempo de ejecución su
	restricción para aceptar participantes, aunque los participantes ya aceptados no se eliminan si cambia
	su preferencia por nuevos participantes.
	 */
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
