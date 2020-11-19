package DesignPattern.J2EE.InterceptingFilterPattern;

public class DebugFilter implements Filter{

    @Override
    public void execute(String request) {
        System.out.println("Request log: " + request);
    }
}
