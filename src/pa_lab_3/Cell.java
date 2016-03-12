/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

/**
 *
 * @author Radu
 */
public class Cell {
    public int row;
    public int column;
    public int type; //-1 -> start; 2 -> end;

    public Cell(int row, int column, int type) {
        this.row = row;
        this.column = column;
        this.type = type;
    }
    
    @Override
    public String toString(){
        //return Integer.toString(row) + ' ' + Integer.toString(column) + ' ' + Integer.toString(type);
        return Integer.toString(type);
    }
}
