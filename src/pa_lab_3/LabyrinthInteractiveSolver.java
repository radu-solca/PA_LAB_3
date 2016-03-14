/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
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
        this.labyrinth = labyrinth;
        this.currentCell = this.labyrinth.getStartCell();
    }

    @Override
    public List<Character> solve() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            
            System.out.print("> ");
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(LabyrinthInteractiveSolver.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!input.equals("EXIT")){
                this.nextCellToExplore(input);
                if (labyrinth.isFinishCell(currentCell)){ 
                    break;
                }
            }
            else{
                break;
            }
        }
        return labyrinth.isStartCell(currentCell) ? solutionStack : null;
    }
    
    private boolean isValidMove(Cell cell){
        if(cell.row < 0 || cell.row >= labyrinth.getRowCount())
            return false;
        if(cell.column < 0 || cell.column >= labyrinth.getColumnCount())
            return false;
        return !labyrinth.isWallAt(cell);
    }
    
    @Override
    public List<Character> nextCellToExplore(String command){
        Cell newCell;
        switch(command){
            case "UP":
                newCell = new Cell(currentCell.row - 1, currentCell.column);
                if(isValidMove(newCell)){
                    currentCell = newCell;
                    solutionStack.add('U');
                }
                else{
                    System.out.println("Invalid move");
                }
                break;
            case "DOWN":
                newCell = new Cell(currentCell.row + 1, currentCell.column);
                if(isValidMove(newCell)){
                    currentCell = newCell;
                    solutionStack.add('D');
                }
                else{
                    System.out.println("Invalid move");
                }
                break;
            case "LEFT":
                newCell = new Cell(currentCell.row, currentCell.column - 1);
                if(isValidMove(newCell)){
                    currentCell = newCell;
                    solutionStack.add('L');
                }
                else{
                    System.out.println("Invalid move");
                }
                break;
            case "RIGHT":
                newCell = new Cell(currentCell.row, currentCell.column + 1);
                if(isValidMove(newCell)){
                    currentCell = newCell;
                    solutionStack.add('R');
                }
                else{
                    System.out.println("Invalid move");
                }
                break;
            default:
                System.out.println("Unknown command: try UP, DOWN, LEFT, RIGHT, or EXIT to quit.");
        }
        
        this.notifyObservers();
        return labyrinth.isStartCell(currentCell) ? solutionStack : null;
    }
}
