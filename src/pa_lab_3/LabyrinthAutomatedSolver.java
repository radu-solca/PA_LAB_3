/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        this.labyrinth = labyrinth;
        this.currentCell = this.labyrinth.getStartCell();
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
            if(visited.size() == labyrinth.getColumnCount()*labyrinth.getRowCount())
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
        if(labyrinth.isWallAt(cell))
            return false;
        return !visited.contains(cell);
    }
    
    private boolean goUp(){
        Cell newCell = new Cell(currentCell.row - 1, currentCell.column);
        if(isValidMove(newCell)){
            currentCell = newCell;
            visited.add(currentCell);
            solutionStack.add('U');
            System.out.println('U');
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
            System.out.println('D');
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
            System.out.println('L');
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
            System.out.println('R');
            return true;
        }
        return false;
    }
    private boolean goBack(){
        if(!solutionStack.empty()){
            switch(solutionStack.pop()){
                case 'D':
                    goUp(); break;
                case 'U':
                    goDown(); break;
                case 'L':
                    goRight(); break;
                case 'R':
                    goLeft(); break;
            }
            System.out.println('B');
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
