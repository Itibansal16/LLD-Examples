import models.Player;
import service.GameService;
import service.GameServiceImpl;
import service.InMemoryService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        InMemoryService inmemory=new InMemoryService(scanner);
        GameService gameService = new GameServiceImpl();
        gameService.startGame();
        System.out.println("Hello world!");
    }
}