package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import reality.Criterios.Criterio;

public abstract class ElementoReality {

	public abstract ArrayList<String> getGeneros();
	public abstract ArrayList<String> getIdiomas();
	public abstract ArrayList<String> getInstrumentos();
    public abstract ArrayList<ElementoReality> partxFiltro(Criterio f);
    
	public boolean contieneInstrumento(String instrumento) {
		ArrayList<String> instrumentos = this.getInstrumentos();
		return (instrumentos.contains(instrumento));
	}
	
	public boolean contieneIdioma(String idioma) {
		ArrayList<String> idiomas = this.getIdiomas();
		return (idiomas.contains(idioma));
	}
	
	public boolean contieneGeneros(String genero) {
		ArrayList<String> generos = this.getGeneros();
		return (generos.contains(genero));
	}

	public abstract int getSumaEdad();
	public abstract int cantPart();
	
	public ArrayList<ElementoReality> partxFiltro(Criterio f, Comparator<ElementoReality> c){
		ArrayList<ElementoReality> temp = this.partxFiltro(f);
		Collections.sort(temp, c);
		return temp;
	}
	
	public int getEdad(){
		int promedio = this.getSumaEdad()/this.cantPart();
		return promedio;
	}
	
	
}
