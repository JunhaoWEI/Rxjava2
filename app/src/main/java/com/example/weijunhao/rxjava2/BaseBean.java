package com.example.weijunhao.rxjava2;

/**
 * Created by weijunhao on 2017/8/5.
 */

public class BaseBean<T> {
    private int sratus;
    private String message;
    private T t;

    public int getSratus() {
        return sratus;
    }

    public void setSratus(int sratus) {
        this.sratus = sratus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
