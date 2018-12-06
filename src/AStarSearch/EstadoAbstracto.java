/*
 * Template of the state of a node, not really needed but useful
 */
package AStarSearch;

public abstract class EstadoAbstracto 
{  
    public abstract boolean inseguro();
    public abstract boolean esIgual(Object estadob);
    public abstract void escribir();
    public abstract EstadoAbstracto clonar();
}
