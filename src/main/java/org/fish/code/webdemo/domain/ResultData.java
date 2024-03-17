package org.fish.code.webdemo.domain;


import lombok.Data;

@Data
public class ResultData<T> {
    private Integer code;
    private String message;
    private T data;



    public ResultData<T> createOne(T data) {
        ResultData resultData = new ResultData();
        resultData.setCode(200);
        resultData.setMessage("success");
        resultData.setData(data);
        return resultData;
    }

    public static ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(200);
        resultData.setMessage("success");
        resultData.setData(data);
        return resultData;
    }
}
