/*
 * The HanoiTowers Node, full implementation of the interface inheriting the template node.
 */
package HanoiTower;

import AStarSearch.NodoAbstracto;
import AStarSearch.NodoInterfaz;
import java.util.ArrayList;
import java.util.List;


public class HanoiTower extends NodoAbstracto{

    
    EstadoHanoi estado;

    
    
    public HanoiTower(HanoiTower ht)
    {
        super(ht);
        this.estado = (EstadoHanoi)ht.estado.clonar();
    }
    
    public HanoiTower(int[] _a, int[] _b, int[] _c)
    {
        super();
        this.estado = new EstadoHanoi();
        this.estado.columnaA = new Columna(_a);
        this.estado.columnaB= new Columna(_b);
        this.estado.columnaC = new Columna(_c);
    }
    
    
    
    @Override
    public void evaluar() {
        int max = this.estado.columnaA.fichas.size() + this.estado.columnaB.fichas.size() + this.estado.columnaC.fichas.size();
        int mayorRadioDesc=0;
        
        
        for(int i=0; i< max; i++)
        {
            if(this.estado.columnaC.fichas.size()<=i)
            {
                mayorRadioDesc = max-i;
                break;
            }
                
                
            if(this.estado.columnaC.fichas.get(this.estado.columnaC.fichas.size()-1-i).valor != max-i)
            {
                mayorRadioDesc = max-i;
                break;
            }
        }
        
        this.setEvaluacion((int) Math.pow(2, mayorRadioDesc)-1);
        
        this.setCalidad(this.getEvaluacion() + this.getProfundidad());
        
    }

    @Override
    public boolean inseguro() 
    {
        if(this.estado.inseguro())
            return true;
        
        return false;
    }

    @Override
    public boolean esIgual(NodoInterfaz b) {
        if(this.estado.esIgual(b))
            return true;
        
        return false;
    }

    @Override
    public void escribirNodo() {
        System.out.println("");
        estado.escribir();
    }

    @Override
    public List<NodoInterfaz> expandir() {
        List<NodoInterfaz> nodos = new ArrayList();
        
        //A a B
        HanoiTower nodoHT = new HanoiTower(this);
        if(!this.estado.columnaA.fichas.isEmpty())
        {
            nodoHT.estado.columnaB.fichas.add(0,this.estado.columnaA.fichas.get(0));
            nodoHT.estado.columnaA.fichas.remove(0);
            if(!nodoHT.inseguro())
                nodos.add(nodoHT);
        }
        
        //B a A
        nodoHT = new HanoiTower(this);
        if(!this.estado.columnaB.fichas.isEmpty())
        {
            nodoHT.estado.columnaA.fichas.add(0,this.estado.columnaB.fichas.get(0));
            nodoHT.estado.columnaB.fichas.remove(0);
            if(!nodoHT.inseguro())
                nodos.add(nodoHT);
        }
        
        //A a C
        nodoHT = new HanoiTower(this);
        if(!this.estado.columnaA.fichas.isEmpty())
        {
            nodoHT.estado.columnaC.fichas.add(0,this.estado.columnaA.fichas.get(0));
            nodoHT.estado.columnaA.fichas.remove(0);
            if(!nodoHT.inseguro())
                nodos.add(nodoHT);
        }
        
        //C a A
        nodoHT = new HanoiTower(this);
        if(!this.estado.columnaC.fichas.isEmpty())
        {
            nodoHT.estado.columnaA.fichas.add(0,this.estado.columnaC.fichas.get(0));
            nodoHT.estado.columnaC.fichas.remove(0);
            if(!nodoHT.inseguro())
                nodos.add(nodoHT);
        }
        
        //B a C
        nodoHT = new HanoiTower(this);
        if(!this.estado.columnaB.fichas.isEmpty())
        {
            nodoHT.estado.columnaC.fichas.add(0,this.estado.columnaB.fichas.get(0));
            nodoHT.estado.columnaB.fichas.remove(0);
            if(!nodoHT.inseguro())
                nodos.add(nodoHT);
        }
        

        
        //C a B
        nodoHT = new HanoiTower(this);
        if(!this.estado.columnaC.fichas.isEmpty())
        {
            nodoHT.estado.columnaB.fichas.add(0,this.estado.columnaC.fichas.get(0));
            nodoHT.estado.columnaC.fichas.remove(0);
            if(!nodoHT.inseguro())
                nodos.add(nodoHT);
        }
        
        return nodos;
    }


}
