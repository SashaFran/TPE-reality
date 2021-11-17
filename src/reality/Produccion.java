package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import comparadores.ComparadorCantidadParts;
import comparadores.*;
import criterios.Criterio;
import static java.util.Collections.reverseOrder;

public class Produccion{

	private ArrayList<Coach> coaches;
	private ArrayList<TemaMusical> temas;
	private Comparator<ElementoReality> comparador;

	public Produccion(){
		this.coaches = new ArrayList<Coach>();
		this.temas = new ArrayList<TemaMusical>();
		this.comparador = new ComparadorInstrumento();
	}
	
	public Comparator<ElementoReality> getComparador() {
		return comparador;
	}

	public void setComparador(Comparator<ElementoReality> comparador) {
		this.comparador = comparador;
	}
	
	public ArrayList<Coach> getCoaches() {
		return new ArrayList<Coach>(coaches);
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
		Collections.sort(this.coaches, new ComparadorCantidadParts());
		while(i < coaches.size() && !added){
			added = addParticipante(pp, coaches.get(i));
			i++;
		}
	}

	public boolean addParticipante(ElementoReality pp, Coach cc){
		ArrayList<Participante> aux = this.getParticipantes();
		if (aux.size() > 0) {			
			ArrayList<Participante> esteParticipante = pp.getParticipantesSimples();
			for(Participante  e: esteParticipante){
				if(aux.contains(e)){
					return false;
				}
			}		
			return cc.add(pp); 
		}
		else 
			return cc.add(pp); 
	}

	public ArrayList<Participante> getParticipantes() {
		ArrayList <Participante> copia = new ArrayList<>();
		for(Coach c: coaches){
			ArrayList<Participante> auxPart = c.getParticipantesSimples(); 
			for(Participante aux: auxPart){
				if(!copia.contains(aux)){
					copia.add(aux);
				}
			}
		}
		return copia;
	}

	public ArrayList<ElementoReality> buscar(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		for (Coach c1 : coaches) {
			listado.addAll(c1.buscar(c));
		}
		return listado;
	}

	public ArrayList<ElementoReality> getPreseleccionados() {
		ArrayList<ElementoReality> seleccionados = new ArrayList<>();
		for (Coach c: coaches) {
			ElementoReality aux = c.getBatallante(this.getComparador());
			if(aux != null)
				seleccionados.add(aux);
		}
		return seleccionados;
	}

	public ElementoReality batallar() {
		ArrayList<ElementoReality> ordenados = getPreseleccionados();
		Collections.sort(ordenados,reverseOrder(this.getComparador()));
		return (ordenados.get(0));
	}
	
	public ElementoReality getPreseleccionado(Coach c) {
		return c.getBatallante(this.getComparador());
	}
	
	public ElementoReality batallar(ElementoReality e1, ElementoReality e2 ) {
		ArrayList<ElementoReality> ordenados = new ArrayList<>();
		ordenados.add(e1);
		ordenados.add(e2);
		Collections.sort(ordenados,reverseOrder(this.getComparador()));
		return (ordenados.get(0));
	}
	
	public int cantPart(){
		return this.getParticipantes().size() + this.coaches.size();
	}
	
	public String toString(){
		return "\nTotal participantes: "+ this.cantPart();
	}
}
