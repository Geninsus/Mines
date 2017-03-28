/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JFrame;
import lab4.views.GraphicalCustomGameView;

/**
 *
 * @author fabien
 */
public class CustomGameController implements Observable{
    GraphicalCustomGameView customGameView;
    
    public CustomGameController() {
        JFrame customFrame = new JFrame("Custom Game");
        customFrame.setSize(400, 400);
        customFrame.setVisible(true);
        customFrame.setLayout(new BorderLayout(5, 5));
        this.customGameView = new GraphicalCustomGameView();
        customFrame.add(this.customGameView, BorderLayout.CENTER);
        
    }
    @Override
    public void addListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
