package DesignPattern.J2EE.BusinessDelegatePattern;

/**
 * 创建业务查询服务
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType){
        if (serviceType.equalsIgnoreCase("EJB")){
            return new EJBService();
        }else {
            return new JMSService();
        }
    }
}
