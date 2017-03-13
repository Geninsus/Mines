/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.util.ArrayList;
import javax.swing.JFrame;
import lab4.models.Grid;
import lab4.views.GraphicalGridView;

/**
 *
 * @author fabien
 */
public class GridController {
    
    public FrameController frame;
    private ArrayList<ArrayList<CellController>> cellsController = new ArrayList<ArrayList<CellController>>();
    public Grid model;
    private GraphicalGridView view;
    private boolean firstUnveiling = true;
    
    public GridController(FrameController frameController, Grid model) {
        this.frame = frameController;
        this.model = model;
        this.view = new GraphicalGridView(frame.view, model.getWidth(), model.getHeight());
        for (int i = 0; i < model.getHeight(); i++) {
            this.cellsController.add(new ArrayList<CellController>());
            for (int j = 0; j < model.getWidth(); j++) {
                this.cellsController.get(i).add(new CellController(this,this.model.getGrid().get(j).get(i)));
                
            }
        }
        System.out.println("lab4.controllers.GridController.<init>()");
        frame.view.setSize(300, 400);
         frame.view.setSize(300,400);
    frame.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.view.setVisible(true);
    }

    /**
     * @return the view
     */
    public GraphicalGridView getView() {
        return view;
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