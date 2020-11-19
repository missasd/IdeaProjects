package DesignPattern.Behavior.TemplatePattern;

import Spring4.chp4.p2.Bird;

public abstract class Animal {

    abstract void Birth();
    abstract void Growup();
    abstract void Dead();

    // 模板方法
    public final void animal(){
        Birth();
        Growup();
        Dead();
    }
}
