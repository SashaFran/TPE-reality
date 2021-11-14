package comparadores;
import java.util.Comparator;
import reality.ElementoReality;

/*
Una batalla implica que dos participantes (sea banda, grupo o solista) se enfrenten entre sí
(puede ser incluso un solista contra una banda). Si un participante gana una batalla contra
otro participante se retorna 1, en el caso de empate un 0 y en el caso de que pierda un -1.
Como la producción es medio caprichosa existen diferentes formas de poder determinar si un
participante gana una batalla, que la producción puede cambiar en cualquier momento
dependiendo del rating que está teniendo el programa (...) puede ser incluso que haya
más de dos formas encadenadas, es decir que si las dos primeras dan empate se decide por una
tercera forma. Se debe proveer un mecanismo que permita que en el concurso se enfrenten dos
participantes y se determine el ganador acorde a la forma de la batalla que se esté utilizando en ese
momento.
 */

public class ComparadorEdad implements Comparator <ElementoReality>{


	private Comparator<ElementoReality> siguiente;


	public ComparadorEdad() {}

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
