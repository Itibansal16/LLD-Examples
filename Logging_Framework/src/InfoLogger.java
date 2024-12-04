import java.util.HashMap;
import java.util.Objects;

public class InfoLogger extends AbstractLogger{
    private static final String LEVEL_NAME = "INFO";
    private static final int LEVEL = 1;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public InfoLogger() {
        this.level = LEVEL;
        levelToNameMap.put(LEVEL, LEVEL_NAME);
    }
}
