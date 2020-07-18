package com.aaa.status;

/**
 * @author xxx
 * @description
 * @DATE 2020/7/9
 * @return
*/
public enum LoginStatus {

    LOGIN_SUCCESS("200", "登录成功"),
    LOGIN_FAILED("400", "登录失败，系统异常"),
    USER_EXIST("201", "用户已经存在"),
    USER_NOT_EXIST("401", "用户不存在"),
    PASSWORD_WRONG("402", "密码错误"),
    LOGOUT_WRONG("405", "用户退出异常"),
    SYSTEM_EXCEPTION("406", "系统异常"),
    UPDATE_FAILED("10010" ,"更新失败"),
    UPDATE_SUCCESS("10009","更新成功" ),
    QUERY_SUCCESS("10011","查询成功" ),
    QUERY_FALSE("10012","查询失败" ),
    INSERT_SUCCESS("10013","添加成功"),
    UPLOAD_SUCCESS("20005", "文件上传成功"),
    UPLOAD_FAILED("10005", "文件上传失败"),
    INSERT_FALSE("10014","添加失败");

    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
