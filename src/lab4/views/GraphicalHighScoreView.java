/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lab4.models.Difficulty;
import lab4.models.Score;

/**
 *
 * @author fabien
 */
public class GraphicalHighScoreView  extends JPanel {
    
    private static final int MAX_SCORES_DISPLAY = 5;
    
    public GraphicalHighScoreView(LinkedList<Score> scores) {
        super();
        this.setLayout(new GridLayout(6, 3));
        
        
        ArrayList<Score> beginerScores = new ArrayList<>();
        ArrayList<Score> IntermediaireScores = new ArrayList<>();
        ArrayList<Score> expertScores = new ArrayList<>();
        System.out.println(scores.size());
        for (Score score : scores) {
            System.out.println("lab4.views.GraphicalHighScoreView.<init>()");
            System.out.println(String.valueOf(score.getDifficulty() == Difficulty.BEGINER));
            if(score.getDifficulty() == Difficulty.BEGINER && beginerScores.size() < MAX_SCORES_DISPLAY) {
               beginerScores.add(score); 
            }
            if(score.getDifficulty() == Difficulty.INTERMEDIAIRE && IntermediaireScores.size() < MAX_SCORES_DISPLAY) {
               IntermediaireScores.add(score); 
            }
            if(score.getDifficulty() == Difficulty.EXPERT && expertScores.size() < MAX_SCORES_DISPLAY) {
               expertScores.add(score); 
            }
        }
        
        JLabel label;
        label = new JLabel("BEGINER");
        this.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label = new JLabel("INTERMEDIAIRE");
        this.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label = new JLabel("EXPERT");
        this.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
       
        for(int i = 0; i < MAX_SCORES_DISPLAY; i++) {
            if(beginerScores.size() > i) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String dateStr = formatter.format(beginerScores.get(i).getDate());
                label = new JLabel(String.valueOf(beginerScores.get(i).getScore()) + " sec - " + dateStr);
                label.setHorizontalAlignment(JLabel.CENTER);
               this.add(label); 
            } else {
                label = new JLabel("");
                this.add(label); 
            }
            
            if(IntermediaireScores.size() > i) {
                label = new JLabel(String.valueOf(IntermediaireScores.get(i).getScore()) + " sec");
                label.setHorizontalAlignment(JLabel.CENTER);
               this.add(label); 
            } else {
                this.add(new JLabel("")); 
            }
            
            if(expertScores.size() > i) {
                label = new JLabel(String.valueOf(expertScores.get(i).getScore()) + " sec");
                label.setHorizontalAlignment(JLabel.CENTER);
               this.add(label); 
            } else {
                label = new JLabel("");
                this.add(label); 
            }
        }
        
        
        
        
    }

}
