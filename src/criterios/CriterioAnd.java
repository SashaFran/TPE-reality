package Criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Canten en un determinado idioma y toquen un instrumento específico. Por ejemplo, “Aleman”
y “Guitarra”...
 */
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
