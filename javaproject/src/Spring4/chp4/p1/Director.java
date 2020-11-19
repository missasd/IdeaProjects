package Spring4.chp4.p1;

/**
 * IOC
 *  1. 构造函数注入
 */
public class Director {
    public void direct(){
        // 1. 指定角色的饰演者
        GeLi geLi = new LiuDeHua();

        // 2. 注入具体饰演者到剧本中
        MoAttack moAttack = new MoAttack(geLi);
        moAttack.cityGateAsk();
    }
}
