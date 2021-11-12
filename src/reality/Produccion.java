package reality;

import java.util.ArrayList;

import Criterios.Criterio;


public class Produccion{

	private ArrayList<ElementoReality> participantes;
	private ArrayList<Coach> coaches;
	private ArrayList<TemaMusical> temas;
	

	public Produccion(){
		this.participantes = new ArrayList<ElementoReality>();
		this.coaches = new ArrayList<Coach>();
		this.temas = new ArrayList<TemaMusical>();
	}

	public void addTemaMusical(TemaMusical tm){
		if (!temas.contains(tm)){
			temas.add(tm);
		}
	}

	public void addParticipante(ElementoReality pp){
		if (!participantes.contains(pp)){
			participantes.add(pp);
		}
	}
	
	public void addCoach(Coach cc){
		if (!coaches.contains(cc)){
			coaches.add(cc);
		}
	}
	
	public ArrayList<ElementoReality> getParticipantes() {
		return new ArrayList<ElementoReality>(participantes);
	}

	public ArrayList<Coach> getCoaches() {
		return new ArrayList<Coach>(coaches);
	}
	
	public ArrayList<ElementoReality> getListado(Criterio c) {
		ArrayList<ElementoReality> posibles = new ArrayList<>();
		for (Coach c1 : coaches) {
			posibles.addAll(c1.partxFiltro(c));
		}
		return posibles;
	}
	
	
	
	public int cantParticipantes(){
		int total = 0;
		for(ElementoReality p: participantes)
			total += p.cantPart();
		return total;
	}
	
	public String toString(){
		return "\nTotal participantes: "+this.cantParticipantes();
	}

}
