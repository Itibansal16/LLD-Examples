public class LogManager {
    protected  static AbstractLogger buildChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger debugLogger = new DebugLogger();
        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);

        return infoLogger;
    }
}
