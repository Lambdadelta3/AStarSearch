/*
 * Basic column structure
 */
package HanoiTower;

import java.util.ArrayList;
import java.util.List;


public class Columna {
    List<Ficha> fichas;
    
    
    Columna (Columna b)
    {
        this.fichas = new ArrayList<>(b.fichas);
    }

    Columna(int[] col) {
       fichas = new ArrayList();
       for (int i : col)
        {
            Ficha _a = new Ficha(i);
            fichas.add(_a);
        }
    }
    
    boolean esIgual(Columna a) 
    {
        if(this.fichas.size()!=a.fichas.size())
            return false;
        
        for(int i= 0; i<this.fichas.size();i++)
        {
            if(this.fichas.get(i).valor != a.fichas.get(i).valor)
                return false;
        }
        return true;
    }
    
    void escribir()
    {
        System.out.print("(");
        for(int i=0; i<fichas.size(); i++)
        {
            System.out.print(fichas.get(i).getValor());
            if(i < fichas.size()-1)
                System.out.print(",");
        }
        System.out.print(")");
    }
    
   
    
}
