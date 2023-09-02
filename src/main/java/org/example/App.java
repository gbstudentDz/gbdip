package org.example;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */
public class App {
    private int globalTimer = 0;
    private int limitTimer = 15;

    public static void main(String[] args) {
        System.out.println("1");
        new App();
        System.out.println("1");
        new App();
        System.out.println("1");
        new App();
        System.out.println("1");
    }

    public App() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                globalTimer++;
                if (globalTimer == limitTimer) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
}
