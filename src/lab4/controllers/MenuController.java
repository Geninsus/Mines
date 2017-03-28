/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import lab4.models.Game;
import lab4.views.GraphicalCustomGameView;

/**
 *
 * @author guillaume
 */
public class MenuController implements ActionListener{
    
    private GameController gameController;
    
    public MenuController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Quit":
                System.exit(0);
                break;
            case "Beginner":
                gameController.view.dispose();
                gameController = new GameController(new Game(9, 9, 10));
                break;
            case "Intermediaire":
                gameController.view.dispose();
                gameController = new GameController(new Game(16, 16, 40));
                break;
            case "Expert":
                gameController.view.dispose();
                gameController = new GameController(new Game(16, 30, 99));
                break;
            case "Custom":
                JFrame customFrame = new JFrame("Custom Game");
                customFrame.setSize(300, 200);
                customFrame.setVisible(true);
                customFrame.setLayout(new BorderLayout(5, 5));
                customFrame.add(new GraphicalCustomGameView(), BorderLayout.CENTER);
                break;
            default:
                break;
        }
    }
    
}
