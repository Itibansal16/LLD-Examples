package service;

import repository.LadderRepo;
import repository.SnakeRepo;

import java.util.Map;
import java.util.Scanner;

public class SnakeService {
    static void initializeSnakeRepo(Scanner scanner) {
        SnakeRepo snakeRepo = new SnakeRepo();
        Map<Integer,Integer> snakeRepoStartLastMap= snakeRepo.getStartLastMap();
        System.out.println("Enter Number of Snakes");
        int snakeNum = scanner.nextInt();
        scanner.nextLine();
        while ((snakeNum--) > 0){
            String[] snakePos = scanner.nextLine().split(" ");
            int start = Integer.parseInt(snakePos[0]);
            int end = Integer.parseInt(snakePos[1]);
            snakeRepoStartLastMap.put(start,end);
        }
    }
}
