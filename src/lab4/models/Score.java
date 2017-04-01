/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fabien
 */
public class Score implements Serializable{
    private Difficulty difficulty;
    private int score;
    private Date date;
    public Score(Difficulty difficulty,  int score) {
        this.score = score;
        this.date = new Date();
        this.difficulty = difficulty;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
