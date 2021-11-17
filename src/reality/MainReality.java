package reality;

import java.time.LocalDate;
import comparadores.*;
import criterioTm.*;
import criterios.*;

public class MainReality {

	public static void main(String[] args) {

		Produccion prod = new Produccion();
		TemaMusical tm0 = new TemaMusical("Rincon de Luz", "Espanol");
		TemaMusical tm1 = new TemaMusical("Age of stone", "Ingles");

		CriterioTm cTM0 = new CriterioFinal();
		
		Criterio cIngles = new CriterioIdioma("Ingles");
		Criterio cEsp = new CriterioIdioma("Espanol");
		Criterio cPort = new CriterioIdioma("Portugues");
		Criterio cRock = new CriterioGenero("Rock");
		Criterio cPop = new CriterioGenero("Pop");
		Criterio cGuitarra = new CriterioInstrumento("Guitarra");
		Criterio cBateria = new CriterioInstrumento("Bateria");

		Coach c0 = new Coach("C0");
		Coach c1 = new Coach("C1");
		Coach c2 = new CoachExigente("CE2", new CriterioAnd(cIngles, new CriterioAnd(cRock, cGuitarra)));
		CoachExigente c3 = new CoachExigente("CE3", new CriterioAnd(cPop, new CriterioAnd(cBateria, new CriterioAnd(cEsp, cPort))));
		c3.setC(cEsp);
		
		Participante p0 = new Participante("N0", "A0", LocalDate.of(2000, 1, 02));
		Participante p1 = new Participante("N1", "A1", LocalDate.of(2001, 2, 01));
		Participante p2 = new Participante("N2", "A2", LocalDate.of(2002, 3, 03));
		Participante p3 = new Participante("N3", "A3", LocalDate.of(2003, 4, 04));
		Participante p4 = new Participante("N4", "A4", LocalDate.of(2020, 6, 07));
		Participante p5 = new Participante("N5", "A5", LocalDate.of(2000, 6, 07));
		Participante p6 = new Participante("N6", "A6", LocalDate.of(1995, 6, 07));
		Participante p7 = new Participante("SUPER", "P7", LocalDate.of(2010, 6, 07));
		Participante p8 = new Participante("SUPER2", "P8", LocalDate.of(1900, 6, 07));

		
		Grupo g0 = new Grupo("G0");
		Grupo g1 = new Grupo("G1");

		// ------------ participantes -----------------------
		p0.addGenero("Country");
		p0.addGenero("Pop-Rock");
		p0.addGenero("Pop");
		p0.addGenero("Rock");
		p0.addIdioma("Aleman");
		p0.addIdioma("Espanol");
		p0.addIdioma("Ingles");
		p0.addIdioma("Italiano");
		p0.addInstrumento("Bateria");
		p0.addInstrumento("Guitarra");
		p0.addInstrumento("Piano");
		
		p1.addGenero("Pop-Rock");
		p1.addGenero("Pop");
		p1.addGenero("Rock");
		p1.addIdioma("Espanol");
		p1.addIdioma("Ingles");
		p1.addIdioma("Italiano");
		p1.addInstrumento("Guitarra");
		p1.addInstrumento("Piano");
		
		p2.addGenero("Industrial");
		p2.addGenero("Metal");
		p2.addIdioma("Frances");
		p2.addIdioma("Ingles");
		p2.addInstrumento("Piano");
		
		p3.addGenero("Pop");
		p3.addIdioma("Frances");
		p3.addIdioma("Ingles");
		p3.addInstrumento("Bateria");
		p3.addInstrumento("Piano");
		
		p4.addGenero("Pop-Rock");
		p4.addIdioma("Frances");
		p4.addIdioma("Ingles");
		p4.addInstrumento("Bateria");
		p4.addInstrumento("Piano");
		
		p5.addGenero("Industrial");
		p5.addGenero("Pop-Rock");
		p5.addGenero("Pop");
		p5.addIdioma("Frances");
		p5.addIdioma("Ingles");
		p5.addInstrumento("Bajo");
		p5.addInstrumento("Ukelele");
		
		p6.addGenero("Industrial");
		p6.addGenero("Pop-Rock");
		p6.addGenero("Pop");
		p6.addIdioma("Frances");
		p6.addIdioma("Ingles");
		p6.addInstrumento("Bajo");
		p6.addInstrumento("Ukelele");
		
		p7.addGenero("Rock");
		p7.addIdioma("Aleman");
		p7.addIdioma("Espanol");
		p7.addIdioma("Ingles");
		p7.addIdioma("Italiano");
		p7.addIdioma("Portugues");
		p7.addIdioma("Frances");
		p7.addIdioma("Catalan");
		p7.addInstrumento("Bateria");
		p7.addInstrumento("Guitarra");
		p7.addInstrumento("Bajo");
		p7.addInstrumento("Ukelele");
		p7.addInstrumento("Pandereta");
		p7.addInstrumento("Saxo");
		p7.addInstrumento("Piano");
		
		
		p8.addGenero("Industrial");
		p8.addGenero("Metal");
		p8.addGenero("Country");
		p8.addGenero("Pop-Rock");
		p8.addGenero("Pop");
		p8.addGenero("Rock");
		p8.addIdioma("Aleman");
		p8.addIdioma("Espanol");
		p8.addIdioma("Ingles");
		p8.addIdioma("Italiano");
		p8.addIdioma("Portugues");
		p8.addIdioma("Frances");
		p8.addIdioma("Catalan");
		p8.addInstrumento("Bateria");
		p8.addInstrumento("Guitarra");
		p8.addInstrumento("Bajo");
		p8.addInstrumento("Ukelele");
		/*
		 * p8.addInstrumento("Pandereta");
		 * p8.addInstrumento("Saxo");
		 * p8.addInstrumento("Piano");
		Este comentario hace la diferencia si gana uno u otro entre los 4 coaches*/

		tm0.addGenero("Rock");
		tm0.addInstrumento("Guitarra");
		tm0.setCriterio(cTM0);
		
		tm1.addGenero("Punk");
		tm1.addGenero("Rock");
		tm1.addInstrumento("Guitarra");
		tm1.addInstrumento("Bateria");

		g0.add(p0);
		g0.add(p1);
		g0.add(p3);
		
		g1.add(p5);
		g1.add(p6);
		
		prod.addCoach(c0);
		prod.addCoach(c1);
		prod.addCoach(c2);
		prod.addCoach(c3);
		
		prod.addParticipante(g0);
		prod.addParticipante(g1);
		prod.addParticipante(p7, c2);
		prod.addParticipante(p7, c1); //No lo agrega porque ya lo tiene otro coach
		prod.addParticipante(p0);//No lo agrega porque ya lo tiene otro coach el grupo que lo contiene
		prod.addParticipante(p1);//No lo agrega porque ya lo tiene otro coach el grupo que lo contiene
		prod.addParticipante(p3);//No lo agrega porque ya lo tiene otro coach el grupo que lo contiene
		prod.addParticipante(p4, c0);
		prod.addParticipante(p5);//No lo agrega porque ya lo tiene otro coach el grupo que lo contiene
		prod.addParticipante(p6);//No lo agrega porque ya lo tiene otro coach el grupo que lo contiene

		// ------------------------------------------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Participantes de la produccion");
		System.out.println(prod.getParticipantes());
		
		// ------------------------------------------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Participantes asignados a coaches");
		System.out.println("Coach " + c0.getNombre() + ": " + "\n" + c0.getParticipantes());
		System.out.println("Coach " + c1.getNombre() + ": " + "\n" + c1.getParticipantes());
		System.out.println("Coach " + c2.getNombre() + ": " + "\n" + c2.getParticipantes());
		System.out.println("Coach " + c3.getNombre() + ": " + "\n" + c3.getParticipantes());
		
		// ------------------------------------------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Grupos");
		System.out.println("Cantidad de participantes, grupo " + g0.getNombre() + ": " + g0.cantPart());
		System.out.println("Cantidad de participantes, grupo " + g1.getNombre() + ": " + g1.cantPart());

		System.out.println("Instrumentos del grupo " + g0.getNombre() + ": " + g0.getInstrumentos());
		System.out.println("Instrumentos del grupo " + g1.getNombre() + ": " + g1.getInstrumentos());

		System.out.println("Idiomas del grupo " + g0.getNombre() + ": " + g0.getIdiomas());
		System.out.println("Idiomas del grupo " + g1.getNombre() + ": " + g1.getIdiomas());

		System.out.println("Generos del grupo " + g0.getNombre() + " (intersección): " + g0.getGeneros());
		System.out.println("Generos del grupo " + g1.getNombre() + " (intersección): " + g1.getGeneros());

		System.out.println("Promedio de edad, grupo " + g0.getNombre() + ": " + g0.getEdad());
		System.out.println("Promedio de edad, grupo " + g1.getNombre() + ": " + g1.getEdad());
		
		// ------------------------------------------------------------------------------------------
		// ------------------ prueba de aceptación coach exigente ------------
		System.out.println("---------------------------------------------");
		System.out.println("Coach exigente:" + c3);
		prod.addParticipante(p8, c3); // a este si lo agrega 
		prod.addParticipante(p2, c3); // a este no lo agrega 
		System.out.println("Coach exigente:" + c3);

		// ------------------- detalle de equipos por
		// coach----------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Coaches: " + prod.getCoaches());

		// ------------------------------ listados
		// ------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Listados");
		System.out.println("Instrumentos (sin repetidos) que pueden tocar los participantes de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getInstrumentos());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getInstrumentos());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getInstrumentos());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getInstrumentos());

		System.out.println("------------");
		System.out.println("Idiomas (sin repetidos) que en pueden cantar los participantes de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getIdiomas());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getIdiomas());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getIdiomas());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getIdiomas());

		System.out.println("------------");
		System.out.println("Generos de preferencia (sin repetidos y alfabéticamente) de los participantes de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getGeneros());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getGeneros());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getGeneros());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getGeneros());

		System.out.println("------------");
		System.out.println("Promedio de edad del equipo de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getEdad());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getEdad());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getEdad());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getEdad());

		
		System.out.println("---------------------------------------------");
		System.out.println("Busquedas");
		System.out.println("Todos los participantes del reality que cantan en ingles...");
		System.out.println(prod.buscar(cIngles));

		System.out.println("------------");
		System.out.println("Participantes que cantan en ingles de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.buscar(cIngles));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.buscar(cIngles));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.buscar(cIngles));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.buscar(cIngles));

		System.out.println("------------");
		System.out.println("Todos los participantes del reality que prefieren el rock...");
		System.out.println(prod.buscar(cRock));

		System.out.println("Participantes que prefieren rock de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.buscar(cRock));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.buscar(cRock));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.buscar(cRock));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.buscar(cRock));

		System.out.println("------------");
		Criterio cAlemanGuitarra = new CriterioAnd(new CriterioIdioma("Aleman"), new CriterioInstrumento("Guitarra"));
		System.out.println("Todos los participantes del reality que cantan en alemán y tocan la guitarra...");
		System.out.println(prod.buscar(cAlemanGuitarra));

		System.out.println("Participantes que cantan en alemán y tocan la guitarra de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.buscar(cAlemanGuitarra));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.buscar(cAlemanGuitarra));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.buscar(cAlemanGuitarra));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.buscar(cAlemanGuitarra));

		System.out.println("------------");
		Criterio cEdad = new CriterioEdad(15);
		System.out.println("Todos los participantes del reality mayores de 15 años...");
		System.out.println(prod.buscar(cEdad));

		System.out.println("Participantes mayores de 15 años de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.buscar(cEdad));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.buscar(cEdad));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.buscar(cEdad));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.buscar(cEdad));

		System.out.println("------------");
		Criterio cTM = new CriterioTemaMusical(tm0);
		System.out.println("Todos los participantes del reality que pueden cantar Rincón de luz...");
		System.out.println(prod.buscar(cTM));

		System.out.println("Participantes que pueden cantar Rincón de luz de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.buscar(cTM));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.buscar(cTM));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.buscar(cTM));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.buscar(cTM));

		System.out.println("------------");
		Criterio cOrAndNot = new CriterioAnd(new CriterioOr(new CriterioIdioma("Ingles"), new CriterioGenero("Jazz")),
				new CriterioNot(new CriterioInstrumento("Piano")));
		System.out.println("Todos los participantes del reality que cantan en ingles o prefieran jazz y no toquen el "
				+ "piano...");
		System.out.println(prod.buscar(cOrAndNot));

		System.out.println("Participantes que cantan en ingles o prefieran jazz y no toquen el piano de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.buscar(cOrAndNot));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.buscar(cOrAndNot));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.buscar(cOrAndNot));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.buscar(cOrAndNot));

		// ------------------------------ batallas 
		// ------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Batallas");
		System.out.println("---------------------------------------------");
		// - Si la cantidad de instrumentos que toca es mayor que la de su oponente...
		prod.setComparador(new ComparadorInstrumento());
		
		System.out.println("Batalla entre el mejor de cada coach:");
		System.out.println(prod.getPreseleccionados());
		System.out.println("Toca mas instrumentos y gana esta batalla: "+   prod.batallar().getNombre());
		
		System.out.println("------------");
		System.out.println("Batalla entre el mejor del coach c1 y c3");
		System.out.println(prod.getPreseleccionado(c1));
		System.out.println(prod.getPreseleccionado(c3));
		System.out.println("Gana: "+prod.batallar(prod.getPreseleccionado(c1), prod.getPreseleccionado(c3)));

		System.out.println("---------------------------------------------");
		// - Si la cantidad de generos preferidos es menor que la de su oponente...
		prod.setComparador(new ComparadorGenero());
		
		System.out.println("Seleccion mejor de cada coach:");
		System.out.println(prod.getPreseleccionados());
		System.out.println("refiere menor cantidad de generos y gana esta batalla: "+   prod.batallar().getNombre());
		
		System.out.println("------------");
		System.out.println("Seleccion coach c3 y c0");
		System.out.println(prod.getPreseleccionado(c3));
		System.out.println(prod.getPreseleccionado(c0));
		System.out.println("Gana: "+prod.batallar(prod.getPreseleccionado(c3), prod.getPreseleccionado(c0)));

		
		System.out.println("---------------------------------------------");
		// - Si la cantidad de instrumentos que toca es mayor a la de su rival, y en caso de ser iguales se desempata por que que tiene mayor edad...
		prod.setComparador(new ComparadorInstrumento(new ComparadorEdad()));

		System.out.println("Seleccion mejor de cada coach:");
		System.out.println(prod.getPreseleccionados());
		System.out.println("Toca mas instrumentos o es mayor de edad y gana esta batalla: "+   prod.batallar().getNombre());
		
		System.out.println("------------");
		System.out.println("Seleccion coach c0 y c1");
		System.out.println(prod.getPreseleccionado(c0));
		System.out.println(prod.getPreseleccionado(c1));
		System.out.println("Gana: "+prod.batallar(prod.getPreseleccionado(c0), prod.getPreseleccionado(c1)));

		System.out.println("---------------------------------------------");
		// - Si la edad es mayor que la de su oponente y en caso de empate se decide por quién sabe mas idiomas que su oponente...
		prod.setComparador(new ComparadorEdad(new ComparadorIdioma()));
		System.out.println("Seleccion mejor de cada coach:");
		System.out.println(prod.getPreseleccionados());
		System.out.println("Su edad es mayor o sabe mas idiomas y gana esta batalla: "+   prod.batallar().getNombre());
		
		System.out.println("------------");
		System.out.println("Seleccion coach c3 y c1");
		System.out.println(prod.getPreseleccionado(c3));
		System.out.println(prod.getPreseleccionado(c1));
		System.out.println("Gana: "+prod.batallar(prod.getPreseleccionado(c3), prod.getPreseleccionado(c1)));

		
		System.out.println("---------------------------------------------");
		// Los anteriores son algunos ejemplos de batallas entre dos participantes,
		// puede ser incluso que haya mas de dos formas encadenadas, es decir que 
		// si las dos primeras dan empate se decide por una tercera forma.		prod.setComparador(new ComparadorEdad(new ComparadorIdioma()));
		prod.setComparador(new ComparadorEdad(new ComparadorIdioma(new ComparadorInstrumento())));
		System.out.println("Seleccion mejor de cada coach:");
		System.out.println(prod.getPreseleccionados());
		System.out.println("Su edad es la mayor: "+   prod.batallar().getNombre());
		
		System.out.println("------------");
		System.out.println("Seleccion coach c0 y c1");
		System.out.println(prod.getPreseleccionado(c0));
		System.out.println(prod.getPreseleccionado(c1));
		System.out.println("Gana: "+prod.batallar(prod.getPreseleccionado(c0), prod.getPreseleccionado(c1)));

	}

}
