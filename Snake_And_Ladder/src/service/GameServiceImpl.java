package service;

import models.Board;
import models.Player;
import repository.PlayerRepo;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class GameServiceImpl implements GameService{

    BoardService boardService;
    public GameServiceImpl() {
        this.boardService = new BoardService(new Board());
    }

    @Override
    public void startGame() {
        Queue<Player> q = PlayerRepo.getPlayerQueue();
        while (true){
            Player player = q.poll();
            q.add(player);
            int roll = rollDice();
            int newPos = boardService.getNewPosition(player.getPosition(), roll);
            System.out.println(player.getName()+" rolled a "+roll+" and moved from "+player.getPosition()+" to "+newPos);
            player.setPosition(newPos);
            if(newPos == 100) {
                System.out.println(player.getName()+" wins the game");
                break;
            }
        }
    }

    private int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }
}
