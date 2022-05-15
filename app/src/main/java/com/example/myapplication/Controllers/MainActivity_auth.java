package com.example.myapplication.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity_auth extends AppCompatActivity {

    LinearLayout btnLogOut;
    LinearLayout btnCrudEtudiant;
    LinearLayout btnCrudProfesseur,btnEmploi,btnMail;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_accueil);

          btnLogOut = findViewById(R.id.btnLogout);
          btnCrudEtudiant = findViewById(R.id.btnCRUDEtudiant);
          btnCrudProfesseur = findViewById(R.id.btnCrudProfesseur);
          btnEmploi = findViewById(R.id.emploiTemp);
          btnMail = findViewById(R.id.MaiLMonitoring);
         mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity_auth.this, LoginActivity.class));
        });

        btnCrudEtudiant.setOnClickListener(view ->{

            startActivity(new Intent(MainActivity_auth.this, Activity_CRU.class));
        });
        btnCrudProfesseur.setOnClickListener(view ->{

            startActivity(new Intent(MainActivity_auth.this, Activity_CRU_P.class));
        });
        btnEmploi.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity_auth.this, GestionEmploi.class));
        });
        btnMail.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity_auth.this, InboxActivity.class));
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity_auth.this, LoginActivity.class));
         }
        TextView txt_user = findViewById(R.id.user_id);
        txt_user.setText(user.getEmail());
    }
}