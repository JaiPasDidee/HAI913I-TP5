package spoon;

import ecommerce.User;

import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Formatter extends java.util.logging.Formatter {
    User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append("\t\t\t\t<th style=\"width:15%\">").append(java.time.LocalTime.now()).append("</th>\n");
        builder.append("\t\t\t</tr>\n");
        builder.append("<tr>/n");
        // color any levels >= WARNING in red
        if(record.getLevel().intValue() >= Level.WARNING.intValue()) {
            builder.append("\t<td style=\"color:red\">");
            builder.append("<b>");
            builder.append(record.getLevel());
            builder.append("</b>");
        }
        else {
            builder.append("\t<td>");
            builder.append(record.getLevel());
        }
        builder.append("</td>\n");
        builder.append("\t<td>");
        builder.append("User id : ").append(user.getId());
        builder.append("</td>\n");
        builder.append("\t<td>");
        builder.append("User name : ").append(user.getName());
        builder.append("</td>\n");
        builder.append("\t<td>");
        builder.append("User age : ").append(user.getAge());
        builder.append("</td>\n");
        builder.append("\t<td>");
        builder.append("User email : ").append(user.getEmail());
        builder.append("</td>\n");
        builder.append("\t<td>");
        builder.append(formatMessage(record));
        builder.append("</td>\n");
        builder.append("</tr>\n");
        return builder.toString();
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
