package service;

import java.util.Scanner;

public class InMemoryService {
    public InMemoryService(Scanner scanner) {
        SnakeService.initializeSnakeRepo(scanner);
        LadderServiceImpl.initializeLadderRepo(scanner);
        PlayerService.initializePlayerService(scanner);
    }
}
