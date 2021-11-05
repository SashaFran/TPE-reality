package reality;

import java.time.LocalDate;
import java.util.ArrayList;

import reality.Criterios.Criterio;


public class Participante extends ElementoReality{

	private String nombre, apellido;
	private LocalDate fechaDeNacimiento;
	private ArrayList<String> generosFav;
	private ArrayList<String> instrumentos;
	private ArrayList<String> idiomas;
	
	
	public Participante(String nombre, String apellido, LocalDate nacimiento){
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = nacimiento;
		generosFav = new ArrayList<>();
		instrumentos = new ArrayList<>();
		idiomas = new ArrayList<>();
	}
	
	public int getSumaEdad(){
		LocalDate today = LocalDate.now();
	      return today.getYear() - fechaDeNacimiento.getYear();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	public boolean contieneGenero(String g){
		return this.generosFav.contains(g);
	}
	
	public boolean contieneIdioma(String g){
		return this.idiomas.contains(g);
	}
	
	public boolean contieneInstrumento(String g){
		return this.instrumentos.contains(g);
	}

	public ArrayList<String> getInstrumentos() {
		return new ArrayList<String>(instrumentos);
	}
	
	public ArrayList<String> getIdiomas() {
		return new ArrayList<String>(idiomas);
	}

	public void addGenero(String gf){
		if (!generosFav.contains(gf)){
			generosFav.add(gf);
		}
	}
	
	public void addInstrumento(String i){
		if (!instrumentos.contains(i)){
			instrumentos.add(i);
		}
	}
	
	public void addIdioma(String idi){
		if (!idiomas.contains(idi)){
			idiomas.add(idi);
		}
	}
	
	public int cantPart(){
		return 1;
	}

	@Override
	public ArrayList<String> getGeneros() {
		return new ArrayList<String>(generosFav);
	}
	
	@Override
	public ArrayList<ElementoReality> partxFiltro(Criterio f) {
		ArrayList<ElementoReality> p = new ArrayList<>();
        if (f.cumple(this))
            p.add(this);
        return p;
	}
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		try{
			Participante p = (Participante) obj;
			return this.getNombre().equals(p.getNombre()) 
					&& this.getApellido().equals(p.getApellido())
					&& this.getInstrumentos().equals(p.getInstrumentos()) 
					&& this.getIdiomas().equals(p.getIdiomas())
					&& this.getGeneros().equals(p.getGeneros());
		}catch(Exception e){
			return false;
		}
	}
	
	public String toString(){
		return "Nombre y Apellido: "+ this.getNombre()+" "+this.getApellido()+"\n";
	}


	
}
