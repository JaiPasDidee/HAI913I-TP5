package Formatteur;

import utils.User;

import java.util.Date;
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
        buf.append("\t\t\t\t<th style=\"width:10%\">LogLevel</th>\n");
        buf.append("\t\t\t\t<th style=\"width:15%\">"+ java.time.LocalTime.now()+"</th>\n");
        buf.append("\t\t\t\t<th style=\"width:75%\">LogMessage</th>\n");
        buf.append("\t\t\t</tr>\n");
        return buf.toString();
    }

    @Override
    public String getTail(Handler h) {
        return super.getTail(h);
    }
}
