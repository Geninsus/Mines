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
    
    static public GraphicalCellView create(GraphicalGridView grid, Cell model) {
        GraphicalCellView graphicalCellView = new GraphicalCellView(grid, model);
        graphicalCellView.init(grid, model);
        return graphicalCellView;
    }
    
    public GraphicalCellView(GraphicalGridView grid, Cell model) {
        super("");
    }
    
    private void init(GraphicalGridView grid, Cell model) {
        grid.frame.centerPanel.add(this);
        this.setFocusable(false);
    }
    
    public void addController(CellController controller) {
        this.addMouseListener(controller);
    }

    @Override
    public void update(Observable o, Object arg) {
        Cell cell;
        if(o instanceof Cell) {
            cell = (Cell) o;            
        } else {
            throw new IllegalArgumentException("Expect Cell object");
        }
        
        if(cell.isUnveil()) {
            this.setEnabled(false);
            if(cell.isMine()) {
                this.setText("X"); 
            } else if(cell.getNumberOfAdjacentMines() > 0) {
               this.setText(Integer.toString(cell.getNumberOfAdjacentMines())); 
            } else {
                this.setText(""); 
            }
        } else {
            switch (cell.getMarking()) {
                case '?':
                    this.setText("?");
                    break;
                case 'f':
                    this.setText("f");
                    break;
                case 'u':
                    this.setText("");
                    break;
                default:
                    break;
            }
        }
    }

}
