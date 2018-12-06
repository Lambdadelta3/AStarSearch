/*
 * General A* algorithm
 */
package AStarSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AStarSearch {
    
    
    List<NodoInterfaz> abiertos;
    List<NodoInterfaz> cerrados;
    
    public AStarSearch(NodoInterfaz origen, NodoInterfaz destino)
    {
        abiertos = new ArrayList();
        cerrados = new ArrayList();
        
        int nodosExplorados = 0;
        añadirAbiertos(origen);
        NodoInterfaz nodoActual = origen;
        
        while(!nodoActual.esIgual(destino))
        {
            List<NodoInterfaz> nodosExpandidos = nodoActual.expandir();
            
            for(NodoInterfaz n: nodosExpandidos)
                if(!repetido(n))
                {
                    n.evaluar();
                    añadirAbiertos(n);
                }
            
            añadirCerrados(nodoActual);
            Collections.sort(abiertos, new ComparadorCalidadNodos());
            
            nodoActual = abiertos.get(0);
            
            nodosExplorados++;
            
           // escribir();
            
        }

        
        escribirCamino(nodoActual);
        System.out.println("");
        System.out.println("Nodos Explorados: "+nodosExplorados);
        
        
    }
    
    
    
    void añadirAbiertos(NodoInterfaz a)
    {
        abiertos.add(a);
    }
    
    void añadirCerrados(NodoInterfaz a)
    {
        abiertos.remove(a);
        cerrados.add(a);
    }
    boolean repetido(NodoInterfaz a)
    {
        for(NodoInterfaz n: abiertos)
        {
            if(a.esIgual(n))
                return true;
        }
        
        for(NodoInterfaz n: cerrados)
        {
            if(a.esIgual(n))
                return true;
        }
        
        return false;
    }
    
    
        void escribirCamino(NodoInterfaz a)
    {
        List<NodoInterfaz> camino = new ArrayList();
        camino.add(a);
        while(a.getPadre() != null)
        {
            camino.add(0,a.getPadre());
            a=a.getPadre();
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Camino Final:");
                for(NodoInterfaz n : camino)
        {
          
          n.escribirNodo();
        }
    }
    
    void escribir()
    {
        System.out.println("");
        System.out.print("Lista de abiertos: ");
        for(NodoInterfaz n : abiertos)
        {
            n.escribirNodo();
            
        }
        System.out.println("");
        
        
        System.out.print("Lista de cerrados: ");
        for(NodoInterfaz n : cerrados)
        {
          
          n.escribirNodo();
        }
        System.out.println("");
        
    }
    
}
