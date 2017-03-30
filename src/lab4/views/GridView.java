/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import lab4.models.Cell;
import lab4.models.Grid;

/**
 *
 * @author fabien
 */
public class GridView implements Observer{
    
    private final Grid model;
    
    public GridView(Grid model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        /* Afficahge de la grille */
        for(ArrayList<Cell> row : this.model.getGrid()) {
            for (Cell cell : row) {
                //System.out.print(cell.charToDisplay() + " ");
            }
            System.out.println();
        }
        
        if(this.model.isLost()) {
            System.out.println("PERDU");
            System.exit(0);
        }

        /* Entrée utilisateur */
        userInput();
    }
    
    /**
     * User input
     */
    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        //this.controller.onCommand(command);
    }
    
    /**
     * Unknown user input
     */
    public void unknownInput() {
        System.out.println("Commande inconnue, merci de réessayer:");
        userInput();
    }
    
     /**
     * Wrong parameters
     */
    public void wrongParameters() {
        System.out.println("Paramètre invalide, merci de réessayer:");
        userInput();
    }
}
