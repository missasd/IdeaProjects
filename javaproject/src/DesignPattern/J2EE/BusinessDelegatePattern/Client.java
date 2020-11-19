package DesignPattern.J2EE.BusinessDelegatePattern;

public class Client {

    BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate){
        this.businessDelegate = businessDelegate;
    }

    public void doTask(){
        businessDelegate.doTask();
    }
}