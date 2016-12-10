package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Александр on 10.12.2016.
 */
public class MyThread extends Thread {
    private static int count;
    private int id = ++count;

    public void setCyclicPriority() {
        int priority = id % 10;
        if (priority == 0) priority = 10;
        int maxPriority = Thread.currentThread().getThreadGroup().getMaxPriority();
        if (priority > maxPriority) priority = maxPriority;
        this.setPriority(priority);
    }

    {
        setCyclicPriority();
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
