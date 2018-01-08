package com.rick.service;

import com.rick.entities.Student;


public interface StudentService {

    /**
     * 插入学生信息
     * @param student 学生信息
     * @param dbType 数据源Id
     * @return 插入成功后的学生id
     */
    int insertStudent(Student student, String dsId);



    /**
     * 根据学生id查找学生信息
     * @param id 学生id
     * @param dsId 数据源Id
     * @return 如果学生存在，返回学生对象，反之返回null
     */
    Student findStudentById(int id, String dsId);

}
