import java.util.HashMap;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;
    static HashMap<Integer, String> levelToNameMap;

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    protected void display(int level, String msg) {
        String levelName = levelToNameMap.get(this.getLevel());
        System.out.println(levelName + ": " + msg);
    }
    void logMessage(int level, String msg) {
        if(this.getLevel() <= level) {
            display(level, msg);
        }
        if(nextLoggingLevel != null) {
            nextLoggingLevel.logMessage(level, msg);
        }
    }
}
