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
import lab4.models.Timer;

/**
 *
 * @author Guillaume
 */
public class GraphicalTimerView extends JLabel implements Observer{
    
    public GraphicalTimerView() {
        super();
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        Timer timer;
        if(o instanceof Timer) {
            timer = (Timer) o;            
        } else {
            throw new IllegalArgumentException("Expect Timer object");
        } 
        this.setText("Timer:" + timer.getCounter());
    }
    
}
