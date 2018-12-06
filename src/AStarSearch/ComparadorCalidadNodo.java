/*
 * Simple comparator that sorts items based on the quality of the node
 */
package AStarSearch;

import java.util.Comparator;


public class ComparadorCalidadNodos implements Comparator<NodoInterfaz> {


    @Override
    public int compare(NodoInterfaz a1, NodoInterfaz a2) {
        return a1.getCalidad()-a2.getCalidad();
    }
    
}
