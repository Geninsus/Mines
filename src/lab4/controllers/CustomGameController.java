/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import lab4.views.GraphicalCustomGameView;

/**
 *
 * @author fabien
 */
public class CustomGameController implements Observable,ActionListener{
    GraphicalCustomGameView customGameView;
    JFrame customFrame;
    
    public CustomGameController() {
        this.customFrame = new JFrame("Custom Game");
        customFrame.setSize(400, 400);
        customFrame.setVisible(true);
        customFrame.setLayout(new BorderLayout(5, 5));
        this.customGameView = new GraphicalCustomGameView(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass() == JRadioButton.class){
            JRadioButton button = (JRadioButton)e.getSource();
            switch(button.getName()){
                case "beginner":
                    System.err.println("beginner");
                    customGameView.visibleCustomPanel(false);
                    break;
                case "intermediaire":
                    System.err.println("intermediaire");
                    customGameView.visibleCustomPanel(false);
                    break;
                case "expert":
                    System.err.println("expert");
                    customGameView.visibleCustomPanel(false);
                    break;
                case "custom":
                    System.err.println("custom");
                    customGameView.visibleCustomPanel(true);
                    break;
                case "buttonOk":
                    System.err.println("buttonOk");
                    this.customFrame.setVisible(false);
                    this.customFrame.setEnabled(false);
                default:
                    break;
            }
        }
    }
    
}
