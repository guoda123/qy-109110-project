package com.aaa.base;

import static com.aaa.status.LoginStatus.*;
import static com.aaa.status.OperationStatus.*;

public class BaseController {

    /**
     * @author xxx
     * @description
     *      登录成功
     *      使用系统消息
     * @date 2020/7/8
     * @return
    **/
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      登录成功
     *      自定义返回消息
     * @date 2020/7/8
     * @return
     **/
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      登录成功
     *      返回数据信息，使用系统消息
     * @date 2020/7/8
     * @return
     **/
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      登录成功
     *      返回数据信息，自定义消息
     * @date 2020/7/8
     * @return
     **/
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      登录失败，使用系统消息
     * @date 2020/7/8
     * @return
    **/
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      登录失败，使用系统消息，详细解释说明
     * @date 2020/7/8
     * @return
     **/
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      操作成功，返回系统消息
     * @date 2020/7/9
     * @return
    **/
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      操作失败，返回系统消息
     * @date 2020/7/9
     * @return
     **/
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      用户已经存在，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      用户不存在，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return  resultData;
    }

    /**
     * @author xxx
     * @description
     *      密码错误，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData passwordRrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      用户退出异常，返回系统信息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData logoutWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      删除操作
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData deleteOperation(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      修改操作
     * @DATE 2020/7/9
     * @return
    */
    protected  ResultData updateOperation(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      新增操作
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData insertOperation(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      路由过滤成功，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData zuulFilterSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      路由过滤失败，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData zuulFilterFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      token值存在，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData zuulFilterTokenSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      token值不存在，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData zuulFilterTokenFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      request对象为null，返回系统消息
     * @DATE 2020/7/9
     * @return
    */
    protected ResultData requestIsNull(){
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      新增成功
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData insertSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @author xxx
     * @description
     *      新增失败
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData insertFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FALSE.getCode());
        resultData.setMsg(INSERT_FALSE.getMsg());
        return resultData;
    }
    /**
     * @author xxx
     * @description
     *      更新成功
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData updateSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @author xxx
     * @description
     *      更新失败
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData updateFalse() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /**
     * @author xxx
     * @description
     *      查询成功，使用系统消息，自定义返回值
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData getSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(QUERY_SUCCESS.getCode());
        resultData.setMsg(QUERY_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @author xxx
     * @description
     *      查询失败
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData getFalse() {
        ResultData resultData = new ResultData();
        resultData.setCode(QUERY_FALSE.getCode());
        resultData.setMsg(QUERY_FALSE.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      文件上传成功，返回系统消息
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData uploadSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPLOAD_SUCCESS.getCode());
        resultData.setMsg(UPLOAD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author xxx
     * @description
     *      文件上传失败，返回系统消息
     * @DATE 2020/7/16
     * @return
    */
    protected ResultData uploadFalse() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPLOAD_FAILED.getCode());
        resultData.setMsg(UPLOAD_FAILED.getMsg());
        return resultData;
    }
}
