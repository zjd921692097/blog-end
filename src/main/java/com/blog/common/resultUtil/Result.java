package com.blog.common.resultUtil;

public class Result extends DataObjectBase {
    public static final long serialVersionUID = 1L;
    public Integer retCode;
    public String retMsg;
    public Object data;

    public Result() {
    }

    public Integer getRetCode() {
        return this.retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "Result [retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", data=" + this.data + "]";
    }
}
