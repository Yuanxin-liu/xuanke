package com.xuanke1.bean;

public class C {
    private String kh;
    private String km;
    private int xf;
    private int xs;
    private String yxh;
    private String mc;

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    public int getXs() {
        return xs;
    }

    public void setXs(int xs) {
        this.xs = xs;
    }

    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }

    @Override
    public String toString() {
        return "C{" +
                "kh='" + kh + '\'' +
                ", km='" + km + '\'' +
                ", xf=" + xf +
                ", xs=" + xs +
                ", yxh='" + yxh + '\'' +
                ", mc='" + mc + '\'' +
                '}';
    }
}
