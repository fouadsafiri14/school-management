package com.example.myapplication.Controllers;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DAO.DAOProfesseur;
import com.example.myapplication.Models.Professeur;
import com.example.myapplication.R;

import java.util.HashMap;

public class Activity_CRU_P extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_prenom = findViewById(R.id.edit_prenom);
        final EditText edit_email = findViewById(R.id.edit_email);
        final EditText edit_img = findViewById(R.id.img_user);

        Button btn = findViewById(R.id.btn_submit);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v->
        {
            Intent intent =new Intent(Activity_CRU_P.this, PRVActivity.class);
            startActivity(intent);
        });

        DAOProfesseur dao =new DAOProfesseur();
        Professeur user_edit = (Professeur) getIntent().getSerializableExtra("EDIT");
        if(user_edit !=null)
        {
            btn.setText("UPDATE");
            edit_name.setText(user_edit.getName());
            edit_prenom.setText(user_edit.getPrenom());
            edit_email.setText(user_edit.getEmail());
            edit_img.setText(user_edit.getImg());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }
        btn.setOnClickListener(v->
        {
            Professeur professeur = new Professeur(edit_name.getText().toString(), edit_prenom.getText().toString(),edit_email.getText().toString(),"PROFESSOR",edit_img.getText().toString());
            if(user_edit==null)
            {
                dao.add(professeur).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            else
            {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", edit_name.getText().toString());
                hashMap.put("prenom", edit_prenom.getText().toString());
                hashMap.put("email", edit_email.getText().toString());
                hashMap.put("img", edit_img.getText().toString());
                dao.update(user_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, RVActivityP.class));
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

    }
}