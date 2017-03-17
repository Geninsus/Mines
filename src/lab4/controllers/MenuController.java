/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author guillaume
 */
public class MenuController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Quit":
                System.exit(0);
                break;
            case "Beginner":
                break;
            case "Intermediaire":
                break;
            case "Expert":
                break;
            case "Custom":
                break;
            default:
                break;
        }
    }
    
}
