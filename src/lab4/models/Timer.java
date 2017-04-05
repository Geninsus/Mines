/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.sql.Timestamp;
import java.util.Observable;

/**
 *
 * @author Guillaume
 */
public class Timer extends Observable {
    
    java.util.Timer timer;
    private int counter;
    private long time;
    
    private class TimerTask extends java.util.TimerTask {

        @Override
        public void run() {
            counter = (int) ((System.currentTimeMillis() - time) / 1000);
            setChanged();
            notifyObservers();
        }        
    }
   
    public Timer() {
        this.timer = new java.util.Timer();
    }
    
    public void start() {
       counter = 0;
       time = System.currentTimeMillis(); 
       this.timer.schedule(new TimerTask(), 100, 100);
    }
    
    public void stop() {
        this.timer.cancel();
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }
}

