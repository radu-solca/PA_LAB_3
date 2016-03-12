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
public class PA_LAB_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] gigi = {{-1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 0, 0, 1, 1}, {1, 1, 2, 1, 1}};
        
        Labyrinth lab = new LabyrinthMatrixImpl(5, 5, gigi);
        Labyrinth lab2 = new LabyrinthListImpl(5, 5, gigi);
        
        System.out.println(lab);
        System.out.println(lab.getRowCount());
        System.out.println(lab.getColumnCount());
        
        Cell cell = new Cell(0,0);
        System.out.println(lab.isFreeAt(cell));
        cell = new Cell(1,0);
        System.out.println(lab.isFreeAt(cell));
        cell = new Cell(0,1);
        System.out.println(lab.isFreeAt(cell));
        cell = new Cell(1,1);
        System.out.println(lab.isWallAt(cell));
        
        
        System.out.println(lab2);
        System.out.println(lab2.getRowCount());
        System.out.println(lab2.getColumnCount());
        
        cell = new Cell(0,0);
        System.out.println(lab2.isFreeAt(cell));
        cell = new Cell(1,0);
        System.out.println(lab2.isFreeAt(cell));
        cell = new Cell(0,1);
        System.out.println(lab2.isFreeAt(cell));
        cell = new Cell(1,1);
        System.out.println(lab2.isWallAt(cell));
    }
    
}
