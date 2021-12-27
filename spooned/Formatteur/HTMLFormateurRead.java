package Formatteur;
public class HTMLFormateurRead extends java.util.logging.Formatter {
    utils.User user;

    public HTMLFormateurRead(utils.User user) {
        this.user = user;
    }

    @java.lang.Override
    public java.lang.String format(java.util.logging.LogRecord record) {
        return null;
    }

    @java.lang.Override
    public java.lang.String getHead(java.util.logging.Handler h) {
        java.lang.StringBuffer buf = new java.lang.StringBuffer(10000);
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
        buf.append(("\t\t<h1>" + new java.util.Date()) + "\n");
        buf.append("\t\t<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n");
        buf.append("\t\t\t<tr align=\"left\">\n");
        buf.append("\t\t\t\t<th style=\"width:10%\">LogLevel</th>\n");
        buf.append(("\t\t\t\t<th style=\"width:15%\">" + java.time.LocalTime.now()) + "</th>\n");
        buf.append("\t\t\t\t<th style=\"width:75%\">LogMessage</th>\n");
        buf.append("\t\t\t</tr>\n");
        return buf.toString();
    }

    @java.lang.Override
    public java.lang.String getTail(java.util.logging.Handler h) {
        return super.getTail(h);
    }
}