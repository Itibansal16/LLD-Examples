package repository;

import models.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PlayerRepo {
    public static Queue<Player> getPlayerQueue() {
        return playerQueue;
    }

    public PlayerRepo() {
        playerQueue = new LinkedList<>();
    }

    static Queue<Player> playerQueue;
}
