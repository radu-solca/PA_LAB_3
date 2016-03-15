package pa_lab_3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NASA
 */
public class LabyrinthPrinterObserver implements LabyrinthObserver{

    
    @Override
    public void update(LabyrinthSolver subject) {
        System.out.println("(printer)"+subject.getCurrentPath());
    }
    
}
