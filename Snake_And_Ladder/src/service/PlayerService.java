package service;

import models.Player;
import repository.PlayerRepo;

import java.util.Queue;
import java.util.Scanner;

public class PlayerService {
    static void initializePlayerService(Scanner scanner){
        PlayerRepo playerRepository = new PlayerRepo();
        Queue<Player> playerQueue = PlayerRepo.getPlayerQueue();
        System.out.println("Enter Number of Players");
        int playerNum = scanner.nextInt();
        scanner.nextLine();
        while ((playerNum--) > 0){
            String playerName = scanner.nextLine();
            playerQueue.add(new Player(playerName));
        }
    }
}
