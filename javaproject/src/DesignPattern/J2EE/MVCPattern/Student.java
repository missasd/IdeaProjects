package DesignPattern.J2EE.MVCPattern;

/**
 * 创建模型model
 * 贫血模型与充血模型
 *
 * 贫血模型是指领域对象里只有get和set方法（POJO），
 * 所有的业务逻辑都不包含在内而是放在Business Logic层。
 */
public class Student {
    private String rollNo;
    private String name;


    public String getRollNo(){
        return rollNo;
    }
    public void setRollNo(String rollNo){
        this.rollNo = rollNo;
    }



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
