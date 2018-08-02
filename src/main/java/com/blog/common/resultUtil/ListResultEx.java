package com.blog.common.resultUtil;

import java.util.List;

public class ListResultEx<T> extends ResultEx {
    private static final long serialVersionUID = 1L;
    private Integer totalCount;
    private Integer pageNo;
    private Integer pageSize;

    public ListResultEx() {
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDataList() {
        Object data = this.getData();
        return data != null && data instanceof List ? (List)data : null;
    }

    public void setDataList(List<T> list) {
        super.setData(list);
    }

    /** @deprecated */
    @Deprecated
    public void setData(Object value) {
        try {
            List<T> t = (List)value;
            super.setData(t);
        } catch (Throwable var3) {
            throw new IllegalArgumentException("parameter type error!");
        }
    }

    public ListResultEx<T> makeResult(Integer error, String message, List<T> list) {
        super.makeResult(error, message, list);
        return this;
    }

    public ListResultEx<T> makeResult(Integer error, String message) {
        return this.makeResult(error, message, (List)null);
    }

    public ListResultEx<T> makeResult(BizRetCode error, String message) {
        return this.makeResult(error.getCode(), message, (List)null);
    }

    public ListResultEx<T> makeResult(Integer error) {
        return this.makeResult(error, (String)null, (List)null);
    }

    public ListResultEx<T> makeResult(Result result) {
        return this.makeResult(result.getRetCode(), result.getRetMsg(), (List)result.getData());
    }

    public ListResultEx<T> makeParameterErrorResult() {
        return this.makeResult(BizRetCode.PARAMETER_ERROR);
    }

    public ListResultEx<T> makeParameterErrorResult(String message) {
        return this.makeResult(BizRetCode.PARAMETER_ERROR, message);
    }

    public ListResultEx<T> makeAuthorizationErrorResult() {
        return this.makeResult(BizRetCode.AUTHORIZATION_ERROR);
    }

    public ListResultEx<T> makeAuthorizationErrorResult(String message) {
        return this.makeResult(BizRetCode.AUTHORIZATION_ERROR, message);
    }

    public ListResultEx<T> makeSuccessResult() {
        return this.makeResult(BizRetCode.SUCCESS);
    }

    public ListResultEx<T> makeFailedResult() {
        return this.makeResult(BizRetCode.FAILED);
    }

    public ListResultEx<T> makeFailedResult(String message) {
        return this.makeResult(BizRetCode.FAILED.getCode(), message, (List)null);
    }

    public ListResultEx<T> makeResult(BizRetCode retCode) {
        return this.makeResult(retCode.getCode(), retCode.getDescription(), (List)null);
    }
}
