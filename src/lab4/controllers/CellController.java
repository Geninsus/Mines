/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lab4.models.Cell;
import lab4.views.GraphicalCellView;

/**
 *
 * @author fabien
 */
public class CellController implements ActionListener {
    
    private GridController gridController;
    private Cell model;
    private GraphicalCellView view;
    
    public CellController(GridController gridController,Cell model){
        this.gridController = gridController;
        this.model = model;
        this.view = new GraphicalCellView("", gridController.getView());
        view.addController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
