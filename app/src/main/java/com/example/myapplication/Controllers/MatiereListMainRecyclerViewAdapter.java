//package com.example.myapplication.Controllers;
//import android.annotation.SuppressLint;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.DAO.MatiereFirestoreManager;
//import com.example.myapplication.Models.Matiere;
//import com.example.myapplication.R;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.List;
//public class MatiereListMainRecyclerViewAdapter extends RecyclerView.Adapter<MatiereListMainRecyclerViewAdapter.ViewHolder> {
//
//    private List matiereList;
//    private MatiereFirestoreManager messageManager = MatiereFirestoreManager.newInstance();
//
//    private MatiereListMainActivity.MatiereListRecyclerViewOnItemClickListener matiereListRecyclerViewOnItemClickListener;
//
//    public MatiereListMainRecyclerViewAdapter(List matiereList, MatiereListMainActivity.MatiereListRecyclerViewOnItemClickListener matiereListRecyclerViewOnItemClickListener) {
//        this.matiereList = matiereList;
//        this.matiereListRecyclerViewOnItemClickListener = matiereListRecyclerViewOnItemClickListener;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.matiere_item_cardview, parent, false);
//        itemView.setOnClickListener(matiereListRecyclerViewOnItemClickListener);
//
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
//
//        Matiere matiere = (Matiere) matiereList.get(position);
//
//        // Populate user interface
//        viewHolder.nomMatiereTextView.setText(matiere.getNomMatiere());
//        viewHolder.profTextView.setText( matiere.getProf());
//        viewHolder.semestreTextView.setText(matiere.getSemestre());
//        viewHolder.periodeTextView.setText(matiere.getPeriode());
//        viewHolder.fab.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                messageManager.deleteMatiere(matiere.getDocumentId());
//                matiereList.remove(position);  // remove the item from list
//
//                notifyItemRemoved(position); // notify the adapter about the removed item
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return matiereList.size();
//    }
//
//    /** ViewHolder pattern: Inner class needed to keep the references between widgets and data to improve the performance */
//    static class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView nomMatiereTextView;
//        TextView profTextView;
//        TextView semestreTextView;
//        TextView periodeTextView;
//        private FloatingActionButton fab ;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//
//            nomMatiereTextView = itemView.findViewById(R.id.nomMatiereTextView);
//            profTextView = itemView.findViewById(R.id.profTextView);
//            semestreTextView = itemView.findViewById(R.id.semestreTextView);
//            periodeTextView = itemView.findViewById(R.id.periodeTextView);
//            fab = itemView.findViewById(R.id.floatingActionButton2);
//        }
//    }
//}
//
