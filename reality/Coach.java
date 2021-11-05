package reality;

import java.util.ArrayList;
import java.util.Collections;

import reality.Criterios.Criterio;
import reality.ElementoReality;
import reality.TemaMusical;

public class Coach extends ElementoReality{

	private String nombre, apellido;
	protected ArrayList<ElementoReality> equipo;
	
	public Coach(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
		this.equipo = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void addAlEquipo(ElementoReality e){
		if (!equipo.contains(e)){
			equipo.add(e);
		}
	}
	
	
	@Override
	public ArrayList<ElementoReality> partxFiltro(Criterio f) {
		ArrayList<ElementoReality> p = new ArrayList<>();
		for (ElementoReality e: equipo){
			p.addAll(e.partxFiltro(f));
		}

        return p;
	}

	@Override
	public ArrayList<String> getInstrumentos(){
		ArrayList<String> ins = new ArrayList<>();
		for(ElementoReality c: equipo){
			ins.addAll(c.getInstrumentos());
			for( int i = 0; i<ins.size(); i++){
				for (int j = i +1; j<ins.size(); j++)
				if (ins.get(i).equals(ins.get(j))){
					ins.remove(j--);
				}
			}
		}
		return ins;
	}
	
	public ArrayList<String> getIdiomas(){
		ArrayList<String> i = new ArrayList<>();
		for (ElementoReality c: equipo){
				i.addAll(c.getIdiomas());
				for( int ii = 0; ii<i.size(); ii++){
					for (int j = ii +1; j<i.size(); j++)
					if (i.get(ii).equals(i.get(j))){
						i.remove(j--);
					}
				}
			}
		return i;
	}
	
	@Override
	public ArrayList<String> getGeneros(){
	 	ArrayList<String> aux = new ArrayList<>();
		for(ElementoReality e: equipo){
			ArrayList<String> union = e.getGeneros();
			for(String s: union){
				if(!aux.contains(s)){
					aux.add(s);
				}
			}
		}
		Collections.sort(aux);
		return aux;
	}	
	
	@Override
	public int getSumaEdad() {
		int sumaEdad = 0;
		for (ElementoReality e: equipo)
			sumaEdad += e.getEdad();
		return sumaEdad;
	}

	@Override
	public int cantPart() {
		int total = 0;
		for (ElementoReality e: equipo)
			total += e.cantPart();
		 return total;
	}

	public boolean puedeTocar(TemaMusical t){
		ArrayList<ElementoReality> ee = new ArrayList<>();
		for(ElementoReality e: equipo){
			if(e.getGeneros().contains(t.getGeneros())){
				ee.add(e);
				
			}
		}
			
		return true;
	}

	

	
	
	

	
	
	//--------------------------------------------------------------------------------------------
	
	public boolean equals(Object obj) {
		try{
			Coach c = (Coach) obj;
			return this.getNombre().equals(c.getNombre()) 
					&& this.getApellido().equals(c.getApellido())
					&& this.getInstrumentos().equals(c.getInstrumentos()) 
					&& this.getIdiomas().equals(c.getIdiomas())
					&& this.getGeneros().equals(c.getGeneros());
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "\nNombre y Apellido: "+this.getNombre()+" "+this.getApellido()+
				"\nCantidad de participantes en equipo: "+this.cantPart()
				+"\nEquipo: "+"\n"+this.equipo;
	}



}
