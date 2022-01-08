package spoon;

import ecommerce.User;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Formatter extends java.util.logging.Formatter {
    User user;

    public Formatter(User user) {
        this.user = user;
    }

    @Override
    public String format(LogRecord record) {
        StringBuffer buf = new StringBuffer(1000);
        buf.append("\t\t\t\t<th style=\"width:15%\">"+ java.time.LocalTime.now()+"</th>\n");
        buf.append("\t\t\t\t<th style=\"width:75%\">"+ record.getMessage()+"</th>\n");
        buf.append("\t\t\t</tr>\n");
        buf.append("<tr>/n");
        // color any levels >= WARNING in red
        if(record.getLevel().intValue() >= Level.WARNING.intValue()) {
            buf.append("\t<td style=\"color:red\">");
            buf.append("<b>");
            buf.append(record.getLevel());
            buf.append("</b>");
        }
        else {
            buf.append("\t<td>");
            buf.append(record.getLevel());
        }
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append("User id : "+ user.getId());
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append("User name : "+ user.getName());
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append("User age : "+ user.getAge());
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append("User email : "+ user.getEmail());
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append(formatMessage(record));
        buf.append("</td>\n");
        buf.append("</tr>\n");
        return buf.toString();
    }

    @Override
    public String getHead(Handler h) {
        StringBuffer buf = new StringBuffer(10000);
        buf.append("<!DOCTYPE html>\n");
        buf.append("\t<head>\n");
        buf.append("\t\t<style>\n");
        buf.append("\t\ttable { width: 100% }\n");
        buf.append("\t\tth { font: bold 10pt Tahoma; }\n");
        buf.append("\t\ttd { font: normal 10pt Tahoma; }\n");
        buf.append("\t\th1 { font: normal 11pt Tahoma; }\n");
        buf.append("\t\t</style>\n");
        buf.append("\t</head>\n");
        buf.append("\t<body>\n");
        buf.append("\t\t<h1>" + (new Date()) + "\n");
        buf.append("\t\t<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n");
        buf.append("\t\t\t<tr align=\"left\">\n");
        return buf.toString();
    }

    @Override
    public String getTail(Handler h) {
        StringBuffer buf = new StringBuffer(100);
        buf.append("\t\t</table>\n");
        buf.append("\t</body>\n");
        buf.append("</html>");
        return buf.toString();
    }
}
