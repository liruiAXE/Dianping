package com.example.administrator.dianping.enty;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Goods {
    private Shop shop;
    private String title;
    private String short_title;
    private int value;
    private int price;
    private int sum;
    private String image_url;

    public Goods() {
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "shop=" + shop +
                ", title='" + title + '\'' +
                ", short_title='" + short_title + '\'' +
                ", value=" + value +
                ", price=" + price +
                ", sum=" + sum +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
