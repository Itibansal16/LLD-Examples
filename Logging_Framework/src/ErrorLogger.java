public class ErrorLogger extends AbstractLogger{
    private static final String LEVEL_NAME = "ERROR";
    private static final int LEVEL = 2;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ErrorLogger() {
        this.level = LEVEL;
        levelToNameMap.put(LEVEL, LEVEL_NAME);
    }
}
