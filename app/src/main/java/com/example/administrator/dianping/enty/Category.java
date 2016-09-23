package com.example.administrator.dianping.enty;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Category {
    private String categoryId;
    private int categoryNum;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryNum=" + categoryNum +
                '}';
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(int categoryNum) {
        this.categoryNum = categoryNum;
    }
}
