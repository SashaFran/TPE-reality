package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import reality.Criterios.Criterio;

public abstract class ElementoReality {

	public abstract ArrayList<String> getGeneros();
	public abstract ArrayList<String> getIdiomas();
	public abstract ArrayList<String> getInstrumentos();
    public abstract ArrayList<Participante> partxFiltro(Criterio f);

	public abstract int getSumaEdad();
	public abstract int cantPart();
	
	public ArrayList<Participante> partxFiltro(Criterio f, Comparator<Participante> c){
		ArrayList<Participante> temp = this.partxFiltro(f);
		Collections.sort(temp, c);
		return temp;
	}
	
	public int getEdad(){
		int promedio = this.getSumaEdad()/this.cantPart();
		return promedio;
	}
	
	
}
