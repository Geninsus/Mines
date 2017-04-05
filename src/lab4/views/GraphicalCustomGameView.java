/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import lab4.controllers.CustomGameController;
import lab4.models.Game;


public class GraphicalCustomGameView extends JPanel implements Observer{

    CustomGameController customGameController;
    private JPanel sliderPanel;
    private JFormattedTextField jinputMines,jinputColumn,jinputRow;
    private JRadioButton customRadio;
    private JSlider sliderMines,sliderColumns,sliderRows;
    
    public GraphicalCustomGameView(CustomGameController customGameController) {
        super();
        this.customGameController = customGameController;
        this.setLayout(new BorderLayout());
        this.addRadioButton();
        this.addSliders();
        this.addButton();
        /* Initialise cusotm panel as unvisible */
        this.visibleCustomPanel(false);
    }
    
    /* Add all radio button in the global panel */
    private void addRadioButton() {

        /* Radio Button Panel */
         JPanel panelRadio = new JPanel();
         panelRadio.setLayout(new BoxLayout(panelRadio, BoxLayout.PAGE_AXIS));


         /* Group of RadioButton so that only one button can be selected */
         ButtonGroup radioGroup = new ButtonGroup();

         /* Radio Button Beginner */
         JRadioButton beginnerRadio = new JRadioButton("Beginner : 10 mines in a 9 x 9 field");
         beginnerRadio.setName("beginner");
         beginnerRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
         beginnerRadio.addActionListener(customGameController);
         radioGroup.add(beginnerRadio);
         panelRadio.add(beginnerRadio);

         /* Radio Button Intermediaire */
         JRadioButton intermediaireRadio = new JRadioButton("Intermediaire : 40 mines in a 16 x 16 field");
         intermediaireRadio.setName("intermediaire");
         intermediaireRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
         intermediaireRadio.addActionListener(customGameController);
         radioGroup.add(intermediaireRadio);
         panelRadio.add(intermediaireRadio);

         /* Radio Button Expert */
         JRadioButton expertRadio = new JRadioButton("Expert : 90 mines in a 16 x 30 field");
         expertRadio.setName("expert");
         expertRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
         expertRadio.addActionListener(customGameController);
         radioGroup.add(expertRadio);
         panelRadio.add(expertRadio);

         /* Radio Button Custom */
         this.customRadio = new JRadioButton("Custom");
         customRadio.setName("custom");
         customRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
         customRadio.addActionListener(customGameController);
         radioGroup.add(customRadio);
         panelRadio.add(customRadio);


         /* Add to global panel at NORTH position */
         this.add(panelRadio,BorderLayout.NORTH);
    }
   
    /* Add all sliders, textfields and paneltext in the global panel */
    private void addSliders() {
        /* Sliders Panel */

          /* Input texteFields */
          this.sliderPanel = new JPanel(new GridLayout(3,3,0,0));
          sliderPanel.setName("sliderPanel");
          
          NumberFormat numberFormat = NumberFormat.getNumberInstance();
          numberFormat.setMaximumIntegerDigits(3);
          numberFormat.setMinimumIntegerDigits(1);

          this.jinputRow = new JFormattedTextField(numberFormat);
          this.jinputRow.setName("jinputRow");
          this.jinputRow.setValue(Game.MINIMUMROWS);
          this.jinputRow.addActionListener(customGameController);

          this.jinputColumn = new JFormattedTextField(numberFormat);
          this.jinputColumn.setName("jinputColumn");
          this.jinputColumn.setValue(19);
          this.jinputColumn.addActionListener(customGameController);

          this.jinputMines = new JFormattedTextField(numberFormat);
          this.jinputMines.setName("jinputMines");
          this.jinputMines.setValue(76);
          this.jinputMines.addActionListener(customGameController);


          /* Sliders */
          this.sliderRows = new JSlider(JSlider.HORIZONTAL,9, 23, 9);
          this.sliderRows.setName("sliderRows");
          this.sliderRows.setMajorTickSpacing(2);
          this.sliderRows.setMinorTickSpacing(1);
          this.sliderRows.setPaintTicks(true);
          this.sliderRows.setPaintLabels(true);
          this.sliderRows.addMouseListener(customGameController);

          this.sliderColumns = new JSlider(JSlider.HORIZONTAL, 9, 29, 19);
          this.sliderColumns.setName("sliderColumns");
          this.sliderColumns.setMajorTickSpacing(4);
          this.sliderColumns.setMinorTickSpacing(2);
          this.sliderColumns.setPaintTicks(true);
          this.sliderColumns.setPaintLabels(true);
          this.sliderColumns.addMouseListener(customGameController);


          this.sliderMines = new JSlider(JSlider.HORIZONTAL, 9, 139, 76);
          this.sliderMines.setName("sliderMines");
          this.sliderMines.setMajorTickSpacing(26);
          this.sliderMines.setMinorTickSpacing(13);
          this.sliderMines.setPaintTicks(true);
          this.sliderMines.setPaintLabels(true);
          this.sliderMines.addMouseListener(customGameController);

          /* Text label */
          JLabel labelText = new JLabel("Rows");
          labelText.setHorizontalAlignment(SwingConstants.CENTER);

          sliderPanel.add(labelText);
          sliderPanel.add(this.sliderRows);
          sliderPanel.add(this.jinputRow);

          labelText = new JLabel("Columns");
          labelText.setHorizontalAlignment(SwingConstants.CENTER);

          sliderPanel.add(labelText);
          sliderPanel.add(this.sliderColumns);
          sliderPanel.add(this.jinputColumn);

          labelText = new JLabel("Mines");
          labelText.setHorizontalAlignment(SwingConstants.CENTER);

          sliderPanel.add(labelText);
          sliderPanel.add(this.sliderMines);
          sliderPanel.add(this.jinputMines);

          /* Add to global panel at CENTER position */
          this.add(sliderPanel,BorderLayout.CENTER);
    }
  
