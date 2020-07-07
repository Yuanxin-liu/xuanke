package com.xuanke1.bean;

public class E {
    private String xh;
    private String xm;
    private String xq;
    private String kh;
    private String gh;
    private float pscj;
    private float kscj;

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    private float zpcj;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public float getPscj() {
        return pscj;
    }

    public void setPscj(float pscj) {
        this.pscj = pscj;
    }

    public float getKscj() {
        return kscj;
    }

    public void setKscj(float kscj) {
        this.kscj = kscj;
    }

    public float getZpcj() {
        return zpcj;
    }

    public void setZpcj(float zpcj) {
        this.zpcj = zpcj;
    }

    @Override
    public String toString() {
        return "E{" +
                "xh='" + xh + '\'' +
                ", xm='" + xm + '\'' +
                ", xq='" + xq + '\'' +
                ", kh='" + kh + '\'' +
                ", gh='" + gh + '\'' +
                ", pscj=" + pscj +
                ", kscj=" + kscj +
                ", zpcj=" + zpcj +
                '}';
    }
}
