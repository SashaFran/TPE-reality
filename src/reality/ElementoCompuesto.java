package reality;

import java.util.ArrayList;
import criterios.Criterio;

public abstract class ElementoCompuesto extends ElementoReality {

	protected ArrayList<ElementoReality> participantes;

	public ElementoCompuesto(String nombre) {
		super(nombre);
		this.participantes = new ArrayList<>();
	}

	public boolean add(ElementoReality e){
		if(!participantes.contains(e)) {
			participantes.add(e);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> union = new ArrayList<>();
		for(ElementoReality e: participantes){
			ArrayList<String> aux = e.getIdiomas();
			for(String s: aux){
				if(!union.contains(s)){
					union.add(s);
				}
			}
		}
		return union;
	}

	@Override
	public ArrayList<String> getInstrumentos() {
		ArrayList<String> union = new ArrayList<>();
		for(ElementoReality e: participantes){
			ArrayList<String> aux = e.getInstrumentos();
			for(String s: aux){
				if(!union.contains(s)){
					union.add(s);
				}
			}
		}
		return union;
	}

	@Override
	public ArrayList<Participante> buscarParticipantesSimples(Criterio c) {
		ArrayList <Participante> participante = new ArrayList<>();
		for (ElementoReality e : participantes) {
			participante.addAll(e.buscarParticipantesSimples(c));
		}
		return participante;
	}

	@Override
	public ArrayList<Participante> getParticipantesSimples() { 
		ArrayList<Participante> copia = new ArrayList<>();
		for (ElementoReality e: participantes){
			ArrayList<Participante> aux = e.getParticipantesSimples();
			for(Participante o: aux){
				if(!copia.contains(o)){
					copia.add(o);
				}
			}
		}
		return copia;
	}
	
	@Override
	public int getSumaEdades() {
		int total = 0;
		ArrayList<Participante> parts = this.getParticipantesSimples();
		for(ElementoReality e: parts)
			total += e.getSumaEdades();
		return total;
	}
	
	@Override
	public int cantPart() {
		ArrayList<Participante> parts = this.getParticipantesSimples();
		return parts.size();
	}
}
