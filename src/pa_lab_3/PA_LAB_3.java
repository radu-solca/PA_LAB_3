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
        
        int[][] input = {{-1, 1, 1, 0, 1}, 
                        {0, 0, 0, 0, 1}, 
                        {1, 0, 1, 0, 0}, 
                        {1, 0, 0, 0, 1}, 
                        {1, 1, 2, 1, 1}};
        
        Labyrinth labyrinth = new LabyrinthMatrixImpl(5, 5, input);

        LabyrinthSolver solver1 = new LabyrinthAutomatedSolver(labyrinth);
        LabyrinthSolver solver2 = new LabyrinthInteractiveSolver(labyrinth);
        
        LabyrinthObserver observer1 = new LabyrinthPrinterObserver();
        LabyrinthObserver observer2 = new LabyrinthRecorderObserver();
        
        LabyrinthView view = new LabyrinthViewBlocks();
        
        view.setLabyrinth(labyrinth);
        view.drawLabyrinth();
        
        ((LabyrinthObservableSolver)solver1).addObserver(observer1);
        ((LabyrinthObservableSolver)solver1).addObserver(observer2);
        
        ((LabyrinthObservableSolver)solver2).addObserver(observer1);
        ((LabyrinthObservableSolver)solver2).addObserver(observer2);
        
        solver1.solve();
        
        //other solution is [S, D, R, R, R, D, D, L, D];
        solver2.solve();
        
        System.out.println(observer2);

    }
    
}
