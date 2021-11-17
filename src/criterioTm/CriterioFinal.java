package criterioTm;

import java.util.ArrayList;
import criterios.Criterio;
import criterios.CriterioInstrumento;
import reality.ElementoReality;
import reality.Participante;
import reality.TemaMusical;

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
					ArrayList<Participante> partFiltrados = elemento.buscarParticipantesSimples(instr);
					for (Participante p : partFiltrados) {
						if (!participantes.contains(p))
							participantes.add(p);
					}
				}
				if (participantes.size() >= minMiembros)
					return true;
			} else {
				return true; 
			}
		}
		return false;
	}
	
}
