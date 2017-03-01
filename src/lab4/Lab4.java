/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.logging.Level;
import java.util.logging.Logger;
import lab4.controllers.GridController;
import lab4.exceptions.NegativeLengthException;
import lab4.exceptions.NegativePourcentageException;
import lab4.exceptions.TooManyMinesException;
import lab4.models.Grid;
import lab4.views.GridView;

/**
 *
 * @author fabien
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        GridView view = new GridView(model);
        GridController controller = new GridController(model, view);
        model.updateGrid();
    }
    
}
