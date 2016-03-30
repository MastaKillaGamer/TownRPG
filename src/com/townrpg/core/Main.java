package com.townrpg.core;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("TownRPG", 1280, 720, 60);
        game.start();
    }
}