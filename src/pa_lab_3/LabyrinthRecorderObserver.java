/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;


class solutionLengthComparator implements Comparator<Stack<Character>>{

    @Override
    public int compare(Stack<Character> o1, Stack<Character> o2) {
        return o1.size() - o2.size();
    }
    
}


public class LabyrinthRecorderObserver implements LabyrinthObserver {

    private final SortedSet solutions;

    public LabyrinthRecorderObserver() {
        Comparator comparator = new solutionLengthComparator();
        solutions = new TreeSet(comparator);
    }

    @Override
    public void update(LabyrinthSolver subject) {
        if(subject.foundSolution()){
            solutions.add(subject.getCurrentPath());
            System.out.println("(recorder)A solution has been found");
        }
    }
    
    @Override
    public String toString(){
        return solutions.toString();
    }
}
