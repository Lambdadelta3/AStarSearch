/*
 * Extension of the estate template for HanoiTowers, has the state of the 3 columns 
 */
package HanoiTower;

import AStarSearch.EstadoAbstracto;


public class EstadoHanoi extends EstadoAbstracto{

    Columna columnaA;
    Columna columnaB;
    Columna columnaC;
    
    
    @Override
    public boolean inseguro() {
        
        if(columnaA.fichas.size()>1)
            if(columnaA.fichas.get(0).getValor()>columnaA.fichas.get(1).getValor())
                return true;
        
        if(columnaB.fichas.size()>1)
            if(columnaB.fichas.get(0).getValor()>columnaB.fichas.get(1).getValor())
                return true;
        
        if(columnaC.fichas.size()>1)
            if(columnaC.fichas.get(0).getValor()>columnaC.fichas.get(1).getValor())
                return true;
        
        return false;
    }
    @Override
    public boolean esIgual(Object estadob)
    {     
        if(this.columnaA.esIgual(((HanoiTower)estadob).estado.columnaA))
            if(this.columnaB.esIgual(((HanoiTower)estadob).estado.columnaB))
                if(this.columnaC.esIgual(((HanoiTower)estadob).estado.columnaC))
                    return true;
        
        return false;
    }

    @Override
    public void escribir() {
        System.out.print("[");
        columnaA.escribir();
        System.out.print(",");
        columnaB.escribir();
        System.out.print(",");
        columnaC.escribir();
        System.out.print("]");
    }

    @Override
    public EstadoAbstracto clonar() {
        EstadoHanoi estadob = new EstadoHanoi();
        
        estadob.columnaA = new Columna(this.columnaA);
        estadob.columnaB = new Columna(this.columnaB);
        estadob.columnaC = new Columna(this.columnaC);
        
        return estadob;
    }


    

}
