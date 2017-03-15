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
import lab4.exceptions.NegativePourcentageException;
import lab4.exceptions.TooManyMinesException;

/**
 *
 * @author fabien
 */
public class Grid extends Observable implements Observer{

    private ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();
    private int width;
    private int height;
    private double pourcentageOfMines;
    private boolean lost;
    private boolean win;
    
    public Grid(int width, int height, double pourcentageOfMines) throws NegativeLengthException, NegativePourcentageException, TooManyMinesException {
        
        /* Vérification des paramètres */
        if(width < 0) {
            throw new NegativeLengthException(width);
        }
        
        if(height < 0) {
            throw new NegativeLengthException(width);
        }
        
        if(pourcentageOfMines < 0) {
            throw new NegativePourcentageException(width);
        }
        
        if(pourcentageOfMines > 85) {
            throw new TooManyMinesException(width);
        }
        
        this.width = width;
        this.height = height;
        this.pourcentageOfMines = pourcentageOfMines;
        
        /* Remplissage de la grille */
        for (int i = 0; i < height; i++) {
            this.grid.add(new ArrayList<Cell>());
            for (int j = 0; j < width; j++) {
                this.grid.get(i).add(new Cell(new Position(j, i)));
            }
        }
    }
    
    public void updateGrid() {
        setChanged();
        notifyObservers();
    }
    
    public void generateMines() {
        int numberOfMines = (int)((width+1)*(height+1)*(pourcentageOfMines/100));
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
    
   public void unveilNeighbors(Cell cell) {
        int mine_x = cell.getPosition().getX();
        int mine_y = cell.getPosition().getY();
        cell.unveil();
        if(cell.isMine()) {
            this.setLost(true);
        }
        if(cell.getNumberOfAdjacentMines() == 0) {
            if(mine_y > 0 && mine_x > 0 && !grid.get(mine_y-1).get(mine_x-1).isUnveil())              unveilNeighbors(grid.get(mine_y-1).get(mine_x-1));
            if(mine_y > 0 && !grid.get(mine_y-1).get(mine_x).isUnveil())                            unveilNeighbors(grid.get(mine_y-1).get(mine_x));
            if(mine_y > 0 && mine_x < width-1 && !grid.get(mine_y-1).get(mine_x+1).isUnveil())        unveilNeighbors(grid.get(mine_y-1).get(mine_x+1));
            if(mine_x < width-1 && !grid.get(mine_y).get(mine_x+1).isUnveil())                      unveilNeighbors(grid.get(mine_y).get(mine_x+1));
            if(mine_y < height-1 && mine_x < width-1 && !grid.get(mine_y+1).get(mine_x+1).isUnveil()) unveilNeighbors(grid.get(mine_y+1).get(mine_x+1));
            if(mine_y < height-1 && !grid.get(mine_y+1).get(mine_x).isUnveil())                     unveilNeighbors(grid.get(mine_y+1).get(mine_x));
            if(mine_y < height-1 && mine_x > 0 && !grid.get(mine_y+1).get(mine_x-1).isUnveil())       unveilNeighbors(grid.get(mine_y+1).get(mine_x-1));
            if(mine_x > 0 && !grid.get(mine_y).get(mine_x-1).isUnveil())                            unveilNeighbors(grid.get(mine_y).get(mine_x-1));   
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

}
