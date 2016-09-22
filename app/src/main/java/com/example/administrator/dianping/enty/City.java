package com.example.administrator.dianping.enty;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class City {
    String city_id;
    String city_name;
    String city_sortkey;

    public City() {
    }

    public City(String city_id, String city_name, String city_sortkey) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.city_sortkey = city_sortkey;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_sortkey() {
        return city_sortkey;
    }

    public void setCity_sortkey(String city_sortkey) {
        this.city_sortkey = city_sortkey;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id='" + city_id + '\'' +
                ", city_name='" + city_name + '\'' +
                ", city_sortkey='" + city_sortkey + '\'' +
                '}';
    }
}
