package DesignPattern.Behavior.ChainofResponsibilityPattern;

public class FileLogger extends AbstractLogger {

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);

    }

    public FileLogger(int level){
        this.level = level;
    }
}
