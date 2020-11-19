package DesignPattern.J2EE.MVCPattern;

/**
 * 创建视图
 */
public class StudentView {
    public void pringStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
