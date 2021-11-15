package criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Prefieren un determinado género, por ejemplo “rock”...
 */
import reality.ElementoReality;


public class CriterioGenero extends Criterio{

	private String genero;
	
	public CriterioGenero(String genero){
		this.genero = genero;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.contieneGenero(genero);
	}

	
}
