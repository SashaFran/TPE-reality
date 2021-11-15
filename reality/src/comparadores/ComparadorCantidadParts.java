package comparadores;

import reality.Coach;


import java.util.Comparator;

public class ComparadorCantidadParts implements Comparator<Coach> {

    public ComparadorCantidadParts() {}

    @Override
    public int compare(Coach o1, Coach o2) {
        return o1.cantPart() - o2.cantPart();
    }

}
