package reality.Criterios;

import java.util.ArrayList;

import reality.ElementoReality;
import reality.TemaMusical;

public class CriterioTemaMusical extends Criterio{

	protected TemaMusical t;
	
	public CriterioTemaMusical(TemaMusical t){
		this.t = t;
	}
	
	/*
	si puede cantar en el idioma del tema y al menos uno de los géneros está entre las preferencias
	 */
	@Override
	public boolean cumple(ElementoReality p) {
		String idiomaTM = t.getIdioma();
		ArrayList<String> idiomaP = p.getIdiomas();
		if(idiomaP.contains(idiomaTM)){
			ArrayList<String> generos = t.getGeneros();
			ArrayList<String> generosP = p.getGeneros();
			for(String g: generos){
				if(generosP.contains(g)){
					return true;
				}
				
			}
		}	
		return false;
	}
}
