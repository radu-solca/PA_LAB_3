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
 * @author NASA
 */
public class LabyrinthListImpl implements Labyrinth {

    
    private final List<Cell> filledCells;
    private Cell startCell;
    private Cell endCell;
    private int rows;
    private int columns;

    public LabyrinthListImpl(int rows, int columns, int[][] labyrinth) {
        
        this.rows = rows;
        this.columns = columns;
        
        this.filledCells = new ArrayList<>();
        for(int i = 0; i < this.rows; i ++){
            for(int j = 0; j < this.columns; j++){
                switch (labyrinth[i][j]){
                    case -1:
                        if(startCell == null){
                            startCell = new Cell(i, j, -1);
                        }
                        else{
                            Cell cell = new Cell(i,j,1);
                            filledCells.add(cell);
                        }
                        break;
                    case 2:
                        if(endCell == null){
                            endCell = new Cell(i, j, 2);
                        }
                        else{
                            Cell cell = new Cell(i,j,1);
                            filledCells.add(cell);
                        }
                        break;
                    case 0:
                        break;
                    default:
                        Cell cell = new Cell(i,j,1);
                        filledCells.add(cell);
                }
            }
        }
    }
    
    
    
    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public boolean isFreeAt(Cell cell) {
        return !filledCells.contains(cell);
    }

    @Override
    public boolean isWallAt(Cell cell) {
        return filledCells.contains(cell);
    }
    
    @Override
    public boolean isStartCell(Cell cell) {
       return startCell.equals(cell);
    }

    @Override
    public boolean isFinishCell(Cell cell) {
        return endCell.equals(cell);
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
        for(int i = 0; i < this.rows; i ++){
            for(int j = 0; j < this.columns; j++){
                Cell cell = new Cell(i, j);
                if(this.isWallAt(cell)){
                    string += "1 ";
                }
                else
                if(cell.equals(startCell)){
                    string += "-1 ";
                }
                else
                if(cell.equals(endCell)){
                    string += "2 ";
                }
                else{
                    string += "0 ";
                }
            }
            string += "\n";
        }
        return string;
    }


}
