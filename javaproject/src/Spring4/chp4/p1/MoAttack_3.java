package Spring4.chp4.p1;

/**
 * IOC的类型
 *      3 通过接口方法注入被依赖的类
 */
public class MoAttack_3 implements ActorArrangable{
    private GeLi geLi;

    // 实现接口方法
    public void injectGeli(GeLi geLi){
        this.geLi = geLi;
    }

    public void cityGateAsk(){
        geLi.responseAsk("墨者隔离");
    }
}
