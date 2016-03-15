/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NASA
 */
public class LabyrinthInteractiveSolver extends LabyrinthObservableSolver{

    private Labyrinth labyrinth;
    private final Stack<Character> solutionStack;
    private Cell currentCell;

    public LabyrinthInteractiveSolver() {
        solutionStack = new Stack<>();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public LabyrinthInteractiveSolver(Labyrinth labyrinth) {
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
            this.nextCellToExplore();
            if (labyrinth.isFinishCell(currentCell)){ 
                break;
            }
        }
    }
    
    private boolean isValidMove(Cell cell){
        if(cell.row < 0 || cell.row >= labyrinth.getRowCount())
            return false;
        if(cell.column < 0 || cell.column >= labyrinth.getColumnCount())
            return false;
        return !labyrinth.isWallAt(cell);
    }
    
    private boolean goUp(){
        Cell newCell = new Cell(currentCell.row - 1, currentCell.column);
        if(isValidMove(newCell)){
            currentCell = newCell;
            solutionStack.add('U');
            return true;
        }
        System.out.println("Invalid move");
        return false;
    }
    private boolean goDown(){
        Cell newCell = new Cell(currentCell.row + 1, currentCell.column);
        if(isValidMove(newCell)){
            currentCell = newCell;
            solutionStack.add('D');
            return true;
        }
        System.out.println("Invalid move");
        return false;
    }
    private boolean goLeft(){
        Cell newCell = new Cell(currentCell.row, currentCell.column - 1);
        if(isValidMove(newCell)){
            currentCell = newCell;
            solutionStack.add('L');
            return true;
        }
        System.out.println("Invalid move");
        return false;
    }
    private boolean goRight(){
        Cell newCell = new Cell(currentCell.row, currentCell.column + 1);
        if(isValidMove(newCell)){
            currentCell = newCell;
            solutionStack.add('R');
            return true;
        }
        System.out.println("Invalid move");
        return false;
    }
    
    @Override
    public void nextCellToExplore(){
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("> ");
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(LabyrinthInteractiveSolver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch(input){
            case "U":
                goUp();
                break;
            case "D":
                goDown();
                break;
            case "L":
                goLeft();
                break;
            case "R":
                goRight();
                break;
            default:
                System.out.println("Unknown command: try D U L R.");
        }
        
        this.notifyObservers();
    }
}
