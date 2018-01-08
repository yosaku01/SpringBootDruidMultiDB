package com.rick.service.impl;

import com.rick.annotation.DataSourceAnnotation;
import com.rick.entities.Student;
import com.rick.mappers.StudentMapper;
import com.rick.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentMapper studentMapper;
	
	@Override
	 /**
     * 插入学生信息
     * @param student 学生信息
     * @param dbType 数据源Id
     * @return 插入成功后的学生id
     */
	public int insertStudent(Student student, String dsId) {
		 studentMapper.insertStudent(student);
	     return student.getId();
	}

	@Override
    /**
     * 根据学生id查找学生信息
     * @param id 学生id
     * @param dsId 数据源Id
     * @return 如果学生存在，返回学生对象，反之返回null
     */
	@DataSourceAnnotation
	public Student findStudentById(int id, String dsId) {
		return studentMapper.findStudentById(id);
	}

   
}
