package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import criterios.Criterio;

public abstract class ElementoReality {


	private String nombre;


	public ElementoReality(String nombre) {
		this.nombre = nombre;
	}


	public abstract ArrayList<String> getGeneros();

	public abstract ArrayList<String> getIdiomas();

	public abstract ArrayList<String> getInstrumentos();

	public abstract int getSumaEdades();

	public abstract int cantPart();

	public abstract ArrayList<ElementoReality> getListado(Criterio c);  //cambio nombre metodo partxFilt

	public abstract ArrayList<Participante> getParticipantes(Criterio c);

	public abstract ArrayList<ElementoReality> getParticipantes(); //agrego

	public abstract String toString(); //ver si es necesario

	public String getNombre(){
		return this.nombre;
	}

	/*
	    ------- Participante:
		Una banda o grupo posee un nombre, y una edad (la cual se calcula como
		el promedio de las edades de cada uno de sus miembros)...
	    ------- Coach:
		● El promedio de edad de su equipo...
	 */

	public int getEdad(){
		if(this.cantPart() != 0){
			int promedio = this.getSumaEdades()/this.cantPart();
			return promedio;
		} else {
			return 0;
		}
	}

	public boolean contieneInstrumento(String instrumento) {
		ArrayList<String> instrumentos = this.getInstrumentos();
		return (instrumentos.contains(instrumento));
	}
	
	public boolean contieneIdioma(String idioma) {
		ArrayList<String> idiomas = this.getIdiomas();
		return (idiomas.contains(idioma));
	}
	
	public boolean contieneGenero(String genero) {
		ArrayList<String> generos = this.getGeneros();
		return (generos.contains(genero));
	}

}
