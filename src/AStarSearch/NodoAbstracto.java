/*
 * Basic template of a node, it isnt needed for comunicating with the algorithm, but it encompasses most of the important functionaliteis in a
 * simple way
 */
package AStarSearch;


public abstract class NodoAbstracto implements NodoInterfaz{
    
    NodoAbstracto padre = null;
    int h;
    int f;
    int g;
 
    
    public NodoAbstracto(NodoAbstracto p)
    {
        this.padre = p;
        this.g = p.getProfundidad() + 1;

    }
    public NodoAbstracto()
    {
        this.padre = null;
        this.g = 0;

    }
    

    @Override
    public NodoAbstracto getPadre()
    {
        return this.padre;
    }
    
    @Override
    public int getCalidad()
    {
       return this.h;
    }
    public void setCalidad(int c)
    {
        this.h=c;
    }
    //used for stablishing the depth of the created nodes depending on their father
    public int getProfundidad()
    {
        return this.g;
    }
    
    public void setEvaluacion(int e)
    {
        this.f = e;
    }
    
    public int getEvaluacion()
    {
        return this.f;
    }
    //checks possible wrong states defined by the game's rules
    public abstract boolean inseguro();

    
    
}
