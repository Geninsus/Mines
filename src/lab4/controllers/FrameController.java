/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import lab4.Lab4;
import lab4.exceptions.NegativeLengthException;
import lab4.exceptions.NegativePourcentageException;
import lab4.exceptions.TooManyMinesException;
import lab4.models.Grid;
import lab4.views.GraphicalFrameView;

/**
 *
 * @author fabien
 */
public class FrameController {
    public GraphicalFrameView view;
    public FrameController() {
        GraphicalFrameView Frameview = new GraphicalFrameView("Démineur", 300, 300);
        this.view = Frameview;
        Grid model = null;
        try {
            model = new Grid(12, 12, 10);
        } catch (NegativeLengthException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegativePourcentageException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TooManyMinesException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        GridController controller = new GridController(this, model);
        model.updateGrid();
    }
}
