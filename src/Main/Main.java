/*
 * Just the main from which the program executes
 */
package Main;

import AStarSearch.AStarSearch;
import AStarSearch.NodoInterfaz;
import HanoiTower.HanoiTower;


public class Main 
{
    
    static NodoInterfaz origen = (NodoInterfaz) new HanoiTower( new int[] {1,2,3,4,5,6,7,8,9,10},new int[]  {},new int[]  {});
    static NodoInterfaz destino = (NodoInterfaz) new HanoiTower( new int[] {},new int[]  {},new int[]  {1,2,3,4,5,6,7,8,9,10});
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        AStarSearch res = new AStarSearch(origen, destino);
        
        
    }

}
