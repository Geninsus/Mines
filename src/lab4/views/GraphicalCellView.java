/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.PopupMenu;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import lab4.controllers.CellController;

/**
 *
 * @author guillaume
 */
public class GraphicalCellView extends JButton implements Observer {
    
    GraphicalGridView grid;
    
    public GraphicalCellView(String label, GraphicalGridView grid) {
        super(label);
        this.grid = grid;
        grid.frame.add(this);
        System.out.println("lab4.views.GraphicalCellView.<init>()");
    }
    
    public void addController(CellController controller) {
        this.addActionListener(controller);
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //private PopupMenu JButton(String string) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      //  return new Pop
   // }
}
