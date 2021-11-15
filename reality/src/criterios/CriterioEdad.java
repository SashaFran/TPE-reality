package criterios;
/*
Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
integrantes, bandas o grupos que :
● Todos los participantes mayores de una determinada edad...
 */
import reality.ElementoReality;

public class CriterioEdad extends Criterio {

	private int limiteEdad;
	
	public CriterioEdad(int edad){
		this.limiteEdad = edad;
	}

	@Override
	public boolean cumple(ElementoReality p1) {
		return p1.getEdad() > limiteEdad;
	}

}
