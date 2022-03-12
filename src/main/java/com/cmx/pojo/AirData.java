package com.cmx.pojo;

import java.util.Date;

/*
* 空气质量数据类
* id：数据id
* cId：城市id
* time：时间
* pm2_5：PM2.5
* so_2：二氧化硫
* o_3：臭氧
* city：城市数据
* */
public class AirData {
    private int id;
    private int cId;
    private Date time;
    private int pm2_5;
    private double so_2;
    private int o_3;
    private City city;

    @Override
    public String toString() {
        return "AirData{" +
                "id=" + id +
                ", cId=" + cId +
                ", time=" + time +
                ", pm2_5=" + pm2_5 +
                ", so_2=" + so_2 +
                ", o_3=" + o_3 +
                ", city=" + city +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public double getSo_2() {
        return so_2;
    }

    public void setSo_2(double so_2) {
        this.so_2 = so_2;
    }

    public int getO_3() {
        return o_3;
    }

    public void setO_3(int o_3) {
        this.o_3 = o_3;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public AirData() {
    }

    public AirData(int cId, Date time, int pm2_5, double so_2, int o_3, City city) {
        this.cId = cId;
        this.time = time;
        this.pm2_5 = pm2_5;
        this.so_2 = so_2;
        this.o_3 = o_3;
        this.city = city;
    }
}
