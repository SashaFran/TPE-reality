package Criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Los anteriores son algunos ejemplos de los listados que la producción le pide
constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
como combinación lógicas de los existentes...
 */
import reality.ElementoReality;

public class CriterioOr extends Criterio {
	
	private Criterio c1, c2;
	
	public CriterioOr(Criterio c1, Criterio c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public boolean cumple(ElementoReality p1) {
		return (c1.cumple(p1))||(c2.cumple(p1));
	}
}