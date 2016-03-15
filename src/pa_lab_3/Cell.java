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
    
    public Cell(int row, int column) {
        this(row, column, 0);
    }
    
    @Override
    public String toString(){
        //return Integer.toString(row) + ' ' + Integer.toString(column) + ' ' + Integer.toString(type);
        return Integer.toString(row) + ' ' + Integer.toString(column);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        else if (!(obj instanceof Cell)) return false;
        else return ((this.row == ((Cell)obj).row)&&(this.column == ((Cell)obj).column));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.row;
        hash = 97 * hash + this.column;
        return hash;
    }
}
