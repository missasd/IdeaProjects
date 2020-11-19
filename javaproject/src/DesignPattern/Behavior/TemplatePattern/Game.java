package DesignPattern.Behavior.TemplatePattern;

public abstract class Game {
    // 定义通用方法，通用方法的具体实现在子类中完成
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // 模板
    // 模板方法被设置为final
    // 但是对通用方法的调用确实写死的，不可被重写
    public final void play(){
        // 初始化游戏
        initialize();
        // 开始游戏
        startPlay();
        // 结束游戏
        endPlay();

    }
}
