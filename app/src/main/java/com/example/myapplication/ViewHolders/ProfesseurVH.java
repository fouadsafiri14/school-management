package com.example.myapplication.ViewHolders;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ProfesseurVH extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_prenom,txt_email,txt_option;
    public ImageView student_photo;
    public ProfesseurVH(@NonNull View itemView)
    {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_prenom = itemView.findViewById(R.id.txt_prenom);
        txt_email = itemView.findViewById(R.id.txt_email);
        txt_option = itemView.findViewById(R.id.txt_option);
        student_photo = (ImageView) itemView.findViewById(R.id.img_user);
    }
}
