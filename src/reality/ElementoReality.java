package reality;

import java.util.ArrayList;
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

	public abstract ArrayList<ElementoReality> buscar(Criterio c); 
	
	public abstract ArrayList<ElementoReality> getParticipantes();

	public abstract ArrayList<Participante> buscarParticipantesSimples(Criterio c);

	public abstract ArrayList<Participante> getParticipantesSimples();

	public int getEdad(){
		if(this.cantPart() != 0){
			int promedio = this.getSumaEdades()/this.cantPart();
			return promedio;
		} else {
			return 0;
		}
	}
	
	public String getNombre(){
		return this.nombre;
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
