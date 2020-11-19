package Spring4.chp4.p1;

/**
 * IOC的类型：
 *          2 属性注入
 */
public class Director_2 {

    public void direct(){

        MoAttack_2 moAttack_2 = new MoAttack_2();

        // 调用属性的Setter方法注入
        GeLi geLi = new LiuDeHua();
        moAttack_2.setGeLi(geLi);
        moAttack_2.cityGateAsk();

    }

    public static void main(String[] args) {
        Director_2 director_2 = new Director_2();
        director_2.direct();

    }
}
