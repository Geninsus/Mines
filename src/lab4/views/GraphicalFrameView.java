/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;
import javax.swing.JFrame;

/**
 *
 * @author guillaume
 */
public class GraphicalFrameView extends JFrame{
    
    public GraphicalFrameView(String name, int width, int height){
        super(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }
    
}
