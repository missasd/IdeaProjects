package com.smart.beanfactory;

import com.smart.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class BeanFactoryTest {
    @Test
    public void getBean() throws IOException {
        // 使用相应的实现类，加载xml资源，装载配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("com/smart/beanfactory/beans.xml");
        System.out.println(res.getURL());

        // 通过BeanFactory的实现类，返回特定名称的Bean
        DefaultListableBeanFactory factory = new XmlBeanFactory(res);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // XmlBeanDefinitionReader通过Resource装在Spring配置信息并启动IoC容器,
        // 然后通过BeanFactory.getBean(beanName)方法从IOC容器中获取Bean
        reader.loadBeanDefinitions(res);

        System.out.println("init BeanFactory");


        Car car = factory.getBean("car1", Car.class);
        System.out.println("car bean is ready for use");
        car.introduce();



    }
}
