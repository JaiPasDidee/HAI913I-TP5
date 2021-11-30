public class HTMLFormateur extends java.util.logging.Formatter {
    // inherited abstract method to be implemented to define formatting behavior
    @java.lang.Override
    public java.lang.String format(java.util.logging.LogRecord record) {
        System.out.println("Enter in the method format from class utils.HTMLFormateurTest");;
        java.lang.StringBuffer buf = new java.lang.StringBuffer(1000);
        buf.append("<tr>/n");
        // color any levels >= WARNING in red
        if (record.getLevel().intValue() >= java.util.logging.Level.WARNING.intValue()) {
            buf.append("\t<td style=\"color:red\">");
            buf.append("<b>");
            buf.append(record.getLevel());
            buf.append("</b>");
        } else {
            buf.append("\t<td>");
            buf.append(record.getLevel());
        }
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append(calcDate(record.getMillis()));
        buf.append("</td>\n");
        buf.append("\t<td>");
        buf.append(formatMessage(record));
        buf.append("</td>\n");
        buf.append("</tr>\n");
        return buf.toString();
    }

    private java.lang.String calcDate(long millis) {
        System.out.println("Enter in the method calcDate from class utils.HTMLFormateurTest");;
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MMM dd,yyyy HH:mm");
        java.util.Date resultDate = new java.util.Date(millis);
        return dateFormat.format(resultDate);
    }

    // method invoked just after the formatter is created
    @java.lang.Override
    public java.lang.String getHead(java.util.logging.Handler h) {
        System.out.println("Enter in the method getHead from class utils.HTMLFormateurTest");;
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
        buf.append("\t\t\t\t<th style=\"width:15%\">Time</th>\n");
        buf.append("\t\t\t\t<th style=\"width:75%\">LogMessage</th>\n");
        buf.append("\t\t\t</tr>\n");
        return buf.toString();
    }

    // method invoked just after the formatter is closed
    @java.lang.Override
    public java.lang.String getTail(java.util.logging.Handler h) {
        System.out.println("Enter in the method getTail from class utils.HTMLFormateurTest");;
        java.lang.StringBuffer buf = new java.lang.StringBuffer(100);
        buf.append("\t\t</table>\n");
        buf.append("\t</body>\n");
        buf.append("</html>");
        return buf.toString();
    }
}