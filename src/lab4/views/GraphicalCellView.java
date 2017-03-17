/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import lab4.controllers.CellController;
import lab4.models.Cell;

/**
 *
 * @author guillaume
 */
public class GraphicalCellView extends JButton implements Observer {
    
    public GraphicalCellView(GraphicalGridView grid) {
        super("");
        grid.frame.add(this);
    }
    
    public void addController(CellController controller) {
        this.addMouseListener(controller);
    }

    @Override
    public void update(Observable o, Object arg) {
        Cell model;
        if(o instanceof Cell) {
            model = (Cell) o;            
        } else {
            throw new IllegalArgumentException("Expect Cell object");
        }
        
        if(model.isUnveil()) {
            this.setEnabled(false);
            if(model.isMine()) {
                this.setText("X"); 
            } else if(model.getNumberOfAdjacentMines() > 0) {
               this.setText(Integer.toString(model.getNumberOfAdjacentMines())); 
            }
        } else {
            if(model.getMarking() == '?') {
                this.setText("?"); 
            } else if(model.getMarking() == 'f') {
                this.setText("f"); 
            } else if(model.getMarking() == 'u') {
                this.setText("");
            }
        }
    }

}
