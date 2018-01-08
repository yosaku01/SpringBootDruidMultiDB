package com.rick.datasource;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder {

    /*
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new  ThreadLocal<String>();

    /*
     * 管理所有的数据源id,用于数据源的判断
     */
    public static List<String> datasourceId = new ArrayList<String>();

    /**
     * @Title: setDateSoureType
     * @Description: 设置数据源的变量
     * @param dateSoureType
     * @return void
     * @throws
     */
    public static void setDateSoureType(String dateSoureType){
        CONTEXT_HOLDER.set(dateSoureType);
    }

    /**
     * @Title: getDateSoureType
     * @Description: 获得数据源的变量
     * @return String
     * @throws
     */
    public static String getDateSoureType(){
        return CONTEXT_HOLDER.get();
    }

    /**
     * @Title: clearDateSoureType
     * @Description: 清空所有的数据源变量
     * @return void
     * @throws
     */
    public static void clearDateSoureType(){
        CONTEXT_HOLDER.remove();
    }

    /**
     * @Title: existDateSoure
     * @Description: 判断数据源是否已存在
     * @param dateSoureType
     * @return boolean
     * @throws
     */
    public static boolean existDateSoure(String dateSoureType ){
        return datasourceId.contains(dateSoureType);
    }
}
