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
        return this.labyrinth;
    }

    @Override
    public void setLabyrinth(Labyrinth labyrinth) {
        solutionStack.removeAllElements();
        this.labyrinth = labyrinth;
        this.currentCell = this.labyrinth.getStartCell();
    }

    @Override
    public void solve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean isValidMove(Cell cell){
        if(cell.row < 0 || cell.row >= labyrinth.getRowCount())
            return false;
        if(cell.column < 0 || cell.column >= labyrinth.getColumnCount())
            return false;
        return !labyrinth.isWallAt(cell);
    }
    
    @Override
    public void nextCellToExplore() {
        
        
        
        this.notifyObservers();
    }
    
}
