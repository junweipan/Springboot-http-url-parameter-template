package com.junwei.entity;

import lombok.Data;

@Data
public class ResultData<T> {
    /** result status*/
    private int status;
    private String message;
    private T data;
    private long timestamp ;

    public ResultData (){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC200.getCode());
        resultData.setMessage(ReturnCode.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <t> ResultData<t> fail(int code, String message) {
        ResultData<t> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
    public enum ReturnCode {

        /**fail**/
        RC999(999,"some error"),
        /**success**/
        RC200(200,"data return successfully");

        /**custom code**/
        private final int code;
        /**custom message**/
        private final String message;

        ReturnCode(int code, String message){
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}

