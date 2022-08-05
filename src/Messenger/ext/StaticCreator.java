package Messenger.ext;

import java.util.Calendar;
import java.util.Date;

public class StaticCreator {
    private static int indexIDMessage = 0;
    private static final Calendar now = Calendar.getInstance();
    public static ID getNewIDForContentModel() {
        return new ID(indexIDMessage++);
    }

    public static Date getDateTime() {
        return now.getTime();
    }
}
