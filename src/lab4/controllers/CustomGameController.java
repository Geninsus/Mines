/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import lab4.models.Game;
import lab4.views.GraphicalCustomGameView;

/**
 *
 * @author fabien
 */
public class CustomGameController implements Observable,ActionListener{
    
    private GraphicalCustomGameView customGameView;
    private JFrame customFrame;
    public GameController gameController;
    
    private int row,column,mines;
    
    public CustomGameController(GameController gameController) {
        this.gameController = gameController;
        this.customFrame = new JFrame("Custom Game");
        this.customFrame.setSize(400, 400);
        this.customFrame.setVisible(true);
        this.customFrame.setLayout(new BorderLayout(5, 5));
        this.customGameView = new GraphicalCustomGameView(this);
        this.customFrame.add(this.customGameView, BorderLayout.CENTER);
        
    }
    
    private void createCustomGame() {
        if(this.customGameView.getCustomRadio().isSelected()){
            this.column = customGameView.getJinputColumn();
            this.row = customGameView.getJinputRow();
            this.mines = customGameView.getJinputMines();
        }
         this.gameController = GameController.create(new Game(this.row, this.column, this.mines));
    }
    @Override
    public void addListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass() == JRadioButton.class){
            JRadioButton button = (JRadioButton)e.getSource();
            switch(button.getName()){
                case "beginner":
                    System.err.println("beginner");
                    customGameView.visibleCustomPanel(false);
                    this.row = 9;
                    this.column = 9;
                    this.mines = 10;
                    break;
                case "intermediaire":
                    System.err.println("intermediaire");
                    customGameView.visibleCustomPanel(false);
                    this.row = 16;
                    this.column = 16;
                    this.mines = 40;
                    break;
                case "expert":
                    System.err.println("expert");
                    customGameView.visibleCustomPanel(false);
                    this.row = 16;
                    this.column = 30;
                    this.mines = 99;
                    break;
                case "custom":
                    System.err.println("custom");
                    customGameView.visibleCustomPanel(true);
                    break;
                default:
                    break;
            }
        }
        if(e.getSource().getClass() == JButton.class){
            JButton buttonOk = (JButton)e.getSource();
            if(buttonOk.getName()  == "buttonOk" ){
                System.err.println("buttonOk");
                this.gameController.view.dispose();
                this.customFrame.dispose();
                this.createCustomGame();
            }

        }
        if(e.getSource().getClass() == JFormattedTextField.class){
            JFormattedTextField textField = (JFormattedTextField)e.getSource();
            switch(textField.getName()){
                case "jinputMines":
                    this.customGameView.getSliderMines().setValue(this.customGameView.getJinputMines());
                    System.err.println("jinputMines");
                    break;
                case "jinputRow":
                    this.customGameView.getJinputColumn();
                    this.customGameView.getSliderRows().setValue(15);
                    System.err.println("jinputRow");
                    break;
                case "jinputColumn":
                    this.customGameView.getSliderColumns().setValue(this.customGameView.getJinputColumn());
                    System.err.println("jinputColumn");
                    break;
                default:
                    break;
            }
        }
    }
    
}
