package reality;

import java.util.ArrayList;

import Criterios.Criterio;


public class Produccion{


	private ArrayList<Coach> coaches;
	private ArrayList<TemaMusical> temas;
	

	public Produccion(){
		this.coaches = new ArrayList<Coach>();
		this.temas = new ArrayList<TemaMusical>();
	}


	public void addTemaMusical(TemaMusical tm){
		if (!temas.contains(tm)){
			temas.add(tm);
		}
	}
	
	public void addCoach(Coach cc){
		if (!coaches.contains(cc)){
			coaches.add(cc);
		}
	}

	public void addParticipante(ElementoReality pp){
		boolean added = false;
		int i = 0;
		while(i < coaches.size() && !added){
			added = c.add(pp);
			i++;
		}
	}

	public ArrayList<Coach> getCoaches() {
		return new ArrayList<Coach>(coaches);
	}

	//---------- la producción necesita esto? ----------
	public int cantPart(){
		int total = 0;
		for(Coach c: coaches)
			total += c.cantPart();  //si el coach entra, sumar uno
		return total;
	}

	//Obtener listado de búsquedas...
	public ArrayList<ElementoReality> getListado(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		for (Coach c1 : coaches) {
			listado.addAll(c1.getListado(c));			//cambio nombre al método
		}
		return listado;
	}

	//Obtener listado para batallas...
	/*
		Una batalla implica que dos participantes (sea banda, grupo o solista)
		se enfrenten entre sí (puede ser incluso un solista contra una banda)...
	 */
	public ArrayList<ElementoReality> getListado(Comparator<ElementoReality> comp) {
		ArrayList<ElementoReality> seleccionados = new ArrayList<>();
		for (Coach c: coaches) {
			seleccionados.add(c.getBatallante(comp));
		}
		Collections.sort(seleccionados, comp);
		return seleccionados;
	}
	
	public String toString(){
		return "\nTotal participantes: "+this.cantPart();
	}

}
