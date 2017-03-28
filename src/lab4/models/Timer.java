/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.models;

import java.util.Observable;

/**
 *
 * @author Guillaume
 */
public class Timer extends Observable {
    
    java.util.Timer timer;
    private int counter;
    
    private class TimerTask extends java.util.TimerTask {

        @Override
        public void run() {
            counter++;
            setChanged();
            notifyObservers();
        }        
    }
   
    public Timer() {
        this.timer = new java.util.Timer();
    }
    
    public void start() {
       counter = 0;
       this.timer.schedule(new TimerTask(), 1000);
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

