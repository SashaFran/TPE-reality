package reality.comparadores;

import java.util.Comparator;

import reality.ElementoReality;

public class ComparadorEdad implements Comparator <ElementoReality>{

	private Comparator<ElementoReality> siguiente;
	
	public ComparadorEdad(Comparator<ElementoReality> siguiente){
		this.siguiente = siguiente;
	}
	
	@Override
	public int compare(ElementoReality o1, ElementoReality o2) {
		int aux = (o1.getEdad()) - (o2.getEdad());
		
		if (aux == 0)
			return siguiente.compare(o1, o2);
		else if (aux < 0)
			return -1;
		else
			return 1;
	}
	
}
