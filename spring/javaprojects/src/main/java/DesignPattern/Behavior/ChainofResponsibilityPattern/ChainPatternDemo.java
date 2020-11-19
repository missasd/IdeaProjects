package DesignPattern.Behavior.ChainofResponsibilityPattern;

/**
 * 创建不同类型的记录器，赋予他们不同的错误级别
 * 再每个记录器中设置下一个记录器。
 * 每个记录器代表的是链的一部分；
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an Information");
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information");
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information");
    }
}