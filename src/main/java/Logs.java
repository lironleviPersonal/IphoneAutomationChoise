import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

import java.io.IOException;

public class Logs {

   private static Logger log = LogManager.getLogger(Logs.class);

    public static void information(String info){
        log.info(info);
    }
    public static void debugging (String debug) {log.debug(debug);}
}
