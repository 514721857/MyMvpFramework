package com.example.sgr.mymvpframework.app.bean;

/**
 * Created by Administrator on 2018/1/13/013.
 */


import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class Result<T> {
    public int status;
    public List<T> data;
    public String msg;
}