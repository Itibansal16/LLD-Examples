public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.info("Hey logging info msg");

        logger.error("Hey logging error msg");

        logger.debug("Hey logging debug msg");
    }
}