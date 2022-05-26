package com.example.edu_end.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result{
    private int code;
    private String message;
    private Object data;

    public static Result error(String message){
        return new Result(500,message,null);
    }

    public static Result noLogin(){
        return new Result(401,"请先登录",null);
    }

    public static Result success(Object data){
        return new Result(200,"success",data);
    }
}
