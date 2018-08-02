package com.blog.common.resultUtil;

public enum BizRetCode {
    SUCCESS(1, "成功"),
    FAILED(2, "失败"),
    COMMON_ERROR(-101, "系统繁忙，请稍后再试"),
    PARAMETER_ERROR(-102, "参数错误"),
    AUTHORIZATION_ERROR(-103, "权限错误"),
    NOT_LOGIN_ERROR(-104, "用户未登录");

    private int code;
    private String description;

    private BizRetCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public static BizRetCode parse(Integer value) {
        if (value != null) {
            BizRetCode[] array = values();
            BizRetCode[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                BizRetCode each = var2[var4];
                if (value == each.code) {
                    return each;
                }
            }
        }

        return null;
    }
}
