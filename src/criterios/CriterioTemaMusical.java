package Criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Puedan Interpretar un determinado Tema Musical...
 */

import reality.ElementoReality;
import reality.TemaMusical;

public class CriterioTemaMusical extends Criterio{

	protected TemaMusical tema;
	
	public CriterioTemaMusical(TemaMusical tema){
		this.tema = tema;
	}

	@Override
	public boolean cumple(ElementoReality p) {
		return tema.cumple(p);
		
	}
}
