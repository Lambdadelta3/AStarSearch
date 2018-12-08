/*
 * Just the main from which the program executes
 */
package Main;

import AStarSearch.AStarSearch;
import AStarSearch.NodoInterfaz;
import HanoiTower.HanoiTower;
import NPuzzle.NPuzzle;


public class Main {

    // Hanoi towers, arguments are just 3 arrays with each column
    static NodoInterfaz origenHanoi = (NodoInterfaz) new HanoiTower( new int[] {1,2,3,4,5,6,7,8,9,10},new int[]  {},new int[]  {});
    static NodoInterfaz destinoHanoi = (NodoInterfaz) new HanoiTower( new int[] {},new int[]  {},new int[]  {1,2,3,4,5,6,7,8,9,10});
    
    
    //N-puzzle, arguments are 1- a matrix of each value of a state 2- the precision of heuristics, 
    //high values can be faster, but will be less precise, for 8-puzzle 1 is fine, for 15-puzzle or
    //bigger 3 or more is adviced
    
    // 8-Puzzle
    static NodoInterfaz origen8Puzzle = (NodoInterfaz) new NPuzzle( new int[][] {{3,0,7},{2,8,1},{6,4,5}},1);
    static NodoInterfaz destino8Puzzle = (NodoInterfaz) new NPuzzle( new int[][] {{1,2,3},{4,5,6},{7,8,0}},1);
    
    
    // 15-Puzzle
    static NodoInterfaz origen15Puzzle = (NodoInterfaz) new NPuzzle( new int[][] {{15,2,1,12},{8,5,6,11},{4,9,10,7}, {3,0,13,14}},3);
    static NodoInterfaz destino15Puzzle = (NodoInterfaz) new NPuzzle( new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}},3);
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        AStarSearch res = new AStarSearch(origen8Puzzle, destino8Puzzle);
        
        
    }

}
