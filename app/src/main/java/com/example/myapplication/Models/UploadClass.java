package com.example.myapplication.Models;

// Pour gestion d'emploi
public class UploadClass {
    public String name1;
    public String url;


    public UploadClass()
    {

    }

    public UploadClass(String name1, String url) {
        this.name1 = name1;
        this.url = url;
    }


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
