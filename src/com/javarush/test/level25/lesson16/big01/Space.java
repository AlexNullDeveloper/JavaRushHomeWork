package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Александр on 26.11.2016.
 */
public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos = new ArrayList<>();
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }


    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void run() {

    }

    public void draw() {

    }

    public void sleep(int ms) {

    }

    public static void main(String[] args) {

    }
}
