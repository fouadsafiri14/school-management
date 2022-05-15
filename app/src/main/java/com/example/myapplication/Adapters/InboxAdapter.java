package com.example.myapplication.Adapters;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Date;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.InboxViewHolder> {
    ArrayList<QueryDocumentSnapshot> messages = new ArrayList<>();
    FirebaseAuth auth;
    public InboxAdapter(ArrayList<QueryDocumentSnapshot> messages, FirebaseAuth auth) {
        this.messages = messages;
        this.auth = auth;
    }

    @NonNull @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View theRowItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inbox_row_item,null,false);
        InboxViewHolder viewHolder = new InboxViewHolder(theRowItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {
        QueryDocumentSnapshot msg = messages.get(position);
        if (msg.get("uid_sender").toString().equals(auth.getCurrentUser().getEmail())) {
            holder.sender.setText("You");
        } else {
            holder.sender.setText(msg.get("uid_sender").toString());
        }
        if (msg.get("uid_receiver").toString().equals(auth.getCurrentUser().getEmail())) {
            holder.receiver.setText("You");
        } else {
            holder.receiver.setText(msg.get("uid_receiver").toString());
        }
        holder.content.setText(msg.get("text").toString());
        Date date = ((Timestamp) msg.get("createdAt")).toDate();
        long time = date.getTime();
        long now = System.currentTimeMillis();
        CharSequence ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.FRANCE);
        holder.time.setText(ago);

    }

    @Override
    public int getItemCount() {
        return messages == null ? 0 : messages.size();
    }

    public void updateContent(ArrayList<QueryDocumentSnapshot> messages) {
        this.messages = messages;
        this.notifyDataSetChanged();
    }

    class InboxViewHolder extends RecyclerView.ViewHolder {
        TextView sender , content, time , receiver;
        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.sender);
            content = itemView.findViewById(R.id.content);
            time = itemView.findViewById(R.id.time);
            receiver = itemView.findViewById(R.id.receiver);
        }
    }
}

