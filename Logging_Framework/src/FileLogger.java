public class FileLogger implements LogObserver{
    @Override
    public void log(int level, String msg) {
        System.out.println(AbstractLogger.levelToNameMap.get(level) + " File: " + msg);
    }
}
