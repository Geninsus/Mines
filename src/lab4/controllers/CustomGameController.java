/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import lab4.models.Game;
import lab4.views.GraphicalCustomGameView;

/**
 *
 * @author fabien
 */
public class CustomGameController implements Observable,ActionListener,MouseListener{
    
    private GraphicalCustomGameView customGameView;
    private JFrame customFrame;
    public GameController gameController;
    
    private int row,column,mines;
    
    public CustomGameController(GameController gameController) {
        this.gameController = gameController;
        this.initCustomGameFrame();
        this.customGameView = new GraphicalCustomGameView(this);
        this.customFrame.add(this.customGameView, BorderLayout.CENTER);
        
    }
    
    private void initCustomGameFrame() {
        this.customFrame = new JFrame("Custom Game");
        this.customFrame.setSize(400, 400);
        this.customFrame.setVisible(true);
        this.customFrame.setLayout(new BorderLayout(5, 5));
    }
    
    private void createCustomGame() {
        if(this.customGameView.getCustomRadio().isSelected()){
            this.column = customGameView.getSliderColumns().getValue();
            this.row = customGameView.getSliderRows().getValue();
            this.mines = customGameView.getSliderMines().getValue();
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
                    customGameView.visibleCustomPanel(false);
                    this.row = 9;
                    this.column = 9;
                    this.mines = 10;
                    break;
                case "intermediaire":
                    customGameView.visibleCustomPanel(false);
                    this.row = 16;
                    this.column = 16;
                    this.mines = 40;
                    break;
                case "expert":
                    customGameView.visibleCustomPanel(false);
                    this.row = 16;
                    this.column = 30;
                    this.mines = 99;
                    break;
                case "custom":
                    customGameView.visibleCustomPanel(true);
                    break;
                default:
                    break;
            }
        }
        if(e.getSource().getClass() == JButton.class){
            JButton buttonOk = (JButton)e.getSource();
            if(buttonOk.getName()  == "buttonOk" ){
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
                    break;
                case "jinputRow":
                    this.customGameView.getSliderRows().setValue(this.customGameView.getJinputRow());
                    break;
                case "jinputColumn":
                    this.customGameView.getSliderColumns().setValue(this.customGameView.getJinputColumn());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        JSlider slider = (JSlider) me.getSource();
        switch(slider.getName()){
            case "sliderRows":
                this.customGameView.setJinputRow(this.customGameView.getSliderRows().getValue());
                break;
            case "sliderColumns":
                this.customGameView.setJinputColumn(this.customGameView.getSliderColumns().getValue());
                break;
            case "sliderMines":
                this.customGameView.setJinputMines(this.customGameView.getSliderMines().getValue());
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
