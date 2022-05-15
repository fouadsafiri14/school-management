package com.example.myapplication.DAO;

public class MatiereFirestoreDbMatiere {
    // TODO: 2.2 Defining the Database Contract


    // Root collection name
    public static final String COLLECTION_NAME = "matieres";

    // Document ID
    public static final String DOCUMENT_ID = "document_id";

    // Document field names
    public static final String FIELD_NAME_MATIERE = "nomMatiere";
    public static final String FIELD_PROF = "prof";
    public static final String FIELD_SEMESTRE = "semestre";
    public static final String FIELD_PERIODE = "periode";

    // To prevent someone from accidentally instantiating the contract 		class, make the constructor private
    private MatiereFirestoreDbMatiere() {}
}
