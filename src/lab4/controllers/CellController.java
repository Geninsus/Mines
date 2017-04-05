/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab4.exceptions.NegativeNumberException;
import lab4.models.Cell;
import lab4.views.GraphicalCellView;

/**
 *
 * @author fabien
 */
public class CellController extends MouseAdapter {
    
    private final GridController gridController;
    public final Cell model;
    private final GraphicalCellView view;
    
    public CellController(GridController gridController,Cell model){
        this.gridController = gridController;
        this.model = model;
        this.view = GraphicalCellView.create(gridController.getView(), model);
        view.addController(this);
        model.addObserver(view);  
    }

    @Override
    public void mouseClicked(MouseEvent e){
        /* Clique gauche */
        if(model.isUnveil() == false) {
           if(e.getButton() == 1) {
                model.setUnveil(true);
                gridController.game.model.incRound();
                if(gridController.game.model.getRound() == 1) {
                    gridController.model.generateMines();
                }
                try {
                    model.unveil();

                    /* Clique droit */
                } catch (NegativeNumberException | IOException ex) {
                    Logger.getLogger(CellController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(e.getButton() == 3) {
                try {
                    model.mark();
                } catch (IOException ex) {
                    Logger.getLogger(CellController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
    }

    /**
     * @return the view
     */
    public GraphicalCellView getView() {
        return view;
    }
}
