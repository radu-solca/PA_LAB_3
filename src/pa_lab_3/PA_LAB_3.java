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
    public static void main(String[] args){
        
        int[][] gigi = {{-1, 1, 1, 0, 1}, 
                        {0, 0, 0, 0, 1}, 
                        {0, 1, 1, 0, 0}, 
                        {1, 0, 0, 0, 1}, 
                        {1, 1, 2, 1, 1}};
        
        Labyrinth lab = new LabyrinthMatrixImpl(5, 5, gigi);

        LabyrinthSolver solver = new LabyrinthAutomatedSolver(lab);
        LabyrinthObserver observer = new LabyrinthPrinterObserver();
        LabyrinthView view = new LabyrinthViewBlocks();
        
        view.setLabyrinth(lab);
        view.drawLabyrinth();
        ((LabyrinthObservableSolver)solver).addObserver(observer);
        
        solver.solve();
        //System.out.println(lab.isWallAt(new Cell(1,1)));

    }
    
}
