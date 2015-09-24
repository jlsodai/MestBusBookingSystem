package bookingsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by law on 9/24/15.
 */
public class LogFiles {

    String LOG_FILE = "logfile.logs";
    FileWriter fileWriter;
    File file;
    Date date;

    public LogFiles(){
        date = new Date();
        file = new File(LOG_FILE);
    }

    public void addActionToLogs(String action) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            fileWriter.write("[" + date.toString() + "]: " + action + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
