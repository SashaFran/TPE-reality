package criterioTm;

import java.util.ArrayList;

import Criterios.Criterio;
import Criterios.CriterioInstrumento;
import reality.ElementoReality;
import reality.Participante;
import reality.TemaMusical;

public class CriterioFinal extends CriterioTm {
	
	
	int min;
	
	public CriterioFinal(int minimo) {
		this.min = minimo;
	}
	
	public CriterioFinal() {
		this.min = 1;
	}
	
	/*
	 * Sin embargo, para los temas de la final se debe chequear además de lo anterior que la
	 * banda/grupo/solista posea al menos un miembro que toque un instrumento de los necesarios para interpretar el tema.
	 * */	
	
	public boolean cumple(ElementoReality elemento, TemaMusical tema) {
		CriterioMinimo basico = new CriterioMinimo();
		if (basico.cumple(elemento, tema)){
			
			ArrayList<String> instTema = tema.getInstrumentos();	
			ArrayList <Participante> participantes = new ArrayList<>();
			
			for (String i : instTema) {
				Criterio instr = new CriterioInstrumento (i);
				ArrayList <Participante> partFiltrados = elemento.getParticipantes(instr);
				for (Participante p : partFiltrados) {
					if (!participantes.contains(p))
						participantes.add(p);
				}
			}
			if (participantes.size() >= min)
				return true;
			
		}
		return false;
	}
	
}
