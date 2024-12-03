package repository;

import java.util.HashMap;
import java.util.Map;

public class LadderRepo {
    public static Map<Integer, Integer> getStartLastMap() {
        return startLastMap;
    }

    public LadderRepo() {
        startLastMap = new HashMap<>();
    }

    static Map<Integer,Integer> startLastMap;
}
