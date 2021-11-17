package comparadores;

import java.util.Comparator;
import reality.ElementoReality;

public class ComparadorEdad extends Comparador{


	public ComparadorEdad(){
		super();
	}

	public ComparadorEdad(Comparator<ElementoReality> siguiente){
		super(siguiente);
	}

	@Override
	public int comparar(ElementoReality o1, ElementoReality o2) {
			return (o1.getEdad()) - (o2.getEdad());
	}
}
