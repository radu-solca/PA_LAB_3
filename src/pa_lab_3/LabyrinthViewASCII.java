/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_lab_3;

/**
 *
 * @author Tea
 */
public class LabyrinthViewASCII implements LabyrinthView{
    private Labyrinth lab;
    
    @Override
    public void setLabyrinth(Labyrinth newLab) {
        lab=newLab;
    }

    @Override
    public Labyrinth getLabyrinth() {
        return lab;
    }

    @Override
    public void drawLabyrinth() {
        for (int i = 0; i < lab.getRowCount(); i++) {
            for(int j = 0; j < lab.getColumnCount(); j++){
                Cell cell=new Cell(i, j);
                if(lab.isFreeAt(cell)){
                    if(lab.isFinishCell(cell)){
                        System.out.print("F ");
                    }
                    else
                        if(lab.isStartCell(cell)){
                            System.out.print("S ");
                        }
                        else
                        {
                            System.out.print("0 ");
                        }
                }
                else
                    System.out.print("1 ");
                
            }
            System.out.println();
        }
        
    }
    
}
