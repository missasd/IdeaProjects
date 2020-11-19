package DesignPattern.J2EE.DataAccessObjectPattern;

import java.util.List;

/**
 * DAO接口；对应mybatis中的mapper接口
 */
public interface StudentDao {
    List<Student> getAllStudents();
    Student getStudent(int rollNo);
    void updateStudent(Student student);
    void deleteStudent(Student student);



}
