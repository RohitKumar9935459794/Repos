package com.dgdgjfm.l.reposproject.model;

public class Add_Asset {
    String Asset_Capacity,Asset_Name,card,location;

    public Add_Asset() {
    }

    public Add_Asset(String Asset_Capacity,String Asset_Name, String Dj_card, String location){
        this.Asset_Capacity=Asset_Capacity;
        this.Asset_Name=Asset_Name;
        this.card=Dj_card;
        this.location=location;
    }

    public Add_Asset(String Asset_Capacity, String Asset_name){
        this.Asset_Name=Asset_name;
        this.Asset_Capacity=Asset_Capacity;
    }



}
