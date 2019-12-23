import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Logs {

   private static Logger log = LogManager.getLogger(Logs.class);

    public static void information(String info){
        log.info(info);
    }
    public static void debugging (String debug) {log.debug(debug);}
    public static void error(String error) {log.error(error);}
}
