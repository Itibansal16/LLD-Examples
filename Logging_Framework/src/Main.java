public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        System.out.println(AbstractLogger.levelToNameMap);
        logger.info("Hey logging info msg");

        logger.error("Hey logging error msg");

        logger.debug("Hey logging debug msg");
    }
}