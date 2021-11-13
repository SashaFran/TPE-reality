package Criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Canten en un determinado idioma, por ejemplo “inglés”...
 */

import reality.ElementoReality;

public class CriterioIdioma extends Criterio{

	private String idioma;
	
	public CriterioIdioma(String idioma){
		this.idioma = idioma;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.contieneIdioma(idioma);
	}

	
}
