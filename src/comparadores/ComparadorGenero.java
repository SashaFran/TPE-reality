package comparadores;

import java.util.Comparator;
import reality.ElementoReality;

public class ComparadorGenero extends Comparador{

	public ComparadorGenero() {
		super();
	}

	public ComparadorGenero(Comparator<ElementoReality> siguiente){
		super(siguiente);
	}

	@Override
	public int comparar(ElementoReality o1, ElementoReality o2) {
		return ((o2.getGeneros()).size())-((o1.getGeneros()).size());
	} 
}
