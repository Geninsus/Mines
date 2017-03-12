/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.GridLayout;

/**
 *
 * @author guillaume
 */
public class GraphicalGridView extends GridLayout{
    public GraphicalFrameView frame;
    private int row;
    private int column;
    
    public GraphicalGridView(GraphicalFrameView frame, int row, int column) {
        super(row,column,0,0);
        this.frame = frame;
        this.row = row;
        this.column = column;
        frame.setLayout(this);
        System.out.println("lab4.views.GraphicalGridView.<init>()");
    }
    
}
