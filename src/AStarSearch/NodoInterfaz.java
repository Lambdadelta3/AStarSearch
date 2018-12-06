/*
 * Interface the node needs to implement in order to work with the algorithm
 */
package AStarSearch;

import java.util.List;

public interface NodoInterfaz {

    //these 3 are the only methods actually called by A.Star.Search so they are indispensable
    
    //compares states, needed to avoid repetitions
    boolean esIgual(NodoInterfaz b);
    //quality of life
    void escribirNodo();
    //gets the nodes created from expanding this node
    List<NodoInterfaz> expandir();
    //gets the node that expaded this node, useful for getting the final shortest path
    NodoInterfaz getPadre();
    //used for the sake of sorting and selecting the best node
    int getCalidad();
    //calls the evaluation function of the node
    void evaluar();

}
