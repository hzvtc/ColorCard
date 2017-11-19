package com.mytest.colorcard;

import android.graphics.Color;

/**
 * Created by FJQ on 2017/11/19.
 */

public class ColorSample {
    private String rgb;
    private String color;
    private String category;
    private int val;

    public ColorSample(String rgb, String color, String category) {
        this.rgb = rgb;
        this.color = color;
        this.category = category;
        this.val = Color.parseColor(rgb);
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
