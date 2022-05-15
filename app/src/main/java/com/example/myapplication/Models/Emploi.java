package com.example.myapplication.Models;

public class Emploi {
    private String idDoc;
    private String annee;
    private String semestre;
    private String periode;
    private String semaine;
    private String date;

    public Emploi() {
    }

    public String getIdDoc() {
        return idDoc;
    }

    public String getAnnee() {
        return annee;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getPeriode() {
        return periode;
    }

    public String getSemaine() {
        return semaine;
    }

    public String getDate() {
        return date;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public void setSemaine(String semaine) {
        this.semaine = semaine;
    }

    public void setDate(String date) {
        this.date = date;
    }

}