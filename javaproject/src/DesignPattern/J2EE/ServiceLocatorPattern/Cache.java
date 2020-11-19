package DesignPattern.J2EE.ServiceLocatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建缓存
 */
public class Cache {
    private List<Service> services;

    public Cache(){
        services = new ArrayList<Service>();
    }

    public Service getService(String serviceName){
        for (Service service : services){
            if (service.getName().equalsIgnoreCase(serviceName)){
                System.out.println("Returning cached  "+serviceName+" object");
                return service;
            }
        }
        return null;
    }

    public void addService(Service service){
        boolean exists = false;
        for (Service servicel : services){
            if (service.getName().equalsIgnoreCase(servicel.getName())){
                exists = true;
            }
        }
        if (!exists){
            services.add(service);
        }
    }
}
