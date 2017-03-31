/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import lab4.controllers.GameController;
import lab4.exceptions.NegativeNumberException;

/**
 *
 * @author fabien
 */
public class Game extends Observable implements Observer{
    private int remainingMines;
    private int remainingCells;
    private int round;
    private final int width;
    private final int height;
    private final int numberOfMine;
    public Timer timer;
    public GameController controller;
    public Difficulty difficulty = Difficulty.CUSTOM;
    
    public Game(int height, int width, int numberOfMine) {
        this.width = width;
        this.height = height;
        this.numberOfMine = numberOfMine;
        remainingCells = width * height;
    }
    
    public void win() throws IOException {
        timer.stop();
        Score score = new Score(difficulty, timer.getCounter());
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("scrore.ser")); objectOutputStream.writeObject(score);
        } catch(IOException ioException){
            throw new IOException(ioException);
        }
        
        JOptionPane.showMessageDialog( controller.view, "GAGNÉ :) Tu as mis " + timer.getCounter() +  " secondes!", "Démineur", JOptionPane.PLAIN_MESSAGE);
        controller.view.dispose();
        controller = GameController.create(new Game(9, 9, 10));
    }
    
    public void lost() {
        timer.stop();
        JOptionPane.showMessageDialog( controller.view, "PERDU :'(", "Démineur", JOptionPane.PLAIN_MESSAGE);
        controller.view.dispose();
        controller = GameController.create(new Game(9, 9, 10));
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
    
    public boolean hasWin() {
        if(remainingMines == 0 && remainingCells == getNumberOfMine()) {
            return true;
        } else {
            return false;
        }
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
     */
    public void incRound() {
        this.round ++;
        if(round == 1) {
            timer.start();
        }
    }
    
    public void decRemainingCells() throws NegativeNumberException {
        this.remainingCells --;
        if(this.remainingCells < 0) {
            throw new NegativeNumberException((double)this.remainingCells);
        }
    }

    public Game() {
        this.width = 0;
        this.height = 0;
        this.numberOfMine = 0;
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
    public int getNumberOfMine() {
        return numberOfMine;
    }

    /**
     * @return the remainingCells
     */
    public int getRemainingCells() {
        return remainingCells;
    }

    /**
     * @param remainingCells the remainingCells to set
     */
    public void setRemainingCells(int remainingCells) {
        this.remainingCells = remainingCells;
    }
}
