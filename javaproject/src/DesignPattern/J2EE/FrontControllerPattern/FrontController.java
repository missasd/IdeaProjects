package DesignPattern.J2EE.FrontControllerPattern;

public class FrontController {

    private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher();
    }

    public boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully");
        return true;
    }

    private void trackRequest(String request){
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request){
        // 记录每一个请求
        trackRequest(request);
        // 对用户身份进行验证
        if (isAuthenticUser()){
            dispatcher.dispatch(request);
        }
    }
}
