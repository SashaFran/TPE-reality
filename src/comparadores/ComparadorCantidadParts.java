package comparadores;

import reality.Coach;


import java.util.Comparator;

public class ComparadorCantidadParts implements Comparator<Coach> {

	/*	Este comparador es utilizado por Produccion, para asignar participantes al coach que menos tiene
		cuando no se le pasa uno específico como parámetro.*/
    public ComparadorCantidadParts() {
    	
    }

    @Override
    public int compare(Coach o1, Coach o2) {
        return o1.cantPart() - o2.cantPart();
    }

}
