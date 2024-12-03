package repository;

import java.util.HashMap;
import java.util.Map;

public class SnakeRepo {
    public static Map<Integer, Integer> getStartLastMap() {
        return startLastMap;
    }

    public SnakeRepo() {
        startLastMap = new HashMap<>();
    }

    static Map<Integer,Integer> startLastMap;
}
