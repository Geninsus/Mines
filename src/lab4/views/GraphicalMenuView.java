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

/**
 *
 * @author fabien
 */
public class GraphicalMenuView extends JMenuBar{
    
    public GraphicalMenuView() {
        super();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Descriptions");
        this.add(menu);
        JMenu submenu = new JMenu("New");
        submenu.setMnemonic(KeyEvent.VK_S);
        JMenuItem menuItem = new JMenuItem("Beginner");
        /* Implémentation avec des actions sur le click 
        JMenuItem menuItem = new JMenuItem(new AbstractAction("Beginner"){
            public void actionPerformed(ActionEvent e){
                // action to make
            }
        });
        */
        submenu.add(menuItem);
        menuItem = new JMenuItem("Intermediaire");
        
        submenu.add(menuItem);
        menuItem = new JMenuItem("Expert");
        
        submenu.add(menuItem);
        menuItem = new JMenuItem("Custom");
        
        submenu.add(menuItem);
        menu.add(submenu);
        menu.addSeparator();
        menuItem = new JMenuItem("Quit");
        menu.add(menuItem);
        
        
        
    }
    
    
    
}
