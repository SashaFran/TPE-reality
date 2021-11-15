package comparadores;
import java.util.Comparator;

import reality.ElementoReality;

/*
Como la producción es medio caprichosa existen diferentes formas de poder determinar si un participante
gana una batalla, que la producción puede cambiar en cualquier momento dependiendo del rating que está
teniendo el programa:
● Si la cantidad de instrumentos que toca es mayor que la de su oponente...
 */

public class ComparadorInstrumento implements Comparator <ElementoReality>{


	private Comparator<ElementoReality> siguiente;


	public ComparadorInstrumento() {}

	public ComparadorInstrumento(Comparator<ElementoReality> siguiente){
		this.siguiente = siguiente;
	}


	@Override
	public int compare(ElementoReality o1, ElementoReality o2) {
		int aux = ((o1.getInstrumentos()).size())-((o2.getInstrumentos()).size());
		if(this.siguiente != null){   //agrego
			if (aux ==0)
				return siguiente.compare(o1, o2);
			else if(aux < 0)
				return -1;
			else
				return 1;
		} else {
			return aux;
		}
	}

}