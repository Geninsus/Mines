/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lab4.models.Game;

/**
 *
 * @author fabien
 */
final public class GraphicalStatusBarView extends JLabel implements Observer{
    public GraphicalStatusBarView(Game game) {
        super();
        game.addObserver(this);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        Game game;
        if(o instanceof Game) {
            game = (Game) o;            
        } else {
            throw new IllegalArgumentException("Expect Game object");
        } 
        this.setText("remaining mines:" + game.getRemainingMines());
    }
}
