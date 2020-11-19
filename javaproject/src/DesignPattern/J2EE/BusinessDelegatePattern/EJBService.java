package DesignPattern.J2EE.BusinessDelegatePattern;

/**
 * 创建实体服务类
 */
public class EJBService implements BusinessService{

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
