package Spring4.chp4.p1;

/**
 * IOC的概念：
 * 控制反转：
 *     即接口具体实现类的选择控制权从调用类中一处，转交给第三方决定
 *     即由Spring容器借由Bean配置来进行控制
 *
 * DI（依赖注入）
 *      调用类对某一接口的依赖关系由第三方（容器或协作类）注入，
 *      以一处调用类对某一接口实现类的依赖
 *
 *
 * IOC的类型：
 *          1. 通过构造函数来注入依赖
 */
public class MoAttack {
    private GeLi geLi;

    // 1. 注入实现GeLi接口的具体饰演者
    public MoAttack(GeLi geLi){
        this.geLi = geLi;
    }

    public void cityGateAsk(){
        geLi.responseAsk("墨者革离!");
    }
}
