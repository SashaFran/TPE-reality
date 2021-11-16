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
	public ArrayList<Participante> getParticipantes() {
		ArrayList<Participante> copia = new ArrayList<>();
		for (ElementoReality e: participantes){
			ArrayList<Participante> aux = e.getParticipantes();
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
		for (ElementoReality e: participantes)
			total += e.getSumaEdades();
		return total;
	}

	@Override
	public int cantPart() {
		int total = 0;
		for (ElementoReality e: participantes)
			total += e.cantPart();
		return total;
	}
	//En el caso del coach, retornaría la cantidad de participantes repitiendo si están como solistas y en grupo

	/*
	Aclaraciones sobre la búsqueda de participantes:
		1. Si una banda o grupo cumple con lo que está buscando el jurado, se debe retornar la banda
		o el grupo entero (respetando la organización interna de grupos y subgrupos)
		2. Si una banda o grupo NO cumple con lo que está buscando el jurado, se buscan posibles
		miembros de la banda que sí cumplan y se retorna a estos miembros.
		3. El mecanismo anterior se repite en cada nivel organizativo que tenga la banda o grupo.
	 */
	@Override
	public ArrayList<ElementoReality> getListado(Criterio c) {
		ArrayList<ElementoReality> listado = new ArrayList<>();
		if(c.cumple(this)){
			listado.add(this);
		}else{
			for(ElementoReality e: participantes)
				listado.addAll(e.getListado(c));
		}
		return listado;
	}

	@Override
	public String toString() {
		return "Grupo: "
				+ this.getNombre()
				+ "\nParticipantes que lo componen: "
				+ "\n"+ this.getParticipantes();
	}

	//------------------------------------------------------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		try{
			Grupo g = (Grupo) obj;
			return this.getNombre().equals(g.getNombre())
					//&& this.getParticipantes().equals(g.getParticipantes())
					&& this.getInstrumentos().equals(g.getInstrumentos())
					&& this.getIdiomas().equals(g.getIdiomas())
					&& this.getGeneros().equals(g.getGeneros());
		}catch(Exception e){
			return false;
		}
	}

}
