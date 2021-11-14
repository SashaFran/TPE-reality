package reality;

import java.util.ArrayList;

import Criterios.Criterio;


public class Grupo extends ElementoCompuesto{

	public Grupo(String nombre) {
		super(nombre);
	}

	/*
    Los géneros de preferencia se calculan como la intersección de los géneros de preferencia
    de todos sus miembros. Por ejemplo si un grupo tienen dos miembros A y B, el integrante A
    tiene preferencias {g1,g2,g3,g4} y el integrante B las preferencias {g1,g4,g7,g11} el grupo
    tendrá como preferencias de géneros {g1, g4}...
 	*/
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
				+ "\n"+ participantes;
	}

}
