package reality;

import java.util.ArrayList;

import reality.Criterios.Criterio;


public class Grupo extends ElementoReality{

	private ArrayList<ElementoReality> participantes;
	private String nombreGrupo;
	
	public Grupo(String n) {
		this.participantes = new ArrayList<>();
		this.nombreGrupo = n;
	}

	public void addAlGrupo(ElementoReality e){
		if(!participantes.contains(e))
			participantes.add(e);
	}


	public String getNombreGrupo() {
		return nombreGrupo;
	}

	@Override
	public int getSumaEdad() {
		int total = 0;
		for (ElementoReality e: participantes)
			total += e.getSumaEdad();
		return total;
	}
	
	@Override
	public int cantPart() {
		int total = 0;
		for (ElementoReality e: participantes)
			total += e.cantPart();
		return total;
	}

	@Override
	public ArrayList<String> getIdiomas() {
	 	ArrayList<String> aux = new ArrayList<>();
		for(ElementoReality e: participantes){
			ArrayList<String> union = e.getIdiomas();
			for(String s: union){
				if(!aux.contains(s)){
					aux.add(s);
				}
			}
		}
		return aux;
	}

	@Override
	public ArrayList<String> getInstrumentos() {
	 	ArrayList<String> aux = new ArrayList<>();
		for(ElementoReality e: participantes){
			ArrayList<String> union = e.getInstrumentos();
			for(String s: union){
				if(!aux.contains(s)){
					aux.add(s);
				}
			}
		}
		return aux;
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
	public ArrayList<ElementoReality> partxFiltro(Criterio f) {
		ArrayList<ElementoReality> p = new ArrayList<>();
		if(f.cumple(this)){
			p.add(this);
		}else{
			for(ElementoReality e: participantes)
				p.addAll(e.partxFiltro(f));
		}
		return p;
	}


	@Override
	public String toString() {
		return "Grupo: "+this.getNombreGrupo() + "\nParticipantes que lo componen: " + "\n"+participantes;
	}
	
	

	
	
}
