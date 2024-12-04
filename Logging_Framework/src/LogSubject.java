import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();
    public void addObserver(int level, LogObserver observer) {
        logObservers.putIfAbsent(level, new ArrayList<>());
        logObservers.get(level).add(observer);
    }

    void notifyAllObservers(int level, String msg) {
        logObservers.getOrDefault(level, new ArrayList<>()).forEach(observer -> observer.log(level, msg));
    }
}
