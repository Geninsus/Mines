/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.util.ArrayList;
import javax.swing.JFrame;
import lab4.models.Cell;
import lab4.models.Grid;
import lab4.views.GraphicalGridView;

/**
 *
 * @author fabien
 */
public final class GridController {
    
    public GameController game;
    public final ArrayList<ArrayList<CellController>> cellsController = new ArrayList<>();
    public Grid model;
    private final GraphicalGridView view;
    
    public GridController(GameController frameController, Grid model) {
        this.game = frameController;
        this.model = model;
        this.view = new GraphicalGridView(game.view, model.getHeight(), model.getWidth());
        for (int y = 0; y < model.getHeight(); y++) {
            this.cellsController.add(new ArrayList<>());
            for (int x = 0; x < model.getWidth(); x++) {
                this.cellsController.get(y).add(new CellController(this,this.model.getGrid().get(y).get(x)));                
            }
        }
        updateNeighbours();
        game.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.view.setVisible(true);
    }

    /**
     * @return the view
     */
    public GraphicalGridView getView() {
        return view;
    }
    
    public void updateNeighbours() {
        for (int y = 0; y < model.getHeight(); y++) {
            for (int x = 0; x < model.getWidth(); x++) {
                if(x>0 && y > 0){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y-1).get(x-1));}
                if(y > 0){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y-1).get(x));}
                if(y>0 && x < model.getWidth()-1){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y-1).get(x+1));}
                if(x < model.getWidth()-1){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y).get(x+1));}
                if(y < model.getHeight()-1 && x < model.getWidth()-1){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y+1).get(x+1));}
                if(y < model.getHeight()-1){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y+1).get(x));}
                if(y < model.getHeight()-1 && x > 0){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y+1).get(x-1));}
                if(x>0){ model.getGrid().get(y).get(x).addNeighbours(model.getGrid().get(y).get(x-1));}
            }
        }
    }
}
    /**
     * Receive a new command from user input
     */
    /*
    public void onCommand(String command) {
        String[] commandArr = command.split(" ");
        if(commandArr.length == 0) this.view.unknownInput();
        switch(commandArr[0]) {
            case "d" :
               unveilingCell(commandArr);
               break; 

            case "m" :
               markingCell(commandArr);
               break;
               
            case "q" :
               System.exit(0);
               break; 
               
            default : 
               this.view.unknownInput();
               // Statements
         }
    }
    */
    
    /**
     * Unveiling Cell
     */
    /*
    public void unveilingCell(String[] commandArr) {
        */
        /* Vérification des paramètres */
    /*
        if (commandArr.length != 3) this.view.unknownInput();
        int x = Integer.parseInt(commandArr[1]);
        int y = Integer.parseInt(commandArr[2]);
        if(x < 0 || x > model.getWidth() - 1) {
            this.view.wrongParameters();
        }
        if(y < 0 || y > model.getHeight()- 1) {
            this.view.wrongParameters();
        }

        model.getGrid().get(y).get(x).setVisible(true);

        if(firstUnveiling) {
            firstUnveiling = false;
            model.generateMines();
        }
                
        model.unveilNeighbors(model.getGrid().get(y).get(x));

        model.updateGrid();
    }*/
    
    /**
     * Marking Cell
     * @param commandArr 
     */
    /*
    public void markingCell(String[] commandArr) {
        */
        /* Vérification des paramètres */
    /*
        if (commandArr.length != 4) this.view.unknownInput();
        int x = Integer.parseInt(commandArr[1]);
        int y = Integer.parseInt(commandArr[2]);
        if(x < 0 || x > model.getWidth() - 1) {
            this.view.wrongParameters();
        }
        if(y < 0 || y > model.getHeight()- 1) {
            this.view.wrongParameters();
        }
        
        if(commandArr[3].length() != 1) this.view.wrongParameters();
        char markChar = commandArr[3].charAt(0);
        if(markChar != 'x' && markChar != '?' && markChar != '#') this.view.wrongParameters();
        
        model.getGrid().get(y).get(x).setMarking(markChar);
        
        model.updateGrid();
    }
}
*/