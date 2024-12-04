import java.util.HashMap;
import java.util.Objects;

public class Logger {
    private static Logger logger;
    private static AbstractLogger abstractLoggerChain;
    private Logger() {}
    public static Logger getInstance() {
        if(Objects.isNull(logger)) {
            synchronized (Logger.class) {
                if(Objects.isNull(logger)) {
                    logger = new Logger();
                    AbstractLogger.levelToNameMap = new HashMap<>();
                    abstractLoggerChain = LogManager.buildChainOfLogger();
                }
            }
        }
        return logger;
    }

    private void createLog(int level, String msg) {
        abstractLoggerChain.logMessage(level, msg);
    }

    public void info(String msg) {
        createLog(1, msg);
    }
    public void error(String msg) {
        createLog(2, msg);
    }
    public void debug(String msg) {
        createLog(3, msg);
    }
}
