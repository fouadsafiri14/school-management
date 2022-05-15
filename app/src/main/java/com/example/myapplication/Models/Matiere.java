package com.example.myapplication.Models;
import com.google.firebase.firestore.DocumentId;

public class Matiere {

    // TODO: 2.1 Defining the Data Model

    @DocumentId
    private String documentId;
    private String nomMatiere;
    private String prof;
    private String semestre;
    private String periode;

    public Matiere() {}
    public Matiere(String nomMatiere, String prof, String semestre, String periode) {
        this.nomMatiere = nomMatiere;
        this.prof = prof;
        this.semestre = semestre;
        this.periode= periode;
    }
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
}