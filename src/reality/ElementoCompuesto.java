package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Criterios.Criterio;

public abstract class ElementoCompuesto extends ElementoReality {

	/*  ------- Participante:
		... un grupo o banda posee una lista de miembros que los componen (pueden ser integrantes
		o incluso sub bandas)...
		------- Coach:
		Ahora cada coach/jurado tiene un listado de participantes asignados como equipo propio, este listado
		puede incluir Bandas, Grupos o Integrantes solistas.
	 */
	private ArrayList<ElementoReality> participantes;


	public ElementoCompuesto(String nombre) {
		super(nombre);
		this.participantes = new ArrayList<>();
	}


	public boolean add(ElementoReality e){
		if(!participantes.contains(e)) {
			participantes.add(e);
			return true;
		} else {
			return false;
		}
	}

	/*  ------- Participante:
		En el caso de los idiomas que pueden interpretar una banda o grupo se considera la unión
		de los idiomas de todos sus miembros (no pueden existir repetidos)...
	    ------ Coach:
		● Un listado de todos los idiomas que pueden cantar los participantes de su equipo (sin idiomas
		repetidos)...
	 */
	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> union = new ArrayList<>();
		for(ElementoReality e: participantes){
			ArrayList<String> aux = e.getIdiomas();
			for(String s: aux){
				if(!union.contains(s)){
					union.add(s);
				}
			}
		}
		return union;
	}

	/*  ------- Participante:
		... lo mismo ocurre para los instrumentos que puede tocar una banda...
	    --------Coach:
		Para una mejor organización, cada coach/jurado desea poder obtener:
		● Un listado de todos los instrumentos que pueden tocar los participantes de su equipo (no
		debe haber repetidos)...
	 */
	@Override
	public ArrayList<String> getInstrumentos() {
		ArrayList<String> union = new ArrayList<>();
		for(ElementoReality e: participantes){
			ArrayList<String> aux = e.getInstrumentos();
			for(String s: aux){
				if(!union.contains(s)){
					union.add(s);
				}
			}
		}
		return union;
	}

	/*
	    ------- Participante:
		Una banda o grupo posee un nombre, y una edad (la cual se calcula como
		el promedio de las edades de cada uno de sus miembros)...
	    ------- Coach:
		● El promedio de edad de su equipo...
	 */
	@Override
	public int getSumaEdades() {
		int total = 0;
		for (ElementoReality e: participantes)
			total += e.getSumaEdades();
		return total;
	}

	@Override
	public int cantPart() {
		int total = 0;
		for (ElementoReality e: participantes)
			total += e.cantPart();
		return total;
	}

	@Override
	public ArrayList<Participante> getParticipantes(Criterio c) {
		ArrayList <Participante> participante = new ArrayList<>();
		for (ElementoReality e : participantes) {
			participante.addAll(e.getParticipantes(c));
		}
		return participante;
	}

}