    /* Add the confirmation button */
    private void addButton() {  

          /* Add validation button at SOUTH position */
          JButton buttonOk = new JButton("OK");
          buttonOk.setName("buttonOk");
          buttonOk.addActionListener(customGameController);
          this.add(buttonOk,BorderLayout.SOUTH);
    }
    
    /* Define the custom panel as visible or unvisible ( hidden ) */
    public void visibleCustomPanel(boolean bool) {
        this.sliderPanel.setVisible(bool);
    }
    

    /* GETTERS AND SETTERS */
    

    /**
     * @return the customRadio
     */
    public JRadioButton getCustomRadio() {
        return customRadio;
    }
    
    /**
     * @return the sliderMines
     */
    public JSlider getSliderMines() {
        return sliderMines;
    }

    /**
     * @return the sliderColumns
     */
    public JSlider getSliderColumns() {
        return sliderColumns;
    }

    /**
     * @return the sliderRows
     */
    public JSlider getSliderRows() {
        return sliderRows;
    }

    /**
     * @return the jinputRow
     */
    public int getJinputRow() {
        Number num = (Number)this.jinputRow.getValue();
        
        /* Checking if the input value is not out of range */
        if (num.intValue() <= Game.MINIMUMROWS) {
            this.jinputRow.setValue(Game.MINIMUMROWS);
            return Game.MINIMUMROWS;
        }else if(num.intValue() >= Game.MAXIMUMROWS){
            this.jinputRow.setValue(Game.MAXIMUMROWS);
            return Game.MAXIMUMROWS;
        }else{
            return num.intValue();
        }
    }

    /**
     * @return the jinputColumn
     */
    public int getJinputColumn() {
        
        Number num = (Number)this.jinputColumn.getValue();
        /* Checking if the input value is not out of range */
        if (num.intValue() <= Game.MINIMUMCOLUMNS) {
            this.jinputColumn.setValue(Game.MINIMUMCOLUMNS);
            return Game.MINIMUMCOLUMNS;
        }else if(num.intValue() >= Game.MAXIMUMCOLUMNS){
            this.jinputColumn.setValue(Game.MAXIMUMCOLUMNS);
            return Game.MAXIMUMCOLUMNS;
        }else{
            return num.intValue();
        }
    }

    /**
     * @return the jinputMines
     */
    public int getJinputMines() {
        Number num = (Number)this.jinputMines.getValue();
        
        if(num.intValue()>139){
            this.jinputMines.setValue(139);
        }else if(num.intValue() < 9){
            this.jinputMines.setValue(9);
        }
        return num.intValue();
    }

    /**
     * @param jinputMines the jinputMines to set
     */
    public void setJinputMines(int jinputMines) {
        this.jinputMines.setText(Integer.toString(jinputMines));
        this.jinputMines.updateUI();
    }

    /**
     * @param jinputColumn the jinputColumn to set
     */
    public void setJinputColumn(int jinputColumn) {
        this.jinputColumn.setText(Integer.toString(jinputColumn));
        this.jinputColumn.updateUI();
    }

    /**
     * @param jinputRow the jinputRow to set
     */
    public void setJinputRow(int jinputRow) {
        this.jinputRow.setText(Integer.toString(jinputRow));
        this.jinputRow.updateUI();
    }

    /**
     * @param sliderMines the sliderMines to set
     */
    public void setSliderMines(JSlider sliderMines) {
        this.sliderMines = sliderMines;
    }

    /**
     * @param sliderColumns the sliderColumns to set
     */
    public void setSliderColumns(JSlider sliderColumns) {
        this.sliderColumns = sliderColumns;
    }

    /**
     * @param sliderRows the sliderRows to set
     */
    public void setSliderRows(JSlider sliderRows) {
        this.sliderRows = sliderRows;
    }
    
    public void updateMines(){
        this.sliderMines.setMaximum( (int) (this.sliderColumns.getValue()*this.sliderRows.getValue()*0.85) );
        this.sliderMines.setLabelTable(null);
        this.sliderMines.setMajorTickSpacing((int)(this.sliderMines.getMaximum() - this.sliderMines.getMinimum())/5);
    }
    
    /* Override methods */
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
