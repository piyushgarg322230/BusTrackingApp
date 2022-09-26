package com.example.bus_tracking_app;

public class HelperClass {
    String userN,reId,eId,mobileN,passW,rerturnPass;
    public HelperClass() {

    }

    public HelperClass(String userN, String reId, String eId, String mobileN, String passW, String rerturnPass) {
        this.userN = userN;
        this.reId = reId;
        this.eId = eId;
        this.mobileN = mobileN;
        this.passW = passW;
        this.rerturnPass = rerturnPass;
    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }

    public String getReId() {
        return reId;
    }

    public void setReId(String reId) {
        this.reId = reId;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getMobileN() {
        return mobileN;
    }

    public void setMobileN(String mobileN) {
        this.mobileN = mobileN;
    }

    public String getPassW() {
        return passW;
    }

    public void setPassW(String passW) {
        this.passW = passW;
    }

    public String getRerturnPass() {
        return rerturnPass;
    }

    public void setRerturnPass(String rerturnPass) {
        this.rerturnPass = rerturnPass;
    }
}
