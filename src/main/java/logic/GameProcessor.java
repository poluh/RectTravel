package logic;

import GUI.drawing.Drawer;

public class GameProcessor {

    private static boolean gameRunning = false;
    private Drawer drawer;

    public GameProcessor(Drawer drawer) {
        this.drawer = drawer;
    }

    public void start() {
        gameRunning = true;
        while (gameRunning) {

        }
    }

    public static void setGameRunning(boolean gameRunning) {
        GameProcessor.gameRunning = gameRunning;
    }

    public static boolean isGameRunning() {
        return gameRunning;
    }
}
