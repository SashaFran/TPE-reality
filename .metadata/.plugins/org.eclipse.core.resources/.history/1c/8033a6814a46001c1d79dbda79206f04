package criterioTm;

import java.util.ArrayList;
import criterios.Criterio;
import criterios.CriterioInstrumento;
import reality.ElementoReality;
import reality.Participante;
import reality.TemaMusical;

/*
4. Un tema puede ser interpretado por una banda/grupo/solista si puede cantar en el idioma del
tema y al menos uno de los géneros está entre las preferencias del grupo/banda/solista.Sin
embargo, para los temas de la final se debe chequear además de lo anterior que la banda/grupo/solista
posea al menos un miembro que toque un instrumento de los necesarios para interpretar el tema. Este
requisito es más restrictivo para otros temas, que requieren, por ejemplo, 2 miembros o incluso 3,
que sepan tocar algún instrumento necesario para interpretar el tema...
 */


public class CriterioFinal extends CriterioTm {

	int minMiembros;
	
	public CriterioFinal(int minMiembros) {
		this.minMiembros = minMiembros;
	}
	
	public CriterioFinal() {
		this.minMiembros = 1;
	}

	public boolean cumple(ElementoReality elemento, TemaMusical tema) {
		CriterioMinimo minimo = new CriterioMinimo();
		if (minimo.cumple(elemento, tema)) {
			ArrayList<String> instTema = tema.getInstrumentos();
			if (!instTema.isEmpty()) {
				ArrayList<Participante> participantes = new ArrayList<>();
				for (String i : instTema) {
					Criterio instr = new CriterioInstrumento(i);
					ArrayList<Participante> partFiltrados = elemento.getParticipantes(instr);
					for (Participante p : partFiltrados) {
						if (!participantes.contains(p))
							participantes.add(p);
					}
				}
				if (participantes.size() >= minMiembros)
					return true;
			} else {
				return true; //Dado que la lista de instrumentos puede estar vacía, es ese caso,
			}				 //se considera válido el criterio mínimo.
		}
		return false;
	}
	
}
