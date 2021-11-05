package reality;

import java.util.ArrayList;


public class Reality{

	private ArrayList<Participante> participantes;
	private ArrayList<Coach> coaches;
	protected String nombre;
	
	public Reality(String nombre){
		this.nombre = nombre;
		this.participantes = new ArrayList<Participante>();
		this.coaches = new ArrayList<Coach>();
	}
	
	public ArrayList<Participante> getParticipantes() {
		return new ArrayList<Participante>(participantes);
	}

	public ArrayList<Coach> getCoaches() {
		return new ArrayList<Coach>(coaches);
	}

	public String getNombre() {
		return nombre;
	}


	public void addParticipante(Participante pp){
		if (!participantes.contains(pp)){
			participantes.add(pp);
		}
	}
	
	public void addCoach(Coach cc){
		if (!coaches.contains(cc)){
			coaches.add(cc);
		}
	}
	
	public int cantParticipantes(){
		int total = 0;
		for(Participante p: participantes)
			total += p.cantPart();
		return total;
	}
	
	public String toString(){
		return "Nombre: "+this.getNombre()+"\nTotal participantes: "+this.cantParticipantes();
	}
	


	@Override
	public boolean equals(Object obj) {
		try{
			Reality r = (Reality) obj;
			return this.getNombre().equals(r.getNombre())
					&& this.getCoaches().equals(r.getCoaches())
					&& this.getParticipantes().equals(r.getParticipantes());
		}catch(Exception e){
			return false;
		}
	}
	

	
	
}
