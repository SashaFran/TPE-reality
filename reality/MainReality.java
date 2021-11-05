package reality;

import java.time.LocalDate;

import reality.Criterios.*;

public class MainReality {

	public static void main(String[] args){
		
		Reality rr = new Reality("The Voice");
		
		Participante pp = new Participante("P0", "A0", LocalDate.of(2000, 1, 02));
		pp.addGenero("Country");
		pp.addGenero("Pop");
		pp.addGenero("Pop-Rock");
		pp.addGenero("Rock");
		pp.addIdioma("Ingles");
		pp.addIdioma("Español");
		pp.addIdioma("Italiano");
		pp.addIdioma("Aleman");
		pp.addInstrumento("Guitarra");
		pp.addInstrumento("Piano");
		pp.addInstrumento("Bateria");
		
		Participante p1 = new Participante("P1", "A1", LocalDate.of(2001, 2, 01));
		p1.addGenero("Rock");
		p1.addGenero("Pop-Rock");
		p1.addGenero("Pop");
		p1.addIdioma("Ingles");
		p1.addIdioma("Italiano");
		p1.addInstrumento("Piano");
		p1.addInstrumento("Guitarra");
		
		Participante p2 = new Participante("P2", "A2", LocalDate.of(2002, 3, 03));
		p2.addGenero("Metal");
		p2.addGenero("Industrial");
		p2.addIdioma("Ingles");
		p2.addIdioma("Frances");
		p2.addInstrumento("Piano");
		
		
		Participante p3 = new Participante("P3", "A3", LocalDate.of(2003, 4, 04));
		p3.addGenero("Pop");
		p3.addIdioma("Ingles");
		p3.addIdioma("Frances");
		p3.addInstrumento("Piano");
		p3.addInstrumento("Bateria");
		
		Participante p4 = new Participante("P4", "A4", LocalDate.of(2004, 6, 07));
		p4.addGenero("Pop-Rock");
		p4.addIdioma("Ingles");
		p4.addIdioma("Frances");
		p4.addInstrumento("Piano");
		p4.addInstrumento("Bateria");
		
		Participante p5 = new Participante("P5", "A5", LocalDate.of(2000, 6, 07));
		p5.addGenero("Pop");
		p5.addGenero("Pop-Rock");
		p5.addGenero("Industrial");
		p5.addIdioma("Ingles");
		p5.addIdioma("Frances");
		p5.addInstrumento("Ukelele");
		p5.addInstrumento("Bajo");
		
		Participante p6 = new Participante("P6", "A6", LocalDate.of(1995, 6, 07));
		p5.addGenero("Pop");
		p5.addGenero("Pop-Rock");
		p5.addGenero("Industrial");
		p5.addIdioma("Ingles");
		p5.addIdioma("Frances");
		p5.addInstrumento("Ukelele");
		p5.addInstrumento("Bajo");
		
		
		Coach cc = new Coach("C0", "C0");
		Coach c1 = new Coach("C1", "C1");

		
		rr.addParticipante(pp);
		rr.addParticipante(p1);
		rr.addParticipante(p2);
		rr.addParticipante(p3);
		rr.addParticipante(p4);
		rr.addCoach(cc);
		rr.addCoach(c1);
		//rr.addCoach(c2);
		
		cc.addAlEquipo(pp);
		cc.addAlEquipo(p1);
		cc.addAlEquipo(p2);
		
		c1.addAlEquipo(p3);
		c1.addAlEquipo(p4);
		
		Criterio cIdioma = new CriterioIdioma("Ingles");
		Criterio cGenero = new CriterioGenero("Rock");
		Criterio cInstrumento = new CriterioInstrumento("Guitarra");
		Coach c2 = new CoachExigente("C2", "C2", new CriterioAND(cIdioma, new CriterioAND(cGenero, cInstrumento)));

		c2.addAlEquipo(pp);
		c2.addAlEquipo(p1);
		//Este no permite el ingreso.
		c2.addAlEquipo(p2);
	
		Grupo gg = new Grupo("G1");
		Grupo g1 = new Grupo("G2");
		
		gg.addAlGrupo(p1);
		gg.addAlGrupo(pp);
		gg.addAlGrupo(p5);

		g1.addAlGrupo(p5);
		g1.addAlGrupo(p6);

		cc.addAlEquipo(g1);
		c1.addAlEquipo(gg);

		
		TemaMusical fa = new TemaMusical("Rincon de Luz", "Español");
		fa.addGenero("Rock");
		fa.addInstrumento("Guitarra");
		

		
		System.out.println("Instrumentos del grupo "+ cc.getNombre() + ": " +cc.getInstrumentos());
		System.out.println("Instrumentos del grupo "+ c1.getNombre() + ": " +c1.getInstrumentos());
		
		System.out.println("Idiomas del grupo "+ cc.getNombre() + ": " + cc.getIdiomas());
		System.out.println("Idiomas del grupo "+ c1.getNombre() + ": " + c1.getIdiomas());
		
		System.out.println("Generos por grupo: " + cc.getNombre() + ": "+ cc.getGeneros());
		System.out.println("Generos por grupo: " + c1.getNombre() + ": "+ c1.getGeneros());
		
		System.out.println("Promedio de edad, grupo: "+cc.getNombre()+" "+cc.getEdad());
		System.out.println("Promedio de edad, grupo: "+c1.getNombre()+" "+c1.getEdad());
		
		System.out.println("---------------------------------------------");
	
		Criterio ceg = new CriterioGenero("Pop");
		Criterio ceins = new CriterioInstrumento("Bateria");
		Criterio cei1 = new CriterioIdioma("Español");
		Criterio cei2 = new CriterioIdioma("Ingles");
		Coach c3 = new CoachExigente("C3","C3", new CriterioAND(ceg, 
												new CriterioAND(ceins, 
												new CriterioAND(cei1, cei2))));
		rr.addCoach(c3);
		c3.addAlEquipo(pp);
		c3.addAlEquipo(p1);
		
		System.out.println("Coach exigente:" + c3);
		
		System.out.println("Generos interseccion: "+gg.getGeneros());
		System.out.println("Idiomas union sin rep: "+gg.getIdiomas());
		System.out.println("Instrumentos union sin rep: "+gg.getInstrumentos());
		
		
		//----------------------------
		
		System.out.println("Participante aptos para batalla (ingles) del coach " + cc.getNombre() +": "+"\n"+cc.partxFiltro(cei2));
		Criterio cgRock = new CriterioGenero("Rock");
		System.out.println("Participante aptos para batalla (rock) del coach " + cc.getNombre() +": "+"\n"+cc.partxFiltro(cgRock));
		Criterio cgIdioma = new CriterioIdioma("Aleman");
		Criterio cgInst = new CriterioInstrumento("Guitarra");
		System.out.println("Participante aptos para batalla (rock) del coach " + cc.getNombre() +": "+"\n"+cc.partxFiltro(new CriterioAND(cgIdioma, cgInst)));
		Criterio cgEdad = new CriterioEdad(18);
		System.out.println("Participante aptos para batalla (mayor edad) del coach " + cc.getNombre() +": "+"\n"+cc.partxFiltro(cgEdad));
		
		//------------------------------
		
		Criterio ccc= new CriterioTemaMusical(fa);
		System.out.println("Canta tema Musical "+ cc.getNombre()+": " +cc.partxFiltro(ccc));
		
		//-------------------------------
		
		System.out.println("Batallas");
		
		
		
	}
}
