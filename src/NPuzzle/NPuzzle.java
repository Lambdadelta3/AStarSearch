/*
 *Node implementation for the 8 Puzzle and 15 Puzzle games
 */
package NPuzzle;

import AStarSearch.NodoAbstracto;
import AStarSearch.NodoInterfaz;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NPuzzle extends NodoAbstracto{
    
    int [][] estado;
    //coordinates of the blank or 0
    int x;
    int y;
    int precision;
    
    public NPuzzle(int [][] estadoIni, int pre)
    {
        super();
        this.estado = estadoIni.clone();
        for(int i=0; i<this.estado.length; i++)
        {
            for(int j=0; j<this.estado[i].length; j++)
            {
                if(this.estado[i][j]==0)
                {
                    this.x = i;
                    this.y = j;
                }
            }
        }
        this.precision=pre;
        
    }
    
    public NPuzzle(NPuzzle p)
    {
        super(p);
        this.estado = p.estado.clone();
        for (int i = 0; i < this.estado.length; i++) 
        {
            this.estado[i] = p.estado[i].clone();
        }
        this.x = p.x;
        this.y = p.y;
        this.precision=p.precision;
    }
    

    @Override
    public boolean inseguro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esIgual(NodoInterfaz b) {
        if(Arrays.deepEquals(this.estado, ((NPuzzle)b).estado))
                return true;
        
        return false;
    }

    @Override
    public void escribirNodo() {
        System.out.println("");
        System.out.println("Nodo Valor " + this.getCalidad() + ":");
        for(int[] a : this.estado)
        {
            System.out.println("");
            System.out.print("|");
            for(int i : a)
            {
                System.out.print(i + "|");
            }
            System.out.println("");
            for(int i : a)
            {
                System.out.print("_");
                System.out.print("_");
            }
        }
    }

    @Override
    public List<NodoInterfaz> expandir() {
         List<NodoInterfaz> nodos = new ArrayList();
        
         NPuzzle nodoNP;
        //Izquierda
        if(this.y>0)
        {
            nodoNP = new NPuzzle(this);
            nodoNP.estado[x][y] = nodoNP.estado[x][y-1];
            nodoNP.estado[x][y-1]= 0;
            nodoNP.y = nodoNP.y-1;
            nodos.add(nodoNP);
        }
        
        //Derecha
        if(this.y+1 < this.estado[x].length)
        {
            nodoNP = new NPuzzle(this);
            nodoNP.estado[x][y] = nodoNP.estado[x][y+1];
            nodoNP.estado[x][y+1]= 0;
            nodoNP.y = nodoNP.y+1;
            nodos.add(nodoNP);
        }
        
        //Arriba
        if(this.x>0)
        {
            nodoNP = new NPuzzle(this);
            nodoNP.estado[x][y] = nodoNP.estado[x-1][y];
            nodoNP.estado[x-1][y]= 0;
            nodoNP.x = nodoNP.x-1; 
            nodos.add(nodoNP);
        }
        
        //Abajo
        if(this.x+1 < this.estado.length)
        {
            nodoNP = new NPuzzle(this);
            nodoNP.estado[x][y] = nodoNP.estado[x+1][y];
            nodoNP.estado[x+1][y]= 0;
            nodoNP.x = nodoNP.x+1; 
            nodos.add(nodoNP);
        }
        
        
        
        return nodos;
    }

    @Override
    //Evaluation is given by the sum of the distances of every tile to the position it should be in, this evaulation is weighted by 
    //"precision", it should be noted that a precision of 1 will achieve the best possible result, any number above it wont necesarily
    //do the same but will reach a solution in a significantly faster time, especially in 15 puzzle or bigger puzzle games.
    public void evaluar() {
        
        int descolocados = 0;
        int row;
        int col;
        
        for(int i=0; i<this.estado.length; i++)
        {
            for(int j=0; j<this.estado[i].length; j++)
            {
                //counts dispositioned pieces
                if(this.estado[i][j] != 0)
                {
                row = (this.estado[i][j]-1)/this.estado[i].length;
                col = (this.estado[i][j]-1)%this.estado[i].length;
                
                row = abs(row-i);
                col = abs(col-j);
                
                descolocados = descolocados + (row + col)*precision;
                }
            }
        }
        
        this.setEvaluacion(descolocados);
        this.setCalidad(this.getEvaluacion() + this.getProfundidad());
        
    }
    
}
