/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lab4.models.Game;

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
                gameController = GameController.create(new Game(9, 9, 10));
                break;
            case "Intermediaire":
                gameController.view.dispose();
                gameController = GameController.create(new Game(16, 16, 40));
                break;
            case "Expert":
                gameController.view.dispose();
                gameController = GameController.create(new Game(16, 30, 99));
                break;
            case "Custom":
                
                CustomGameController customGameController = new CustomGameController();
                break;
            default:
                break;
        }
    }
    
}
