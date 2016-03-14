/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author NASA
 */
public class LabyrinthAutomatedSolver extends LabyrinthObservableSolver{

    private Labyrinth labyrinth;
    private final Stack<Character> solutionStack;
    private Cell currentCell;

    public LabyrinthAutomatedSolver() {
        solutionStack = new Stack<>();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public LabyrinthAutomatedSolver(Labyrinth labyrinth) {
        this();
        this.setLabyrinth(labyrinth);
    }
    
    @Override
    public Labyrinth getLabyrinth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLabyrinth(Labyrinth labyrinth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> solve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> nextCellToExplore(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
