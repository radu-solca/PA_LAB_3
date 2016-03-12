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
public interface Labyrinth {
    
    int getRowCount();
    int getColumnCount();
    boolean isFreeAt(Cell cell);
    boolean isWallAt(Cell cell);
    Cell getStartCell();
    Cell getFinishCell();
    
}
