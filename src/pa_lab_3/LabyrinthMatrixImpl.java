/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class LabyrinthMatrixImpl implements Labyrinth {
    
    private final List<List<Cell>> labyrinth;
    private Cell startCell;
    private Cell endCell;

    public LabyrinthMatrixImpl(int rows, int columns, int[][] labyrinth) {
        
        this.labyrinth = new ArrayList<>();
        for(int i = 0; i < rows; i ++){
            
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < columns; j++){
                
                Cell cell = new Cell(i, j, labyrinth[i][j]);
                
                switch(cell.type){
                    case -1:
                        if(startCell == null)
                            startCell = cell;
                        else
                            cell.type = 1;
                        break;
                    case 2:
                         if(endCell == null)
                            endCell = cell;
                        else
                            cell.type = 1;
                        break;
                    case 0:
                        break;
                    case 1:
                        break;
                    default:
                        cell.type = 1;
                }
                
                row.add(cell);
            }
            this.labyrinth.add(row);
        }
    }
   
    

    @Override
    public int getRowCount() {
        return labyrinth.size();
    }

    @Override
    public int getColumnCount() {
        return labyrinth.get(0).size();
    }

    @Override
    public boolean isFreeAt(Cell cell) {
        return cell.type == 0 || cell.type == -1 || cell.type == 2;
    }

    @Override
    public boolean isWallAt(Cell cell) {
        return cell.type == 1;
    }

    @Override
    public Cell getStartCell() {
        Cell cell = new Cell(this.startCell.row, this.startCell.column, this.startCell.type);
        return cell;
    }

    @Override
    public Cell getFinishCell() {
        Cell cell = new Cell(this.endCell.row, this.endCell.column, this.endCell.type);
        return cell;
    }
    
        
    @Override
    public String toString(){
        String string = "";
        for(List<Cell> row : labyrinth){
            for(Cell cell : row){
                string += cell + " ";
            }
            string += "\n";
        }
        return string;
    }
}
