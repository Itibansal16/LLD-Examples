public class DebugLogger extends AbstractLogger{
    private static final String LEVEL_NAME = "DEBUG";
    private static final int LEVEL = 3;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public DebugLogger() {
        this.level = LEVEL;
        levelToNameMap.put(LEVEL, LEVEL_NAME);
    }
}
