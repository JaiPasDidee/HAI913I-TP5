package Formatteur;

import utils.User;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class HTMLFormateurRead extends Formatter {
    User user;

    public HTMLFormateurRead(User user) {
        this.user = user;
    }

    @Override
    public String format(LogRecord record) {
        return null;
    }

    @Override
    public String getHead(Handler h) {
        return super.getHead(h);
    }

    @Override
    public String getTail(Handler h) {
        return super.getTail(h);
    }
}
