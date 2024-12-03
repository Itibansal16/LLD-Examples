package service;

import models.Board;
import repository.LadderRepo;
import repository.SnakeRepo;

public class BoardService {
    Board board;
    public BoardService(Board board) {
        this.board = board;
    }

    public int getNewPosition(int currPosiition, int roll) {
        int position = currPosiition + roll;
        if(position > board.getSize()) {
            return currPosiition;
        }
        if(LadderRepo.getStartLastMap().containsKey(position)) {
            return LadderRepo.getStartLastMap().get(position);
        }

        if(SnakeRepo.getStartLastMap().containsKey(position)) {
            return SnakeRepo.getStartLastMap().get(position);
        }

        return position;
    }
}
