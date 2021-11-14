package reality;

import java.util.ArrayList;
import java.util.Collections;
import Criterios.Criterio;

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
		for(ElementoReality p: equipo){
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

	/*
		Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
		integrantes, bandas o grupos (... cumplan determinados criterios...)...
	 */
	public ArrayList<ElementoReality> getListado(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		for (ElementoReality e: equipo){
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

	public ElementoReality getBatallantes(Comparator<ElementoReality> c){
		Collections.sort(this.participantes, c);
		Collections.reverseOrder(seleccionados);
		return this.participantes.get(0);
	}

	@Override
	public String toString() {
		return "\nNombre y Apellido: "+this.getNombre()+" "+this.getApellido()+
				"\nCantidad de participantes en equipo: "+this.cantPart()
				+"\nEquipo: "+"\n"+this.equipo;
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
