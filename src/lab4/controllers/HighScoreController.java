/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import javax.swing.JFrame;
import lab4.models.Score;
import lab4.views.GraphicalHighScoreView;

/**
 *
 * @author fabien
 */
public class HighScoreController {
    public GameController gameController;
    private JFrame frame;
    private GraphicalHighScoreView highScoreView;
    
    public HighScoreController(GameController gameController) {
        this.gameController = gameController;
        this.initHighScoreFrame();
        
        LinkedList<Score> scores = new LinkedList<Score>();

        Score score;
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("score.ser"));
            while(true) {
                try {
                    score = (Score) objectInputStream.readObject();
                    System.out.println("lab4.controllers.HighScoreController.<init>()");
                    boolean alreadyAdd = false;
                    for(int i = 0; i < scores.size(); i++) {
                        if(score.getScore() < scores.get(i).getScore()) {
                            scores.add(i, score);
                            alreadyAdd = true;
                            break;
                        }
                    }
                    if(!alreadyAdd) scores.add(score);
                } catch (IOException | ClassNotFoundException ex) {
                    break;
                }
            }
        }
        catch(IOException ioException){
            System.err.println(ioException);
        }
        System.out.println(scores.size());
        this.highScoreView = new GraphicalHighScoreView(scores);
        this.frame.add(this.highScoreView, BorderLayout.CENTER);
    }
    
    private void initHighScoreFrame() {
        this.frame = new JFrame("High scores");
        this.frame.setSize(400, 400);
        this.frame.setVisible(true);
        this.frame.setLayout(new BorderLayout(5, 5));
    }
}
