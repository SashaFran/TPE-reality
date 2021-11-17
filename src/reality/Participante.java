package reality;

import java.time.LocalDate;
import java.util.ArrayList;
import criterios.Criterio;

public class Participante extends ElementoReality{

	private String apellido;
	private LocalDate fechaDeNacimiento;
	private ArrayList<String> generosFav;
	private ArrayList<String> instrumentos;
	private ArrayList<String> idiomas;
		
	public Participante(String nombre, String apellido, LocalDate nacimiento){
		super(nombre);
		this.apellido = apellido;
		this.fechaDeNacimiento = nacimiento;
		generosFav = new ArrayList<>();
		instrumentos = new ArrayList<>();
		idiomas = new ArrayList<>();
	}

	public String getApellido() {
		return apellido;
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

	@Override
	public ArrayList<String> getGeneros() {
		return new ArrayList<String>(generosFav);
	}

	@Override
	public ArrayList<String> getInstrumentos() {
		return new ArrayList<String>(instrumentos);
	}

	@Override
	public ArrayList<String> getIdiomas() {
		return new ArrayList<String>(idiomas);
	}

	@Override
	public int getSumaEdades(){
		LocalDate today = LocalDate.now();
		return today.getYear() - fechaDeNacimiento.getYear();
	}
	
	@Override
	public int cantPart(){
		return 1;
	}

	@Override
	public ArrayList<ElementoReality> buscar(Criterio c) {
		ArrayList<ElementoReality> participante = new ArrayList<>();
        if (c.cumple(this))
            participante.add(this);
        return participante;
	}

	@Override
	public ArrayList<Participante> getParticipantesSimples() {
		ArrayList <Participante> copia = new ArrayList<>();
		copia.add(this);
		return copia;
	}

	@Override
	public ArrayList<Participante> buscarParticipantesSimples(Criterio c) {
		ArrayList <Participante> participante = new ArrayList<>();
		if ( c.cumple(this))
			participante.add(this);
		return participante;
	}

	@Override
	public ArrayList<ElementoReality> getParticipantes() {
		ArrayList <ElementoReality> participante = new ArrayList<>();
			participante.add(this);
		return participante;
	}
	
	//------------------------------------------------------------------------------------------------------
	
	@Override
	public String toString(){
		return "Participante: " + this.getNombre()+"\n";
	}

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

}
