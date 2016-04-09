package com.townrpg.core;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("TownRPG", 480, 360, 60);
        game.start();
    }
}