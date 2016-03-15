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
public abstract class LabyrinthObservableSolver implements LabyrinthSolver {
    
    private final List<LabyrinthObserver> observers;

    public LabyrinthObservableSolver() {
        observers = new ArrayList<>();
    }

    public void addObserver(LabyrinthObserver observer){
        observers.add(observer);
    }
    
    public void removeObserver(LabyrinthObserver observer){
        observers.remove(observer);
    }
    
    public void notifyObservers(){
        observers.stream().forEach((observer) -> {
            observer.update(this);
        });
    }
}
