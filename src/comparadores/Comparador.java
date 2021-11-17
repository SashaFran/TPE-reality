package comparadores;

import java.util.Comparator;
import reality.ElementoReality;

public abstract class Comparador implements Comparator <ElementoReality>{

	private Comparator<ElementoReality> siguiente;

	public Comparador(){
		this.siguiente = null;
	}

	public Comparador(Comparator<ElementoReality> siguiente){
		this.siguiente = siguiente;
	}

	public abstract int comparar (ElementoReality o1, ElementoReality o2);
	
	@Override
	public int compare(ElementoReality o1, ElementoReality o2) {
		int aux = this.comparar(o1, o2);
		if (aux == 0) {
			if (siguiente != null)
				return siguiente.compare(o1, o2);
			else return 0;
		}
		else if (aux < 0)
			return -1;
		else
			return 1;
	}
}


