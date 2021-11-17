package comparadores;

import java.util.Comparator;
import reality.ElementoReality;

public class ComparadorIdioma extends Comparador{

	public ComparadorIdioma() {
		super();
	}

	public ComparadorIdioma(Comparator<ElementoReality> siguiente){
		super(siguiente);
	}

	@Override
	public int comparar(ElementoReality o1, ElementoReality o2) {
		return ((o1.getIdiomas()).size())-((o2.getIdiomas()).size());
	}
		
}
