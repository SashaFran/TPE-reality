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
		Collections.sort(this.coaches, new ComparadorCantidadParts()); //lo ordena para que siempre intente primero con el que no tiene participantes
		while(i < coaches.size() && !added){
			added = addParticipante(pp, coaches.get(i));
			i++;
		}
	}

	//puede asignarle, el coach hace la comprobacion si quiere o no el participante.
	public boolean addParticipante(ElementoReality pp, Coach cc){
		ArrayList<Participante> aux = this.getParticipantes();
		ArrayList<Participante> esteParticipante = pp.getParticipantes();
		for(Participante  e: esteParticipante){
			if(aux.contains(e)){
				return false;
			}
		}		
		return cc.add(pp); 
	}
	
	//habra que poner un booleano del tipo tieneCoach para que no permita agregar solistas que
	// como a la vez son parte de un grupo y tienen otro coach o viceversa

	public ArrayList<Coach> getCoaches() {
		return new ArrayList<Coach>(coaches);
	}

	public ArrayList<Participante> getParticipantes() {
		ArrayList <Participante> copia = new ArrayList<>();
		for(Coach c: coaches){
			ArrayList<Participante> auxPart = c.getParticipantes(); 
			for(Participante aux: auxPart){
				if(!copia.contains(aux)){
					copia.add(aux);
				}
			}
		}
		return copia;
	}

	//---------- la producción necesita esto? ----------
	public int cantPart(){
		return this.getParticipantes().size() + this.coaches.size();
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
	public ArrayList<ElementoReality> getListado() {
		ArrayList<ElementoReality> seleccionados = new ArrayList<>();
		for (Coach c: coaches) {
			ElementoReality aux = c.getBatallante(this.getComparador());
			if(aux != null)
				seleccionados.add(aux);
		}
		Collections.sort(seleccionados,reverseOrder(this.getComparador())); //porque Sort ordena por defecto de menor a mayor
		return seleccionados;
	}
	
	public String toString(){
		return "\nTotal participantes: "+ this.cantPart();
	}


	public Comparator<ElementoReality> getComparador() {
		return comparador;
	}


	public void setComparador(Comparator<ElementoReality> comparador) {
		this.comparador = comparador;
	}

}
