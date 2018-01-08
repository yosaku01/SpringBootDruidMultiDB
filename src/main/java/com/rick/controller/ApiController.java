package com.rick.controller;

import static com.rick.common.AppConstants.CLASS_ATTRIBUTE_NAME;
import static com.rick.common.AppConstants.CRAETE_DATE_ATTRIBUTE_NAME;
import static com.rick.common.AppConstants.DB_TYPE;
import static com.rick.common.AppConstants.FAIL_RESULT;
import static com.rick.common.AppConstants.ID_ATTRIBUTE_NAME;
import static com.rick.common.AppConstants.MESSAGE_CONSTANTS;
import static com.rick.common.AppConstants.NAME_ATTRIBUTE_NAME;
import static com.rick.common.AppConstants.RESULT_CONSTANTS;
import static com.rick.common.AppConstants.STUDENT_NODE_NAME;
import static com.rick.common.AppConstants.SUCCESS_RESULT;
import static com.rick.common.AppConstants.UPDATE_DATE_ATTRIBUTE_NAME;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rick.entities.Student;
import com.rick.service.StudentService;

@RestController
public class ApiController {

    private Logger logger = LogManager.getLogger(ApiController.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Autowired
    private StudentService studentService;

    /**
     * 添加学生并检查
     * @param params 添加的学生信息参数
     * @return 添加学生后检查的结果，如果成功返回Success和添加学生信息，失败返回Fail和失败信息。
     */
    @RequestMapping(value = "/api/addStudent", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> addStudent(@RequestBody String params)
    {
        ResponseEntity<String> response = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, Object> resultMap = new HashMap<>();
        try{

            JSONObject paramJsonObj = JSON.parseObject(params);

            Student student = new Student();
            student.setName(paramJsonObj.getString(NAME_ATTRIBUTE_NAME));
            student.setClassName(paramJsonObj.getString(CLASS_ATTRIBUTE_NAME));
            String dbType = paramJsonObj.getString(DB_TYPE);
            if(StringUtils.isEmpty(dbType))
            {
                dbType = "db1";
            }

            int id = studentService.insertStudent(student,dbType);

            if(id <= 0)
            {
                String errorMessage = "Error happens when insert student, the insert operation failed.";
                logger.error(errorMessage);
                resultMap = new HashMap<>();
                resultMap.put(RESULT_CONSTANTS, FAIL_RESULT);
                resultMap.put(MESSAGE_CONSTANTS, errorMessage);
                String resultStr = JSON.toJSONString(resultMap);

                return new ResponseEntity<>(resultStr,headers, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else
            {
                resultMap.put(RESULT_CONSTANTS, SUCCESS_RESULT);

                Student newStudent = studentService.findStudentById(id,dbType);

                Map<String, String> studentMap = new HashMap<>();
                studentMap.put(ID_ATTRIBUTE_NAME,Integer.toString(id));
                studentMap.put(NAME_ATTRIBUTE_NAME,newStudent.getName());
                studentMap.put(CLASS_ATTRIBUTE_NAME,newStudent.getClassName());
                studentMap.put(CRAETE_DATE_ATTRIBUTE_NAME, sdf.format(newStudent.getCreateDate()));
                studentMap.put(UPDATE_DATE_ATTRIBUTE_NAME, sdf.format(newStudent.getUpdateDate()));
                resultMap.put(STUDENT_NODE_NAME,studentMap);

                String resultStr = JSON.toJSONString(resultMap);
                response = new ResponseEntity<>(resultStr,headers, HttpStatus.OK);
            }
        }
        catch(Exception ex)
        {
            response = processException("insert student", ex, headers);
        }
        return response;
    }

    private ResponseEntity<String> processException(String operationName, Exception ex, HttpHeaders headers)
    {
        String errorMessageTemplate = "Error happens when %s.The exception info is:" + ExceptionUtils.getMessage(ex);
        String errorMessage = String.format(errorMessageTemplate,operationName);
        logger.error(errorMessage);
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put(RESULT_CONSTANTS, FAIL_RESULT);
        resultMap.put(MESSAGE_CONSTANTS, ex.getMessage());
        String resultStr = JSON.toJSONString(resultMap);

        return new ResponseEntity<>(resultStr,headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
