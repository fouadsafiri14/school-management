//package com.example.myapplication.DAO;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapplication.DAO.MatiereFirestoreManager;
//import com.example.myapplication.Models.Matiere;
//import com.example.myapplication.R;
//
//
//public class MatiereDetailsActivity extends AppCompatActivity{
//    /* Constants to define the database operation type */
//    public static final String OPERATION = "OPERATION";
//    public static final String CREATING = "CREATING";
//    public static final String EDITING = "EDITING";
//    // Document ID
//    public static final String DOCUMENT_ID = "document_id";
//
//    // Document field names
//    public static final String FIELD_NAME_MATIERE = "nomMatiere";
//    public static final String FIELD_PROF = "prof";
//    public static final String FIELD_SEMESTRE = "semestre";
//    public static final String FIELD_PERIODE = "periode";
//
//    private String operationTypeString;
//
//    /* Repository reference */
//    private MatiereFirestoreManager matiereFirestoreManager;
//
//
//    /* Document ID of this particular Contact item */
//    private String documentId;
//
//    /* Widgets */
//    private EditText nomMatiereEditText;
//    private EditText profEditText;
//    private EditText semestreEditText;
//    private EditText periodeEditText;
//
//    private Button deleteButton;
//    private Button okButton;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.matiere_form_activity);
//
//        // Get a reference of contactsFirestoreManager
//        // TODO: 4.1 Creating a Contact
//
//        // Get a reference of ContactsFirestoreManager
//        matiereFirestoreManager = MatiereFirestoreManager.newInstance();
//
//        nomMatiereEditText = findViewById(R.id.nomMatiereEditText);
//        profEditText = findViewById(R.id.profEditText);
//        semestreEditText = findViewById(R.id.semestreEditText);
//        periodeEditText = findViewById(R.id.periodeEditText);
//
//        deleteButton = findViewById(R.id.deleteButton);
//        deleteButton.setOnClickListener(new DeleteButtonOnClickListener());
//
//        okButton = findViewById(R.id.okButton);
//        okButton.setOnClickListener(new OKButtonOnClickListener());
//
//        // Get the extras from the Intent
//        Bundle bundle = getIntent().getExtras();
//
//        operationTypeString = bundle.getString(OPERATION);
//        if (operationTypeString.equals(CREATING)) {
//            okButton.setText("CREATE");
//            deleteButton.setVisibility(View.GONE);
//
//        } else if (operationTypeString.equals(EDITING)) {
//            okButton.setText("UPDATE");
//            deleteButton.setVisibility(View.VISIBLE);
//
//            // TODO: 4.2 Updating a Contact
//            documentId = bundle.getString(DOCUMENT_ID);
//            nomMatiereEditText.setText(bundle.getString(FIELD_NAME_MATIERE));
//            profEditText.setText(bundle.getString(FIELD_PROF));
//            semestreEditText.setText(bundle.getString(FIELD_SEMESTRE));
//            periodeEditText.setText(bundle.getString(FIELD_PERIODE));
//        }
//    }
//
//    private class OKButtonOnClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//
//            String nomMatiere = nomMatiereEditText.getText().toString();
//            String prof = profEditText.getText().toString();
//            String semestre = semestreEditText.getText().toString();
//            String periode = periodeEditText.getText().toString();
//            Matiere matiere = new Matiere(nomMatiere, prof, semestre,periode);
//            if (operationTypeString.equals(CREATING)) {
//                matiereFirestoreManager.createDocument(matiere);
//            } else if (operationTypeString.equals(EDITING)) {
//
//                matiereFirestoreManager.updateMatiere(matiere);
//            }
//            finish();
//
//        }
//    }
//
//
//    private class DeleteButtonOnClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//
//            // TODO: 4.3 Deleting a Contact
//
//            matiereFirestoreManager.deleteMatiere(documentId);
//
//            finish();
//        }
//    }
//}
