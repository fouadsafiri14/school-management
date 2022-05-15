package com.example.myapplication.DAO;

import com.example.myapplication.Models.Professeur;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOProfesseur
{
    private DatabaseReference databaseReference;
    public DAOProfesseur()
    {
        FirebaseDatabase db =FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Professeur.class.getSimpleName());
    }
    public Task<Void> add(Professeur professeur)
    {
        return databaseReference.push().setValue(professeur);
    }

    public Task<Void> update(String key, HashMap<String ,Object> hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue();
    }

    public Query get(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Query get()
    {
        return databaseReference;
    }

    public Query getP(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByChild("role").equalTo("PROFESSOR").limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).orderByChild("role").equalTo("PROFESSOR").limitToFirst(8);
    }
    public Query getPP(String key)
    {
        if(key == null)
        {
            Query  data = databaseReference.orderByKey().limitToFirst(8);


        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }
}
