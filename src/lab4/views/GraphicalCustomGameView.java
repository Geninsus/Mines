/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author fabien
 */
public class GraphicalCustomGameView extends JPanel{
    public GraphicalCustomGameView() {
        super();
        
        this.setLayout(new GridLayout(3,3,0,0));
        
        JTextField jinputRow = new JTextField();
        JTextField jinputColumn = new JTextField();
        JTextField jinputMines = new JTextField();
        
        JSlider rows = new JSlider(JSlider.HORIZONTAL,9, 23, 9);
        rows.setMajorTickSpacing(2);
        rows.setMinorTickSpacing(1);
        rows.setPaintTicks(true);
        rows.setPaintLabels(true);
        
        JSlider columns = new JSlider(JSlider.HORIZONTAL, 9, 29, 19);
        columns.setMajorTickSpacing(4);
        columns.setMinorTickSpacing(2);
        columns.setPaintTicks(true);
        columns.setPaintLabels(true);
        
        JSlider mines = new JSlider(JSlider.HORIZONTAL, 9, 139, 76);
        mines.setMajorTickSpacing(26);
        mines.setMinorTickSpacing(13);
        mines.setPaintTicks(true);
        mines.setPaintLabels(true);
        
        JLabel labelRows = new JLabel("Rows");
        labelRows.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelRows);
        this.add(rows);
        this.add(jinputRow);
        this.add(new JLabel("Columns"));
        this.add(columns);
        this.add(jinputColumn);
        this.add(new JLabel("Mines"));
        this.add(mines);
        this.add(jinputMines);
    }
}
