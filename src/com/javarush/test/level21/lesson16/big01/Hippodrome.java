package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Александр on 19.11.2016.
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        ArrayList<Horse> horses = game.getHorses();
        Horse horse1 = new Horse("alisa", 3, 0);
        horses.add(horse1);

        Horse horse2 = new Horse("diana", 3, 0);
        horses.add(horse2);

        Horse horse3 = new Horse("vasilisa", 3, 0);
        horses.add(horse3);

        game.run();

        game.printWinner();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println("\n");
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0.0;
        for (Horse horse : horses) {
            double distance = horse.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        Horse horseResult = null;

        for (Horse horse : horses) {
            if (maxDistance == horse.getDistance()) {
                horseResult = horse;
            }
        }
        return horseResult;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
