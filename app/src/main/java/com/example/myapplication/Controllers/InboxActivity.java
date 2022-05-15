package com.example.myapplication.Controllers;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.myapplication.Adapters.InboxAdapter;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class InboxActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseFirestore ff;
    FloatingActionButton fab;
//    List<QueryDocumentSnapshot> messages;
//    TableLayout msgs_table;

    RecyclerView rv_inbox_messages;
    ArrayList<QueryDocumentSnapshot> messages = new ArrayList<>();
    InboxAdapter inboxAdapter;

    public void goToNewMsgAct(View v) {
        Log.d("clicksend","i'm here");
        startActivity(new Intent(InboxActivity.this, Activity_Message.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        auth = FirebaseAuth.getInstance();
        ff = FirebaseFirestore.getInstance();

        rv_inbox_messages = (RecyclerView) findViewById(R.id.rv_inbox_messages);
//        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
////        fab.bringToFront();
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("clicksend","i'm here");
//                startActivity(new Intent(InboxActivity.this, NewMsgActivity.class));
//            }
//        });

        getMessages();

        inboxAdapter = new InboxAdapter(messages,auth);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        rv_inbox_messages.setHasFixedSize(true);
        rv_inbox_messages.setLayoutManager(lm);
        rv_inbox_messages.setAdapter(inboxAdapter);

//        Log.d("recycling","this is proflistactivity");
//        msgs_table = (TableLayout) findViewById(R.id.table_de_messages);
    }
//    public void populateTable() {
//        int i = 0;
//        for (QueryDocumentSnapshot msg: messages) {
//            populateRow(i); i++;
//        }
//    }
//    public void populateRow(int pos) {
////        ConstraintLayout cLayout = new ConstraintLayout(this);
//        TableRow tr = new TableRow(this);
//        TextView tv_sender = new TextView(this);
//        TextView tv_content = new TextView(this);
//        tv_sender.setText(messages.get(pos).get("uid_sender").toString());
//        tv_content.setText(messages.get(pos).get("text").toString());
//        tr.addView(tv_sender);
//        tr.addView(tv_content);
//        msgs_table.addView(tr);
//    }

    public void getMessages() {
        String email = auth.getCurrentUser().getEmail();
        ff.collection("messages")
                .whereEqualTo("uid_sender", email)
                .orderBy("createdAt")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) { Log.w("tryingListener", "Listen failed.", e); return; }

                        for (QueryDocumentSnapshot msg : value) {
                            messages.add(msg);
                        }
                        Log.d("tryingListener", "here is list of messages: " + messages);
                    }
                });
        ff.collection("messages")
                .whereEqualTo("uid_receiver", email)
                .orderBy("createdAt")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) { Log.w("tryingListener", "Listen failed.", e); return; }

                        for (QueryDocumentSnapshot msg : value) { messages.add(msg); }

                        Log.d("tryingListener", "here is list of messages: " + messages);
                        inboxAdapter.updateContent(messages);
                    }
                });
    }


}
