/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author NASA
 */
public class LabyrinthAutomatedSolver extends LabyrinthObservableSolver{

    private Labyrinth labyrinth;
    private final Stack<Character> solutionStack;
    private final Set<Cell> visited;
    private Cell currentCell;

    public LabyrinthAutomatedSolver() {
        solutionStack = new Stack<>();
        visited = new HashSet<>();
        
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
        solutionStack.add('S');
        visited.clear();
        this.labyrinth = labyrinth;
        this.currentCell = this.labyrinth.getStartCell();
        visited.add(currentCell);
        
    }

    @Override
    public boolean foundSolution() {
        return labyrinth.isFinishCell(currentCell);
    }

    @Override
    public Stack<Character> getCurrentPath() {
        return solutionStack;
    }
    
    @Override
    public void solve() {
        while(true){
            nextCellToExplore();
            if(solutionStack.empty())
                break;
            if(labyrinth.isFinishCell(currentCell))
                break;
        }
    }
    
    private boolean isValidMove(Cell cell){
        if(cell.row < 0 || cell.row >= labyrinth.getRowCount())
            return false;
        if(cell.column < 0 || cell.column >= labyrinth.getColumnCount())
            return false;
        if(labyrinth.isWallAt(cell)){
            return false;
        }
        return !visited.contains(cell);
    }
    
    private boolean goUp(){
        Cell newCell = new Cell(currentCell.row - 1, currentCell.column);
        if(isValidMove(newCell)){
            currentCell = newCell;
            visited.add(currentCell);
            solutionStack.add('U');
            return true;
        }
        return false;
    }
    private boolean goDown(){
        Cell newCell = new Cell(currentCell.row + 1, currentCell.column);
        if(isValidMove(newCell)){
            currentCell = newCell;
            visited.add(currentCell);
            solutionStack.add('D');
            return true;
        }
        return false;
    }
    private boolean goLeft(){
        Cell newCell = new Cell(currentCell.row, currentCell.column - 1);
        if(isValidMove(newCell)){
            currentCell = newCell;
            visited.add(currentCell);
            solutionStack.add('L');
            return true;
        }
        return false;
    }
    private boolean goRight(){
        Cell newCell = new Cell(currentCell.row, currentCell.column + 1);
        if(isValidMove(newCell)){
            currentCell = newCell;
            visited.add(currentCell);
            solutionStack.add('R');
            return true;
        }
        return false;
    }
    
    private void foreceGoUp(){
        Cell newCell = new Cell(currentCell.row - 1, currentCell.column);
        currentCell = newCell;
    }
    private void foreceGoDown(){
        Cell newCell = new Cell(currentCell.row + 1, currentCell.column);
        currentCell = newCell;
    }
    private void foreceGoLeft(){
        Cell newCell = new Cell(currentCell.row, currentCell.column - 1);
        currentCell = newCell;
    }
    private void foreceGoRight(){
        Cell newCell = new Cell(currentCell.row, currentCell.column + 1);
        currentCell = newCell;
    }
    
    private boolean goBack(){
        if(!solutionStack.empty()){
            switch(solutionStack.pop()){
                case 'D':
                    foreceGoUp(); break;
                case 'U':
                    foreceGoDown(); break;
                case 'L':
                    foreceGoRight(); break;
                case 'R':
                    foreceGoLeft(); break;
            }
            return true;
        }
        else return false;
    }
    
    @Override
    public void nextCellToExplore() {
        
        if(!goDown())
            if(!goRight())
                if(!goUp())
                    if(!goLeft())
                        goBack();
        
        
        this.notifyObservers();
    }
    
}
