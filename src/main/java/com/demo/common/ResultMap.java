package com.demo.common;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public class ResultMap {
    final static String SUCCESS = "SUCCESS";
    final static String ERROR = "ERROR";
    private String status;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void Success(){
        this.status = this.SUCCESS;
    }
    public void Error(){
        this.status = this.ERROR;
    }



}
