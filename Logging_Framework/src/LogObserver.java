import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LogObserver {
    void log(int level, String msg);
}
