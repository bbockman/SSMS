package ssms.space.broox;

import bis.space.broox.core.CoreLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {

        logger.atInfo().log("Starting application...");

        CoreLauncher.start(new SSMSModule());

    }
}
