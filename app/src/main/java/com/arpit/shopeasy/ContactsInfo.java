package com.arpit.shopeasy;

public class ContactsInfo {
    private String displayName;
    private String status;
    private String date;
    private String imgUrl;

    public ContactsInfo(String displayName, String status, String date) {
        this.displayName = displayName;
        this.status = status;
        this.date = date;
//        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }

    public String getStatus() {
        return status;
    }

//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getDate() {
        return date;
    }

//    public void setDate(String date) {
//        this.date = date;
//    }
}
