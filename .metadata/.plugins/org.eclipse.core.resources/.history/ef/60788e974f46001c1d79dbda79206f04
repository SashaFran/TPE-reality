package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import criterios.Criterio;

import static java.util.Collections.reverseOrder;

public class Coach extends ElementoCompuesto {


	public Coach(String nombre){
		super(nombre);
	}


	/*
		Para una mejor organización, cada coach/jurado desea poder obtener:
		● Un listado de géneros de preferencia de los participantes de su equipo (sin repetidos y
		ordenados alfabéticamente)...
    */
	public ArrayList<String> getGeneros(){
		ArrayList<String> union = new ArrayList<>();
		for(ElementoReality p: this.participantes){
			ArrayList<String> aux = p.getGeneros();
			for(String s: aux){
				if(!union.contains(s)){
					union.add(s);
				}
			}
		}
		Collections.sort(union);
		return union;
	}

	@Override
	public ArrayList<ElementoReality> getParticipantes() {    //sin repetidos
		ArrayList<ElementoReality> copia = new ArrayList<>();
		for (ElementoReality e: participantes){
			ArrayList<ElementoReality> aux = e.getParticipantes();
			for(ElementoReality o: aux){
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
		ArrayList<ElementoReality> parts = this.getParticipantes();
		for(ElementoReality e: parts)
			total += e.getSumaEdades();
		return total;
	}

	@Override
	public int cantPart() {
		ArrayList<ElementoReality> parts = this.getParticipantes();
		return parts.size();
	}

	/*
		Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
		integrantes, bandas o grupos (... cumplan determinados criterios...)...
	 */
	public ArrayList<ElementoReality> getListado(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		for (ElementoReality e: this.participantes){
			listado.addAll(e.getListado(c));
		}
		return listado;
	}

	/* ---------------------- VOLVER -----------------------
		Como los jurados no quieren perder una desean poder contar con un mecanismo que les permita
		dada la forma actual que se va a utilizar para determinar el ganador de una batalla, obtener un listado
		de sus participantes ordenado de forma tal que los primeros miembros del listado sean los que les
		ganen o empaten con los siguientes miembros (siempre dentro del mismo equipo del juez).
	 */

//	private ArrayList<ElementoReality> getListado(Criterio c,  Comparator<ElementoReality> c) {
//		ArrayList<ElementoReality> listado = this.getListado(c);
//		Collections.sort(listado, c);
//		return listado;
//	}

	public ElementoReality getBatallante(Comparator<ElementoReality> c){
		if(!this.getParticipantes().isEmpty()){
			Collections.sort(this.getParticipantes(), reverseOrder(c));
		}
		return this.getParticipantes().get(0);
	}

	@Override
	public String toString() {
		return  "\nNombre: "+ this.getNombre() +
				"\nCantidad de participantes en equipo: " + this.cantPart() +
				"\nEquipo: " + "\n" + this.participantes;
	}


	//------------------------------------------------------------------------------------------------------
	public boolean equals(Object obj) {
		try{
			Coach c = (Coach) obj;
			return this.getNombre().equals(c.getNombre())
					&& this.getInstrumentos().equals(c.getInstrumentos()) 
					&& this.getIdiomas().equals(c.getIdiomas())
					&& this.getGeneros().equals(c.getGeneros());
		}catch(Exception e){
			return false;
		}
	}
	

}
