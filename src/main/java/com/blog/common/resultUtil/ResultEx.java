package com.blog.common.resultUtil;

public class ResultEx extends Result {
    private static final long serialVersionUID = 1L;

    public ResultEx() {
    }

    public boolean isSuccess() {
        Integer retCode = this.getRetCode();
        return retCode != null && retCode == BizRetCode.SUCCESS.getCode();
    }

    public boolean isFailed() {
        return !this.isSuccess();
    }

    public ResultEx makeResult(Integer retCode, String retMsg, Object data) {
        if (retCode != null) {
            this.setRetCode(retCode);
        }

        if (retMsg != null) {
            this.setRetMsg(retMsg);
        }

        if (data != null) {
            this.setData(data);
        }

        return this;
    }

    public ResultEx makeResult(Integer retCode, String retMsg) {
        return this.makeResult(retCode, retMsg, (Object)null);
    }

    public ResultEx makeResult(BizRetCode retCode, String retMsg) {
        return this.makeResult(retCode.getCode(), retMsg, (Object)null);
    }

    public ResultEx makeResult(Integer retCode) {
        return this.makeResult(retCode, (String)null, (Object)null);
    }

    public ResultEx makeResult(Result result) {
        return this.makeResult(result.getRetCode(), result.getRetMsg(), result.getData());
    }

    public ResultEx makeParameterErrorResult() {
        return this.makeResult(BizRetCode.PARAMETER_ERROR);
    }

    public ResultEx makeParameterErrorResult(String retMsg) {
        return this.makeResult(BizRetCode.PARAMETER_ERROR, retMsg);
    }

    public ResultEx makeAuthorizationErrorResult() {
        return this.makeResult(BizRetCode.AUTHORIZATION_ERROR);
    }

    public ResultEx makeAuthorizationErrorResult(String retMsg) {
        return this.makeResult(BizRetCode.AUTHORIZATION_ERROR, retMsg);
    }

    public ResultEx makeSuccessResult() {
        return this.makeResult(BizRetCode.SUCCESS);
    }

    public ResultEx makeFailedResult() {
        return this.makeResult(BizRetCode.FAILED);
    }

    public ResultEx makeFailedResult(String retMsg) {
        return this.makeResult(BizRetCode.FAILED.getCode(), retMsg, (Object)null);
    }

    public ResultEx makeResult(BizRetCode retCode) {
        return this.makeResult(retCode.getCode(), retCode.getDescription(), (Object)null);
    }
}
