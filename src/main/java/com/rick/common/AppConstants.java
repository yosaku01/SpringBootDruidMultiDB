package com.rick.common;

public class AppConstants {

    private AppConstants() {

    }

    public static final String DATA_SOURCE_PREfIX_CUSTOM="spring.custom.datasource.";

    public static final String DATA_SOURCE_CUSTOM_NAME="name";

    public static final String SEP = ",";
    public static final String DRUID_SOURCE_PREFIX = "spring.datasource.druid.";

    public static final String DATA_SOURCE_TYPE = "type";
    public static final String DATA_SOURCE_DRIVER = "driver-class-name";
    public static final String DATA_SOURCE_URL = "url";
    public static final String DATA_SOURCE_USER_NAME = "username";
    public static final String DATA_SOURCE_PASSWORD = "password";

    public static final String DATASOURCE_TYPE_DEFAULT = "com.alibaba.druid.pool.DruidDataSource";


    public static final  String RESULT_CONSTANTS = "result";
    public static final  String SUCCESS_RESULT = "SUCCESS";
    public static final  String FAIL_RESULT = "FAIL";
    public static final  String MESSAGE_CONSTANTS = "message";

    public static final String STUDENTS_NODE_NAME = "students";
    public static final String STUDENT_NODE_NAME = "student";

    public static final String ID_ATTRIBUTE_NAME = "id";
    public static final String NAME_ATTRIBUTE_NAME = "name";
    public static final String CLASS_ATTRIBUTE_NAME = "className";
    public static final String CRAETE_DATE_ATTRIBUTE_NAME = "createDate";
    public static final String UPDATE_DATE_ATTRIBUTE_NAME = "updateDate";
    public static final String ENABLED_ATTRIBUTE_NAME = "enabled";
    public static final String DB_TYPE = "dbType";

    public static final String ID_JSON_PATH = "$.id";
    public static final String STUDENT_ID_JSON_PATH = "$.student.id";
    public static final String NAME_JSON_PATH = "$.name";
    public static final String STUDENT_NAME_JSON_PATH = "$.student.name";
    public static final String CLASS_JSON_PATH = "$.className";
    public static final String STUDENT_CLASS_JSON_PATH = "$.student.className";
    public static final String RESULT_JSON_PATH = "$.result";
    public static final String MESSAGE_JSON_PATH = "$.message";
    public static final String STUDENTS_JSON_PATH = "$.students";
    public static final String NEW_NAME_JSON_PATH = "$.newName";
    public static final String NEW_CLASS_JSON_PATH = "$.newClassName";

    public static final String STUDENT_NOT_EXIST  = "The student having id %d does not exist!";
    public static final String STUDENTS_NOT_EXIST = "No matched students";
    

    public static final String ADD_STUDENT_API_URL = "/api/addStudent";
    public static final String ADD_STUDENTS_API_URL = "/api/addStudents";
    public static final String DELETE_STUDENT_API_URL = "/api/deleteStudent";
    public static final String UPDATE_STUDENT_API_URL = "/api/updateStudent";
    public static final String GET_STUDENT_API_URL = "/api/getStudent";
    public static final String GET_STUDENTS_API_URL = "/api/getStudents";
    public static final String DELETE_STUDENTS_API_URL = "/api/deleteStudents";
}
