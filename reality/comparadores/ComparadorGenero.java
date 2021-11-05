package reality.comparadores;

import java.util.Comparator;

import reality.ElementoReality;

public class ComparadorGenero implements Comparator <ElementoReality>{

	private Comparator<ElementoReality> siguiente;
	
	public ComparadorGenero(Comparator<ElementoReality> siguiente){
		this.siguiente = siguiente;
	}
	
		@Override
		public int compare(ElementoReality o1, ElementoReality o2) {
			int aux = ((o2.getGeneros()).size())-((o1.getGeneros()).size());
			if (aux == 0)
				return siguiente.compare(o1, o2);
			else if(aux < 0)
				return -1;
				return 1;
		}
}
