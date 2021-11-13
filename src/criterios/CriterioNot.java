package Criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Los anteriores son algunos ejemplos de los listados que la producción le pide
constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
como combinación lógicas de los existentes...
 */

import reality.ElementoReality;

public class CriterioNot extends Criterio {

	private Criterio c1;

	public CriterioNot(Criterio c1){
		this.c1 = c1;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return !c1.cumple(p1);
	}
}
