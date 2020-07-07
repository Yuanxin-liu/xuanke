package com.xuanke1.bean;

public class O {
    private String kh;
    private String km;
    private String gh;
    private String xm;
    private String mc;
    private int xf;
    private String sksj;
    private String xq;

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

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    @Override
    public String toString() {
        return "O{" +
                "kh='" + kh + '\'' +
                ", km='" + km + '\'' +
                ", gh='" + gh + '\'' +
                ", xm='" + xm + '\'' +
                ", xymc='" + mc + '\'' +
                ", xf=" + xf +
                ", sksj='" + sksj + '\'' +
                ", xq='" + xq + '\'' +
                '}';
    }
}
