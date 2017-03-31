/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import lab4.controllers.MenuController;

/**
 *
 * @author fabien
 */
public class GraphicalMenuView extends JMenuBar{
    
    public GraphicalMenuView(MenuController menuController) {
        super();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        this.add(menu);
   
        JMenu submenu = new JMenu("New");
        submenu.setMnemonic(KeyEvent.VK_N);
        
        JMenuItem menuItem = new JMenuItem("Beginner");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        menuItem.addActionListener(menuController);
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Intermediaire");
        menuItem.setMnemonic(KeyEvent.VK_I);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        menuItem.addActionListener(menuController);
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Expert");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menuItem.addActionListener(menuController);  
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Custom");
        menuItem.setMnemonic(KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        menuItem.addActionListener(menuController);
        submenu.add(menuItem);
        
        menu.add(submenu);
        
        JMenuItem score = new JMenuItem("Score");
        score.setMnemonic(KeyEvent.VK_S);
        score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        score.addActionListener(menuController);
        menu.add(score);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        menuItem.addActionListener(menuController);
        
        menu.add(menuItem);
        
        
        
    }
    
    
    
}
