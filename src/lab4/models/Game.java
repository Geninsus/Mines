/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import lab4.controllers.GameController;

/**
 *
 * @author fabien
 */
public class Game extends Observable implements Observer{
    private int remainingMines;
    private int round;
    private int width;
    private int height;
    private int numberOfMine;
    public Timer timer;
    public GameController controller;
    
    public Game(int height, int width, int numberOfMine) {
        this.width = width;
        this.height = height;
        this.numberOfMine = numberOfMine;
    }
    
    public void win() {
        
    }
    
    public void lost() {
        JOptionPane d = new JOptionPane();
        d.showMessageDialog( controller.view, "PERDU :'(", "Démineur", JOptionPane.PLAIN_MESSAGE);
        controller.view.dispose();
        controller = new GameController(new Game(9, 9, 10));
    }

    /**
     * @return the remainingMines
     */
    public int getRemainingMines() {
        return remainingMines;
    }

    /**
     * @param remainingMines the remainingMines to set
     */
    public void setRemainingMines(int remainingMines) {
        this.remainingMines = remainingMines;
        setChanged();
        notifyObservers();
    }
    
    public void incRemainingMines() {
        this.remainingMines ++;
        setChanged();
        notifyObservers();
    }
    
    public void decRemainingMines() {
        this.remainingMines --;
        setChanged();
        notifyObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        Grid grid;
        if(o instanceof Grid) {
            grid = (Grid) o;            
        } else {
            throw new IllegalArgumentException("Expect Grid object");
        }
        
        remainingMines = grid.getNumberOfMines();
    }
    
    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void incRound() {
        this.round ++;
        if(round == 1) {
            timer.start();
        }
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the minePercentage
     */
    public int getMinePercentage() {
        return numberOfMine;
    }
}
