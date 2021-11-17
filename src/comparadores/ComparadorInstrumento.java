package comparadores;

import java.util.Comparator;
import reality.ElementoReality;

public class ComparadorInstrumento extends Comparador{

	public ComparadorInstrumento() {
		super();
	}

	public ComparadorInstrumento(Comparator<ElementoReality> siguiente){
		super(siguiente);
	}

	@Override
	public int comparar(ElementoReality o1, ElementoReality o2) {
		return ((o1.getInstrumentos()).size())-((o2.getInstrumentos()).size());
	}
}