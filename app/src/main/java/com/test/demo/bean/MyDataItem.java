package com.test.demo.bean;

import java.io.Serializable;

/**
 * Created by gumenghao on 17/5/23.
 */

public class MyDataItem implements Serializable {

    private String tital;


    public MyDataItem() {
    }

    public MyDataItem(String tital) {
        this.tital = tital;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }


    @Override
    public String toString() {
        return "MyDataItem{" +
                "tital='" + tital + '\'' +
                '}';
    }
}
