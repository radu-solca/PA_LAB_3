/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

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
     */
    void nextCellToExplore();
    
    void notifyObservers();
}
