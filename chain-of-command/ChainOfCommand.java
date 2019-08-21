abstract class Logger {
    private Logger nextLogger;

    private LogLevel logLevel;

    public Logger(LogLevel inLogLevel) {
        this.logLevel = inLogLevel;
    }

    public Logger setNextLogger(Logger inNextLogger) {
        this.nextLogger = inNextLogger;
        return this;
    }

    public void log(LogLevel inLogLevel, String inMessage) {
        if (logLevel == inLogLevel) {
            writeMessage(inMessage);
        } else if (nextLogger != null){
            nextLogger.log(inLogLevel, inMessage);
        }
    }

    protected void writeMessage(String inMessage) {
        System.out.println("Sending message !");
    }
}

class MailLogger extends Logger {
    public MailLogger(LogLevel inLogLevel) {
        super(inLogLevel);
    }

    @Override
    protected void writeMessage(String inMessage) {
        System.out.println("Write mail: " + inMessage);
    }
}

class ConsoleLogger extends Logger {
    public ConsoleLogger(LogLevel inLogLevel) {
        super(inLogLevel);
    }

    @Override
    protected void writeMessage(String inMessage) {
        System.out.println("Write to console: " + inMessage);
    }
}

enum LogLevel {
    DEBUG,
    WARNING,
    INFO
}

class ChainOfCommand {
    public static void main(String args[]) {

        /** at this point the chain can be assembled dynamically and could be changed/replaced at runtime.
         * Different modules of the application could use the same logging components but with a differently assembled chain
         * As this example illustrates the same could be accomplished using if else or switch statements however this version
         * remains flexible and requires no changes to the existing logger implementation.
         * In order to expand this version one would simple create a new specific logger class and plug it into the chain.
         */
        Logger loggerChain = new ConsoleLogger(LogLevel.DEBUG).setNextLogger(new MailLogger(LogLevel.WARNING));
        loggerChain.log(LogLevel.DEBUG, "debug test");
        loggerChain.log(LogLevel.WARNING, "warning test");

    }

}
