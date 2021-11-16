package comparadores;
import java.util.Comparator;

import reality.ElementoReality;

/*
Como la producción es medio caprichosa existen diferentes formas de poder determinar si un participante
gana una batalla, que la producción puede cambiar en cualquier momento dependiendo del rating que está
teniendo el programa:
● Si la cantidad de géneros preferidos es menor que la de su oponente....
 */

public class ComparadorGenero implements Comparator <ElementoReality>{


	private Comparator<ElementoReality> siguiente;


	public ComparadorGenero() {
		this.siguiente = null;
	}

	public ComparadorGenero(Comparator<ElementoReality> siguiente){
		this.siguiente = siguiente;
	}


	@Override
	public int compare(ElementoReality o1, ElementoReality o2) {
		int aux = ((o2.getGeneros()).size())-((o1.getGeneros()).size());
		if(siguiente != null){
			if (aux == 0){
				if (siguiente != null)
					return siguiente.compare(o1, o2);
				else 
					return 0;
			}
			else if(aux < 0)
				return -1;
			//		else			acá no es necesario el else?
			return 1;
		} else {
			return aux;
		}
	}

}
