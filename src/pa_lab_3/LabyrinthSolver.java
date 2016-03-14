/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.util.List;

/**
 *
 * @author NASA
 */
public interface LabyrinthSolver {
    
    /**
     * 
     * @return  a copy of the Labyrinth object stored by the solver.
     */
    Labyrinth getLabyrinth();

    /**
     *
     * @param labyrinth the Labyrinth object which will be copied and stored by the solver.
     */
    void setLabyrinth(Labyrinth labyrinth);
    
    /**
     * 
     * @return  List of characters representing the path from startCell to finishCell if on is found.
     *          Possible characters are: D - down U - up L - left and R - right.
     *          If a path is not found it returns null.
     */
    List<Character> solve();
    
    /**
     * 
     * @param command   Where to go in the labyrinth: UP DOWN LEFT RIGHT;
     * @return          List of characters representing the path from startCell to finishCell if on is found.
     *                  Possible characters are: D - down U - up L - left and R - right.
     *                  If a path is not found it returns null.
     */
    List<Character> nextCellToExplore(String command);
}
