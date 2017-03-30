/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab4.Lab4;
import lab4.exceptions.NegativeLengthException;
import lab4.exceptions.NegativeNumberException;
import lab4.exceptions.TooManyMinesException;
import lab4.models.Game;
import lab4.models.Grid;
import lab4.models.Timer;
import lab4.views.GraphicalGameView;
import lab4.views.GraphicalMenuView;
import lab4.views.GraphicalStatusBarView;
import lab4.views.GraphicalTimerView;

/**
 *
 * @author fabien
 */
public class GameController {
    public GraphicalGameView view;
    public Game model;
    
    public static GameController create(Game game) {
        GameController gameController = new GameController(game);
        gameController.init();
        return gameController;
    }
    
    public GameController(Game game) {
        this.model = game;
        this.view = new GraphicalGameView("Démineur", 500, 500);

        MenuController menuControl = new MenuController(this);
        GraphicalMenuView menuBar = new GraphicalMenuView(menuControl);
        view.setJMenuBar(menuBar);
        GraphicalStatusBarView statusBar = new GraphicalStatusBarView(model);
        Timer timer = new Timer();
        model.timer = timer;
        GraphicalTimerView timerView = new GraphicalTimerView();
        timer.addObserver(timerView);
        
        view.add(timerView, BorderLayout.NORTH);
        timerView.setText("Timer: 0");
        view.add(statusBar, BorderLayout.SOUTH);
        model.addObserver(statusBar);
        
        /* Création du model Grid */
        Grid gridModel = null;
        try {
            gridModel = new Grid(model, model.getHeight(), model.getWidth(), model.getMinePercentage());
        } catch (NegativeLengthException | NegativeNumberException | TooManyMinesException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Création du controller Grid */
        GridController gridController = new GridController(this, gridModel);
    }
    
    public void init() {
        this.model.controller = this;
    }
}
