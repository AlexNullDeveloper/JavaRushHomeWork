package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Александр on 27.11.2016.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;
    public LoggingStateThread(Thread target) {
        this.thread = target;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State state = this.thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (state != this.thread.getState()) {
                state = this.thread.getState();
                System.out.println(state);
            }
        }
    }
}
