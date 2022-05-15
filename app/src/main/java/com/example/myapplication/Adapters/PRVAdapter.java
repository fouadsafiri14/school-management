package com.example.myapplication.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Controllers.Activity_CRU_P;
import com.example.myapplication.DAO.DAOProfesseur;
import com.example.myapplication.Models.Professeur;
import com.example.myapplication.ViewHolders.ProfesseurVH;
import com.example.myapplication.R;

import java.util.ArrayList;

public class PRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Professeur> list = new ArrayList<>();
    public PRVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Professeur> professeur)
    {
        list.addAll(professeur);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ProfesseurVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Professeur e = null;
        this.onBindViewHolder(holder,position,e);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, Professeur e)
    {
        ProfesseurVH vh = (ProfesseurVH)  holder;
        Professeur professeur = e==null? list.get(position):e;
        vh.txt_name.setText(professeur.getName());
        vh.txt_prenom.setText(professeur.getPrenom());
        vh.txt_email.setText(professeur.getEmail());
        Glide.with(context).load(professeur.getImg()).into(vh.student_photo);

        vh.txt_option.setOnClickListener(v->
        {
            PopupMenu popupMenu =new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item->
            {
                switch (item.getItemId())
                {
                    case R.id.menu_edit:
                        Intent intent=new Intent(context, Activity_CRU_P.class);
                        intent.putExtra("EDIT", professeur);
                        context.startActivity(intent);
                        ((Activity) context).finish();

                        break;
                    case R.id.menu_remove:
                        DAOProfesseur dao=new DAOProfesseur();
                        dao.remove(professeur.getKey()).addOnSuccessListener(suc->
                        {
                            Toast.makeText(context, "Record is removed", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                            list.remove(professeur);
                        }).addOnFailureListener(er->
                        {
                            Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                        });

                        break;
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
