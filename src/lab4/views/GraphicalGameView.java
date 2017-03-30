/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author guillaume
 */
final public class GraphicalGameView extends JFrame{
    
    public JPanel centerPanel;
    
    public GraphicalGameView(String name, int width, int height){
        super(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
        this.setLayout(new BorderLayout(5, 5));
        this.centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
    }
    
    public void addMenu(JMenuBar menuBar){
        this.setJMenuBar(menuBar);
    }
    
}
