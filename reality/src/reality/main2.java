package reality;

import java.time.LocalDate;
import java.util.ArrayList;
import comparadores.*;
import criterioTm.*;
import criterios.*;

public class main2 {

	public static void main(String[] args) {

		Produccion prod = new Produccion();
		TemaMusical tm0 = new TemaMusical("Rincon de Luz", "Espanol");
		TemaMusical tm1 = new TemaMusical("Age of stone", "Ingles");

		CriterioTm cTM0 = new CriterioFinal();
		
		Criterio cIdioma0 = new CriterioIdioma("Ingles");
		Criterio cGenero0 = new CriterioGenero("Rock");
		Criterio cInstrumento0 = new CriterioInstrumento("Guitarra");
		Criterio cGenero1 = new CriterioGenero("Pop");
		Criterio cInstrumento1 = new CriterioInstrumento("Bateria");
		Criterio cIdioma1 = new CriterioIdioma("Espanol");
		Criterio cIdioma2 = new CriterioIdioma("Ingles");

		Coach c0 = new Coach("C0");
		Coach c1 = new Coach("C1");
		Coach c2 = new CoachExigente("C2", new CriterioAnd(cIdioma0, new CriterioAnd(cGenero0, cInstrumento0)));
		Coach c3 = new CoachExigente("C3", new CriterioAnd(cGenero1, new CriterioAnd(cInstrumento1, new CriterioAnd(cIdioma1, cIdioma2))));

		Participante p0 = new Participante("N0", "A0", LocalDate.of(2000, 1, 02));
		Participante p1 = new Participante("N1", "A1", LocalDate.of(2001, 2, 01));
		Participante p2 = new Participante("N2", "A2", LocalDate.of(2002, 3, 03));
		Participante p3 = new Participante("N3", "A3", LocalDate.of(2003, 4, 04));
		Participante p4 = new Participante("N4", "A4", LocalDate.of(2004, 6, 07));
		Participante p5 = new Participante("N5", "A5", LocalDate.of(2000, 6, 07));
		Participante p6 = new Participante("N6", "A6", LocalDate.of(1995, 6, 07));

		Grupo g0 = new Grupo("G0");
		Grupo g1 = new Grupo("G1");

		// ------------ participantes -----------------------
		p0.addGenero("Country");
		p0.addGenero("Pop");
		p0.addGenero("Pop-Rock");
		p0.addGenero("Rock");
		p1.addGenero("Rock");
		p1.addGenero("Pop-Rock");
		p1.addGenero("Pop");
		p2.addGenero("Metal");
		p2.addGenero("Industrial");
		p3.addGenero("Pop");
		p4.addGenero("Pop-Rock");
		p5.addGenero("Pop");
		p5.addGenero("Pop-Rock");
		p5.addGenero("Industrial");
		p6.addGenero("Pop");
		p6.addGenero("Pop-Rock");
		p6.addGenero("Industrial");
		p0.addIdioma("Ingles");
		p0.addIdioma("Espanol");
		p0.addIdioma("Italiano");
		p0.addIdioma("Aleman");
		p1.addIdioma("Ingles");
		p1.addIdioma("Espanol");
		p1.addIdioma("Italiano");
		p2.addIdioma("Ingles");
		p2.addIdioma("Frances");
		p3.addIdioma("Ingles");
		p3.addIdioma("Frances");
		p4.addIdioma("Ingles");
		p4.addIdioma("Frances");
		p5.addIdioma("Ingles");
		p5.addIdioma("Frances");
		p6.addIdioma("Ingles");
		p6.addIdioma("Frances");
		p0.addInstrumento("Guitarra");
		p0.addInstrumento("Piano");
		p0.addInstrumento("Bateria");
		p1.addInstrumento("Piano");
		p1.addInstrumento("Guitarra");
		p2.addInstrumento("Piano");
		p3.addInstrumento("Piano");
		p3.addInstrumento("Bateria");
		p4.addInstrumento("Piano");
		p4.addInstrumento("Bateria");
		p5.addInstrumento("Ukelele");
		p5.addInstrumento("Bajo");
		p6.addInstrumento("Ukelele");
		p6.addInstrumento("Bajo");

		tm0.addGenero("Rock");
		tm1.addGenero("Punk");
		tm1.addGenero("Rock");
		tm0.addInstrumento("Guitarra");
		tm1.addInstrumento("Guitarra");
		tm1.addInstrumento("Bateria");
		tm0.setCriterio(cTM0);

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
		prod.addParticipante(p0);
		prod.addParticipante(p1);
		prod.addParticipante(p2);
		prod.addParticipante(p3);
		prod.addParticipante(p4);
		prod.addParticipante(p5);
		prod.addParticipante(p6);

		c0.add(g1);

		// ------------------------------------------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Participantes");
		ArrayList<ElementoReality> parts = prod.getParticipantes();
		for (ElementoReality thi : parts) {
			System.out.println("Nombre y Apellido: " + thi.getNombre() + "\n" + "Edad: " + thi.getEdad() + "\n"
					+ "Generos: " + thi.getGeneros() + "\n" + "Idiomas: " + thi.getIdiomas() + "\n" + "Instrumentos: "
					+ thi.getInstrumentos() + "\n");
		}

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

		// ------------------ prueba de aceptación coach exigente ------------
//				System.out.println("---------------------------------------------");
//				System.out.println("Coach exigente:" + c3);
//				c3.add(p0);
//				c3.add(p1);
//				System.out.println("Coach exigente:" + c3);

		// ------------------- detalle de equipos por
		// coach----------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Coaches: " + prod.getCoaches());

		// ------------------------------ listados
		// ------------------------------------------------------
		System.out.println("---------------------------------------------");
		System.out.println("Búsquedas");
		// Para una mejor organización, cada coach/jurado desea poder obtener:
		// ● Un listado de todos los instrumentos que pueden tocar los participantes de
		// su equipo (no
		// debe haber repetidos)
		System.out.println("Instrumentos (sin repetidos) que pueden tocar los participantes de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getInstrumentos());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getInstrumentos());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getInstrumentos());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getInstrumentos());

		// ● Un listado de todos los idiomas que pueden cantar los participantes de su
		// equipo (sin idiomas
		// repetidos)
		System.out.println("Idiomas (sin repetidos) que en pueden cantar los participantes de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getIdiomas());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getIdiomas());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getIdiomas());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getIdiomas());

		// ● Un listado de géneros de preferencia de los participantes de su equipo (sin
		// repetidos y
		// ordenados alfabéticamente)
		System.out.println("Géneros de preferencia (sin repetidos y alfabéticamente) de los participantes de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getGeneros());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getGeneros());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getGeneros());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getGeneros());

		// ● El promedio de edad de su equipo
		System.out.println("Promedio de edad del equipo de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getEdad());
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getEdad());
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getEdad());
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getEdad());

		// ----------------------------- búsquedas
		// ------------------------------------------------------
		// Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar
		// entre sus participantes
		// integrantes, bandas o grupos que :
		// ● Canten en un determinado idioma, por ejemplo “inglés”...
		Criterio cIdioma = new CriterioIdioma("Inglés");
		System.out.println("Todos los participantes del reality que cantan en inglés...");
		ArrayList<ElementoReality> list = prod.getListado(cIdioma);
		for (ElementoReality e : list) {
			System.out.println(e.getNombre());
		}

		System.out.println("Participantes que cantan en inglés de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getListado(cIdioma));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getListado(cIdioma));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getListado(cIdioma));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getListado(cIdioma));

		// ● Prefieren un determinado género, por ejemplo “rock”...
		Criterio cGenero = new CriterioGenero("Rock");
		System.out.println("Todos los participantes del reality que prefieren el rock...");
		ArrayList<ElementoReality> list1 = prod.getListado(cGenero);
		for (ElementoReality e : list1) {
			System.out.println(e.getNombre());
		}

		System.out.println("Participantes que prefieren rock de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getListado(cGenero));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getListado(cGenero));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getListado(cGenero));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getListado(cGenero));

		// ● Canten en un determinado idioma y toquen un instrumento específico. Por
		// ejemplo, “Aleman”
		// y “Guitarra”
		Criterio cIdEIn = new CriterioAnd(new CriterioIdioma("Aleman"), new CriterioInstrumento("Guitarra"));
		System.out.println("Todos los participantes del reality que cantan en alemán y tocan la guitarra...");
		ArrayList<ElementoReality> list2 = prod.getListado(cIdEIn);
		for (ElementoReality e : list2) {
			System.out.println(e.getNombre());
		}

		System.out.println("Participantes que cantan en alemán y tocan la guitarra de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getListado(cIdEIn));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getListado(cIdEIn));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getListado(cIdEIn));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getListado(cIdEIn));

		// ● Todos los participantes mayores de una determinada edad.
		Criterio cEdad = new CriterioEdad(15);
		System.out.println("Todos los participantes del reality mayores de 15 años...");
		ArrayList<ElementoReality> list3 = prod.getListado(cEdad);
		for (ElementoReality e : list3) {
			System.out.println(e.getNombre());
		}

		System.out.println("Participantes mayores de 15 años de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getListado(cEdad));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getListado(cEdad));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getListado(cEdad));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getListado(cEdad));

		// ● Puedan Interpretar un determinado Tema Musical
		Criterio cTM = new CriterioTemaMusical(tm0);
		System.out.println("Todos los participantes del reality que pueden cantar Rincón de luz...");
		ArrayList<ElementoReality> list4 = prod.getListado(cTM);
		for (ElementoReality e : list4) {
			System.out.println(e.getNombre());
		}

		System.out.println("Participantes que pueden cantar Rincón de luz de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getListado(cTM));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getListado(cTM));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getListado(cTM));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getListado(cTM));

		// ● Los anteriores son algunos ejemplos de los listados que la producción le
		// pide
		// constantemente a los jurados. Se pueden agregar nuevos requerimientos de
		// búsquedas así
		// como combinación lógicas de los existentes.
		Criterio cOrAndNot = new CriterioAnd(new CriterioOr(new CriterioIdioma("Ingles"), new CriterioGenero("Jazz")),
				new CriterioNot(new CriterioInstrumento("Piano")));
		System.out.println("Todos los participantes del reality que cantan en inglés o prefieran jazz y no toquen el "
				+ "piano...");
		ArrayList<ElementoReality> list5 = prod.getListado(cOrAndNot);
		for (ElementoReality e : list5) {
			System.out.println(e.getNombre());
		}

		System.out.println("Participantes que cantan en inglés o prefieran jazz y no toquen el piano de...");
		System.out.println("Coach " + c0.getNombre() + ": " + c0.getListado(cOrAndNot));
		System.out.println("Coach " + c1.getNombre() + ": " + c1.getListado(cOrAndNot));
		System.out.println("Coach " + c2.getNombre() + ": " + c2.getListado(cOrAndNot));
		System.out.println("Coach " + c3.getNombre() + ": " + c3.getListado(cOrAndNot));

		// ------------------------------ batallas
		// ------------------------------------------------------
		System.out.println("Batallas");

		// ● Si la cantidad de instrumentos que toca es mayor que la de su oponente...
		ArrayList<ElementoReality> batallantes0 = prod.getListado(new ComparadorInstrumento());
		System.out.println("Batallan " + batallantes0.get(0).getNombre() + batallantes0.get(1).getNombre());
		System.out.println("Toca más instrumentos y gana esta batalla: " + batallantes0.get(0).getNombre());

		// ● Si la cantidad de géneros preferidos es menor que la de su oponente...
		ArrayList<ElementoReality> batallantes1 = prod.getListado(new ComparadorGenero());
		System.out.println("Batallan " + batallantes1.get(0).getNombre() + batallantes1.get(1).getNombre());
		System.out.println("Prefiere menor cantidad de géneros y gana esta batalla: " + batallantes1.get(0).getNombre());

		// ● Si la cantidad de instrumentos que toca es mayor a la de su rival, y en
		// caso de ser iguales se desempata
		// por que que tiene mayor edad...
		ArrayList<ElementoReality> batallantes2 = prod.getListado(new ComparadorInstrumento(new ComparadorEdad()));
		System.out.println("Batallan " + batallantes2.get(0).getNombre() + batallantes2.get(1).getNombre());
		System.out.println("Toca más instrumentos o es mayor de edad y gana esta batalla: " + batallantes2.get(0).getNombre());

		// ● Si la edad es mayor que la de su oponente y en caso de empate se decide por
		// quién sabe más idiomas
		// que su oponente...
		ArrayList<ElementoReality> batallantes3 = prod.getListado(new ComparadorEdad(new ComparadorIdioma()));
		System.out.println("Batallan " + batallantes3.get(0).getNombre() + batallantes3.get(1).getNombre());
		System.out.println("Su edad es mayor o sabe más idiomas y gana esta batalla: " + batallantes3.get(0).getNombre());

		// Los anteriores son algunos ejemplos de batallas entre dos participantes,
		// puede ser incluso que haya
		// más de dos formas encadenadas, es decir que si las dos primeras dan empate se
		// decide por una
		// tercera forma.
		ArrayList<ElementoReality> batallantes4 = prod.getListado(new ComparadorEdad(new ComparadorIdioma(new ComparadorInstrumento())));
		System.out.println("Batallan " + batallantes4.get(0).getNombre() + batallantes4.get(1).getNombre());
		System.out.println("Gana esta batalla: " + batallantes4.get(0).getNombre());

	}

}
