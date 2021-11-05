package reality;

import java.util.ArrayList;
public class Produccion{

	private ArrayList<TemaMusical> temas;
	
	public Produccion(){
		temas = new ArrayList<TemaMusical>();
	}
	
	public void addTemaMusical(TemaMusical tm){
		if (!temas.contains(tm)){
			temas.add(tm);
		}
	}

	
	
	
}
