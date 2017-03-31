/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab4.exceptions.NegativeNumberException;

/**
 *
 * @author fabien
 */
public class Cell extends Observable {

    private final Game game;
    private Position position;
    private char marking = 'u';
    private boolean mine;
    private int NumberOfAdjacentMines;
    private boolean unveil;
    private boolean selected;
    public ArrayList<Cell> neighbours;
    
    public Cell(Game game, Position position) {
      this.game = game;
      this.position = position;
      neighbours = new ArrayList();
    }
    
    /**
     * @return the unveil
     */
    public boolean isUnveil() {
        return unveil;
    }

    /**
     * @throws lab4.exceptions.NegativeNumberException
     */
    public void unveil() throws NegativeNumberException, IOException {
        this.setUnveil(true);
        game.decRemainingCells();
        setChanged();
        notifyObservers();
        if(this.mine) {
            game.lost();
        }
        if(game.hasWin()) {
            game.win();
        }
        if(NumberOfAdjacentMines == 0) {
           neighbours.forEach((neighbour) -> {
                if(!neighbour.isUnveil()) try {
                    neighbour.unveil();
                } catch (NegativeNumberException | IOException ex) {
                    Logger.getLogger(Cell.class.getName()).log(Level.SEVERE, null, ex);
                }
            });   
        }
    }
    
    public void mark() throws IOException {
        switch (marking) {
            case 'u':
                marking = 'f';
                game.decRemainingMines();
                break;
            case 'f':
                marking = '?';
                game.incRemainingMines();
                break;
            case '?':
                marking = 'u';
                break;
            default:
                break;
        }
        setChanged();
        notifyObservers();  
        if(game.hasWin()) {
            game.win();
        }
    }
    
    /*
    public char charToDisplay() {
        if(visible) {
            if(isMine()) {
                return 'x';
            }
            if(NumberOfAdjacentMines == 0) {
                return '.';
            } else {
                return (char)(NumberOfAdjacentMines + '0');
            }
        } else {
            if(marking == 'u') {
               return '#'; 
            } else {
               return marking; 
            }
            
        }
    }
    */
    
    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    /**
     * @return the NumberOfAdjacentMines
     */
    public int getNumberOfAdjacentMines() {
        return NumberOfAdjacentMines;
    }

    /**
     * @param NumberOfAdjacentMines the NumberOfAdjacentMines to set
     */
    public void setNumberOfAdjacentMines(int NumberOfAdjacentMines) {
        this.NumberOfAdjacentMines = NumberOfAdjacentMines;
    }
    
    /**
     * Incremente NumberOfAdjacentMines
     */
    public void incNumberOfAdjacentMines() {
        this.NumberOfAdjacentMines ++;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the marking
     */
    public char getMarking() {
        return marking;
    }

    /**
     * @param marking the marking to set
     */
    public void setMarking(char marking) {
        this.marking = marking;
    }

    /**
     * @return the mine
     */
    public boolean isMine() {
        return mine;
    }

    /**
     * @param mine the mine to set
     */
    public void setMine(boolean mine) {
        this.mine = mine;
    }
    
    public void addNeighbours(Cell neighbour) {
        this.neighbours.add(neighbour);
    }

    /**
     * @param unveil the unveil to set
     */
    public void setUnveil(boolean unveil) {
        this.unveil = unveil;
    }

}
