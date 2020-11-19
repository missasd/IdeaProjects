package DesignPattern.Behavior.InterpreterPattern;

/**
 * 使用Expression类来创建规则，并解析他们
 */
public class InterpreterPatternDemo {
    /**
     * 规则：Robert和John是男性
     * @return
     */
    public static Expression getMaleExpression(){
        TerminalExpression robert = new TerminalExpression("Robert");
        TerminalExpression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }
    // 规则Julie是已婚妇女
    public static Expression getMarriedWomanExpression(){
        TerminalExpression julie = new TerminalExpression("Julie");
        TerminalExpression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male?" + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    }

}
