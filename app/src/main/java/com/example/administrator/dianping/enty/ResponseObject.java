package com.example.administrator.dianping.enty;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class ResponseObject {
    private String msg;
    private int state=1;
    private Object dates;
    private int page;
    private int size;
    private int count;

    public ResponseObject() {
    }

    public ResponseObject(int state, Object dates) {
        this.state = state;
        this.dates = dates;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getDates() {
        return dates;
    }

    public void setDates(Object dates) {
        this.dates = dates;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
