package com.rick.mappers;

import com.rick.entities.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    Student findStudentById(int id);

    int insertStudent(Student student);

    void insertStudents(List<Student> students);

    int updateStudent(Student student);

    int deleteStudentById(int id);

    List<Student> findStudentByCondition(Map<String, String> condition);

    int deleteStudentByCondition(Map<String, String> condition);
}
