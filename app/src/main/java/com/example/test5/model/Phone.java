package com.example.test5.model;

import com.google.gson.annotations.SerializedName;

public class Phone {

    @SerializedName("mobile")
    public String mobile;
    @SerializedName("home")
    public String home;
    @SerializedName("office")
    public String office;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
