/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import lab4.controllers.GameController;
import lab4.models.Game;

/**
 *
 * @author fabien
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameController gameController = GameController.create(new Game(9, 9, 10));
    }
    
}
