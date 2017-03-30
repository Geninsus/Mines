/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import lab4.exceptions.NegativeLengthException;
import lab4.exceptions.NegativeNumberException;
import lab4.exceptions.TooManyMinesException;

/**
 *
 * @author fabien
 */
public class Grid extends Observable implements Observer{

    private final ArrayList<ArrayList<Cell>> grid = new ArrayList<>();
    private Game game;
    private int width;
    private int height;
    private int numberOfMines;
    private boolean lost;
    private boolean win;
    
    public Grid(Game game, int height, int width, int numberOfMines) throws NegativeLengthException, NegativeNumberException, TooManyMinesException {
        
        /* Vérification des paramètres */
        if(width < 0) {
            throw new NegativeLengthException(width);
        }
        
        if(height < 0) {
            throw new NegativeLengthException(width);
        }
        
        if(numberOfMines < 0) {
            throw new NegativeNumberException(width);
        }
        
        if(numberOfMines > width * height) {
            throw new TooManyMinesException(width);
        }
        
        this.game = game;
        
        this.width = width;
        this.height = height;
        this.numberOfMines = numberOfMines;
        game.setRemainingMines(numberOfMines);
        
        /* Remplissage de la grille */
        for (int y = 0; y < height; y++) {
            this.grid.add(new ArrayList<>());
            for (int x = 0; x < width; x++) {
                this.grid.get(y).add(new Cell(game, new Position(y, x)));
            }
        }
    }
        
    public void generateMines() {
        int mine_x, mine_y;
        for (int i = 0; i < numberOfMines; i++) {
            do {                
                mine_x = (int)(Math.random() * (width));
                mine_y = (int)(Math.random() * (height));    
            } while (grid.get(mine_y).get(mine_x).isUnveil()|| grid.get(mine_y).get(mine_x).isMine());
            grid.get(mine_y).get(mine_x).setMine(true);
            if(mine_y > 0 && mine_x > 0)              grid.get(mine_y-1).get(mine_x-1).incNumberOfAdjacentMines();
            if(mine_y > 0)                            grid.get(mine_y-1).get(mine_x).incNumberOfAdjacentMines();
            if(mine_y > 0 && mine_x < width-1)        grid.get(mine_y-1).get(mine_x+1).incNumberOfAdjacentMines();
            if(mine_x < width-1)                      grid.get(mine_y).get(mine_x+1).incNumberOfAdjacentMines();
            if(mine_y < height-1 && mine_x < width-1) grid.get(mine_y+1).get(mine_x+1).incNumberOfAdjacentMines();
            if(mine_y < height-1)                     grid.get(mine_y+1).get(mine_x).incNumberOfAdjacentMines();
            if(mine_y < height-1 && mine_x > 0)       grid.get(mine_y+1).get(mine_x-1).incNumberOfAdjacentMines();
            if(mine_x > 0)                            grid.get(mine_y).get(mine_x-1).incNumberOfAdjacentMines();
        } 
    }
    
    /**
     * @return the grid
     */
    public ArrayList<ArrayList<Cell>> getGrid() {
        return grid;
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
     * @return the lost
     */
    public boolean isLost() {
        return lost;
    }

    /**
     * @param lost the lost to set
     */
    public void setLost(boolean lost) {
        this.lost = lost;
    }

    /**
     * @return the win
     */
    public boolean isWin() {
        return win;
    }

    /**
     * @param win the win to set
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the numberOfMines
     */
    public int getNumberOfMines() {
        return numberOfMines;
    }

}
