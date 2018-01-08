package com.rick.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Student implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -179255268078151438L;

	private int id;

    private String name;
    private String className;
    private Timestamp createDate;
    private Timestamp updateDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
