package comparadores;

import java.util.Comparator;

import reality.ElementoReality;

public class ComparadorIdioma implements Comparator <ElementoReality>{


	private Comparator<ElementoReality> siguiente;


	public ComparadorIdioma() {
		this.siguiente = null;
	}

	public ComparadorIdioma(Comparator<ElementoReality> siguiente){
		this.siguiente = siguiente;
	}


	@Override
	public int compare(ElementoReality o1, ElementoReality o2) {
		int aux = ((o1.getIdiomas()).size())-((o2.getIdiomas()).size());
		
		if (aux ==0) {
			if (siguiente != null)
				return siguiente.compare(o1, o2);
			else
				return 0;
		}
		else if(aux < 0)
			return -1;
		else
				return 1;
	}

}
