package com.example.myapplication.Controllers;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.Models.UploadClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

// Pour la gestion d'emploi
public class ViewAllpdfFiles extends AppCompatActivity {
    ListView mypdflistview;
    DatabaseReference databaseReference;
    List<UploadClass> uploadclasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_allpdf_files);

        mypdflistview=(ListView) findViewById(R.id.mylistview);
        uploadclasses =new ArrayList<>();

        viewAllpdfFiles();
        mypdflistview.setOnItemClickListener((adapterView, view, i, l) -> {
            UploadClass uploadclass = uploadclasses.get(i);
            System.out.println(uploadclass.getUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uploadclass.getUrl()));
            startActivity(intent);
        });


    }
    private  void viewAllpdfFiles()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapchot : snapshot.getChildren())
                {
                    UploadClass uploadclass= postSnapchot.getValue(UploadClass.class);
                    uploadclasses.add(uploadclass);
                }
                String[]  uploads= new String[uploadclasses.size()];
                for(int i=0;i<uploads.length;i++)
                {
                    uploads[i]=uploadclasses.get(i).getName1();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploads)
                {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View v= super.getView(position,convertView ,parent);
                        TextView mytest =(TextView) v.findViewById(android.R.id.text1);
                        mytest.setTextColor(Color.BLACK);
                        return v;
                    }
                };
                mypdflistview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}