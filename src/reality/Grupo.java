package reality;

import java.util.ArrayList;
import criterios.Criterio;

public class Grupo extends ElementoCompuesto{

	public Grupo(String nombre) {
		super(nombre);
	}

	@Override
	public ArrayList<String> getGeneros() {
		ArrayList <String> generos = new ArrayList <>();
		generos.addAll((participantes.get(0)).getGeneros());
		for (ElementoReality p : participantes) {
			ArrayList <String> aux = p.getGeneros();
			ArrayList<String> paraEliminar = new ArrayList<>();
			for (String g: generos) {
				if (!aux.contains(g)) {
					paraEliminar.add(g);
				}
			}
			for(String pp: paraEliminar){
				generos.remove(pp);
			}
		}
		return generos;
	}

	@Override
	public ArrayList<ElementoReality> buscar(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		if(c.cumple(this)){
			listado.add(this);
		}else{
			for(ElementoReality e: participantes)
				listado.addAll(e.buscar(c));
		}
		return listado;
	}
	
	@Override
	public ArrayList<ElementoReality> getParticipantes() {
		ArrayList <ElementoReality> copia = new ArrayList<>();
		copia.add(this);
		return copia;
	}
	
	//------------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Grupo: "
				+ this.getNombre()+"\n"
				//+ "\nParticipantes que lo componen: "
				//+ "\n"+ this.getParticipantesSimples()
				;
	}


	@Override
	public boolean equals(Object obj) {
		try{
			Grupo g = (Grupo) obj;
			return this.getNombre().equals(g.getNombre())
					&& this.getParticipantes().equals(g.getParticipantes())
					&& this.getInstrumentos().equals(g.getInstrumentos())
					&& this.getIdiomas().equals(g.getIdiomas())
					&& this.getGeneros().equals(g.getGeneros());
		}catch(Exception e){
			return false;
		}
	}
}
