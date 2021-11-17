package criterioTm;

import java.util.ArrayList;
import criterios.*;
import reality.ElementoReality;
import reality.TemaMusical;

public class CriterioMinimo extends CriterioTm {
	
	@Override
	public boolean cumple(ElementoReality elemento, TemaMusical tema) {
		Criterio idioma = new CriterioIdioma (tema.getIdioma());

		if (idioma.cumple(elemento)) {
			
			ArrayList<String> generos = tema.getGeneros();	
			for (String g:generos) {
				Criterio genero = new CriterioGenero (g);
				if (genero.cumple(elemento))
					return true;
			}
			
		}
		return false;
	}

}
