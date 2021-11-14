package reality;

import java.time.LocalDate;

import Criterios.*;
import criterioTm.*;

public class MainReality {

	public static void main(String[] args){
		
		Produccion rr = new Produccion();
		
		Participante pp = new Participante("P0", "A0", LocalDate.of(2000, 1, 02));
		pp.addGenero("Country");
		pp.addGenero("Pop");
		pp.addGenero("Pop-Rock");
		pp.addGenero("Rock");
		pp.addIdioma("Ingles");
		pp.addIdioma("Espanol");
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
		p1.addIdioma("Espanol");
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
		
		Criterio cIdioma = new CriterioIdioma("Ingles");
		Criterio cGenero = new CriterioGenero("Rock");
		Criterio cInstrumento = new CriterioInstrumento("Guitarra");
		
		Coach cc = new Coach("Coach 0");
		Coach c1 = new Coach("C1");
		Coach c2 = new CoachExigente("C2", new CriterioAND(cIdioma, new CriterioAND(cGenero, cInstrumento)));


		
		rr.addParticipante(pp);
		rr.addParticipante(p1);
		rr.addParticipante(p2);
		rr.addParticipante(p3);
		rr.addParticipante(p4);
		rr.addCoach(cc);
		rr.addCoach(c1);
		rr.addCoach(c2);
		
		cc.add(pp);
		cc.add(p1);
		cc.add(p2);
		
		c1.add(p3);
		c1.add(p4);
		


		c2.add(pp);
		c2.add(p1);
		//Este no permite el ingreso.
		c2.add(p2);
	
		Grupo gg = new Grupo("G1");
		Grupo g1 = new Grupo("G2");
		
		gg.add(p1);
		gg.add(pp);
		gg.add(p5);

		g1.add(p5);
		g1.add(p6);

		cc.add(g1);
		c1.add(gg);

		
		TemaMusical fa = new TemaMusical("Rincon de Luz", "Espanol");
		fa.addGenero("Rock");
		fa.addInstrumento("Guitarra");
		
		CriterioTm cT1 = new CriterioMinimo();
		fa.setCriterio(cT1);
		

		
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
		Criterio cei1 = new CriterioIdioma("Espa�ol");
		Criterio cei2 = new CriterioIdioma("Ingles");
		Coach c3 = new CoachExigente("C3", new CriterioAND(ceg, 
												new CriterioAND(ceins, 
												new CriterioAND(cei1, cei2))));
		rr.addCoach(c3);
		c3.add(pp);
		c3.add(p1);
		
		System.out.println("Coach exigente:" + c3);
		
		System.out.println("Generos interseccion: "+gg.getGeneros());
		System.out.println("Idiomas union sin rep: "+gg.getIdiomas());
		System.out.println("Instrumentos union sin rep: "+gg.getInstrumentos());
		
		
		//----------------------------
		
		System.out.println("Participante aptos para batalla (ingles) del coach " + cc.getNombre() +": "+"\n"+cc.getListado(cei2));
		Criterio cgRock = new CriterioGenero("Rock");
		System.out.println("Participante aptos para batalla (rock) del coach " + cc.getNombre() +": "+"\n"+cc.getListado(cgRock));
		Criterio cgIdioma = new CriterioIdioma("Aleman");
		Criterio cgInst = new CriterioInstrumento("Guitarra");
		System.out.println("Participante aptos para batalla (rock) del coach " + cc.getNombre() +": "+"\n"+cc.getListado(new CriterioAND(cgIdioma, cgInst)));
		Criterio cgEdad = new CriterioEdad(18);
		System.out.println("Participante aptos para batalla (mayor edad) del coach " + cc.getNombre() +": "+"\n"+cc.getListado(cgEdad));
		
		//------------------------------
		
		Criterio ccc= new CriterioTemaMusical(fa);
		System.out.println("Canta tema Musical "+ cc.getNombre()+": " +"\n"+cc.getListado(ccc));
		
		//-------------------------------
		
		System.out.println("Batallas");
		
		System.out.println(rr.getListado(cGenero));

		
		
	}
}
