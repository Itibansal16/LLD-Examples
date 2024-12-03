package service;

import repository.LadderRepo;

import java.util.Map;
import java.util.Scanner;

public class LadderServiceImpl {
    static void initializeLadderRepo(Scanner scanner) {
        LadderRepo ladderRepo = new LadderRepo();
        Map<Integer,Integer> ladderMap= ladderRepo.getStartLastMap();
        System.out.println("Enter Number of Ladders");
        int ladderNum = scanner.nextInt();
        scanner.nextLine();
        while ((ladderNum--) > 0){
            String[] ladderPos = scanner.nextLine().split(" ");
            int start = Integer.parseInt(ladderPos[0]);
            int end = Integer.parseInt(ladderPos[1]);
            ladderMap.put(start,end);
        }
    }
}
