package criterioTm;
import java.util.ArrayList;
import criterios.*;
import reality.ElementoReality;
import reality.TemaMusical;

/*
4. Un tema puede ser interpretado por una banda/grupo/solista si puede cantar en el idioma del
tema y al menos uno de los géneros está entre las preferencias del grupo/banda/solista...
 */

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
