package com.guinong.net.utils;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/7/31 0031 on 上午 10:31
 * @desc
 */
public class LoginResponse implements Serializable{

    private ResultBean result;
    private boolean success;
    private ErrorBean error;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ResultBean {


        /**
         * head : Basic
         * header : Authorization
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1MTY4NjY5ODgsImp0aSI6IjE4NWU2NWJjNDA1ODE4ODBjNGYyYzgyOTU4ZGU4Y2ZlXzA2Y2JhNDM2ODFmNzQyMmNhZjViNDdlYTg4NDA2NDczIn0.aUucwJ7RqrOq7VmgIrnsOqHGKqd2w7R4w75aLXTf-ok
         */

        private String head;
        private String header;
        private String token;

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }



    }

    public static class ErrorBean {
        /**
         * code : 103
         * message : 用户名或密码错误
         * details :
         */

        private String code;
        private String message;
        private String details;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}
