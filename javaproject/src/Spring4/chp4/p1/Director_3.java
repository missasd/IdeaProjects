package Spring4.chp4.p1;

public class Director_3 {
    public void direct(){
        MoAttack_3 moAttack3 = new MoAttack_3();
        GeLi geLi = new LiuDeHua();
        moAttack3.injectGeli(geLi);
        moAttack3.cityGateAsk();
    }
}
