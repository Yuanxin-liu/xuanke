package com.xuanke1.bean;

public class D {
    private String yxh;
    private String mc;
    private String dz;
    private String lxdh;

    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Override
    public String toString() {
        return "D{" +
                "yxh='" + yxh + '\'' +
                ", mc='" + mc + '\'' +
                ", dz='" + dz + '\'' +
                ", lxdh='" + lxdh + '\'' +
                '}';
    }
}
