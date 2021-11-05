package reality;

import java.util.ArrayList;


public class TemaMusical {

	private String titulo;
	private String idioma;
	private ArrayList<String> generos;
	private ArrayList<String> instrumentos;
	
	public TemaMusical(String titulo, String idioma){
		this.titulo = titulo;
		this.idioma = idioma;
		generos = new ArrayList<>();
		instrumentos = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public ArrayList<String> getGeneros() {
		return new ArrayList<String>(generos);
	}

	public ArrayList<String> getInstrumentos() {
		return new ArrayList<String>(instrumentos);
	}
	
	public void addGenero(String genero){
		if(!generos.contains(genero)){
			generos.add(genero);
		}
	}
	
	public void addInstrumento(String inst){
		if (!instrumentos.contains(inst)){
			instrumentos.add(inst);
		}
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemaMusical other = (TemaMusical) obj;
		if (generos == null) {
			if (other.generos != null)
				return false;
		} else if (!generos.equals(other.generos))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (instrumentos == null) {
			if (other.instrumentos != null)
				return false;
		} else if (!instrumentos.equals(other.instrumentos))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public String toString(){
		return "Tema musical: " + "\nTitulo: "+this.getTitulo()
								+"\nIdioma: "+this.getIdioma()
								+"\nGeneros: "+this.getGeneros()
								+"\nInstrumentos: "+this.getInstrumentos();
	}
	
	
	
}
