package reality.Criterios;


import reality.ElementoReality;

public class CriterioIdioma extends Criterio{

	private String idioma;
	
	public CriterioIdioma(String idioma){
		this.idioma = idioma;
	}
	
	public String getIdioma() {
		return idioma;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.contieneIdioma(idioma);
	}

	
}
