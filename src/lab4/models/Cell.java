/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author fabien
 */
public class Cell extends Observable {

    private Position position;
    private char marking = 'u';
    private boolean mine;
    private int NumberOfAdjacentMines;
    private boolean unveil;
    private boolean selected;
    private ArrayList<Cell> neighbours;
    
    public Cell(Position position) {
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
     * @param unveil the unveil to set
     */
    public void unveil() {
        this.setUnveil(true);
         setChanged();
         notifyObservers();
         if(NumberOfAdjacentMines == 0) {
           neighbours.forEach((neighbour) -> {
             if(!neighbour.isUnveil()) neighbour.unveil();
         });   
         }
    }
    
    public void mark() {
        if(marking == 'u') {
            marking = 'f';
        } else if(marking == 'f') {
            marking = '?';
        } else if(marking == '?') {
            marking = 'u';
        }
        setChanged();
        notifyObservers();  
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
