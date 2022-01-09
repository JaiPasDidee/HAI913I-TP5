package log4j;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Formatter extends java.util.logging.Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getMessage();
    }

    @Override
    public String getHead(Handler h) {
        return "[";
    }

    @Override
    public String getTail(Handler h) {
        return "]";
    }
}
