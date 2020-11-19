package Spring4.chp4.p1;

/**
 *  IOC的类型：
 *      2. 属性注入
 */
public class MoAttack_2 {
    private GeLi geLi;

    // 1 属性注入方法
    public void setGeLi(GeLi geLi){
        this.geLi = geLi;
    }

    public void cityGateAsk(){
        geLi.responseAsk("墨者隔离");
    }
}
