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

	@Override
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
	public ArrayList<ElementoReality> getParticipantes() {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		for (ElementoReality e: this.participantes){
			listado.addAll(e.getParticipantes());
		}
		return listado;
	}
	
	@Override
	public ArrayList<ElementoReality> buscar(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		for (ElementoReality e: this.participantes){
			listado.addAll(e.buscar(c));
		}
		return listado;
	}
	
	public ElementoReality getBatallante(Comparator<ElementoReality> c){
		if(!this.getParticipantes().isEmpty()){
			Collections.sort(this.getParticipantes(), reverseOrder(c));
			return this.getParticipantes().get(0);
		}
		else return null;
	}
	
	//------------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return  "\nNombre: "+ this.getNombre() +
				"\nCantidad de participantes en equipo: " + this.cantPart() +
				"\nEquipo: " + "\n" + this.participantes;
	}

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
