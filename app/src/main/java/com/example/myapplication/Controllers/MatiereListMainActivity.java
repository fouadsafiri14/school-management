//package com.example.myapplication.Controllers;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.DAO.MatiereDetailsActivity;
//import com.example.myapplication.DAO.MatiereFirestoreManager;
//import com.example.myapplication.R;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import java.util.List;
//
//
//public class MatiereListMainActivity extends AppCompatActivity{
//    private static String TAG = MatiereListMainActivity.class.toString();
//
//    /* Widgets */
//    private Toolbar toolbar;
//    private RecyclerView matiereListRecyclerView;
//
//    private FloatingActionButton sendBulkDataFloatingButton;
//    private FloatingActionButton addFloatingButton;
//    private TextView emptyTextView;
//
//    /* Content objects */
//    private List<Matiere> matiereList;
//
//    /* Repository reference */
//    private MatiereFirestoreManager matiereFirestoreManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.matiere_list_main_activity);
//
//        // Get a reference of contactsFirestoreManager
//        // TODO: 3.1 Getting the Backend Reference
//        // Get a reference of ContactsFirestoreManager
//        matiereFirestoreManager = MatiereFirestoreManager.newInstance();
//
//        // Set up the toolbar
//
//
//        // Set up the contactListRecyclerView
//        matiereListRecyclerView = findViewById(R.id.matiereListRecyclerView);
//        matiereListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//
//        // Set up the sendBulkDataFloatingButton
//        sendBulkDataFloatingButton = findViewById(R.id.sendBulkDataFloatingButton);
//        sendBulkDataFloatingButton.setOnClickListener(new SendMatieresBulkFloatingButtonOnClickListener());
//
//        // Set up the addFloatingButton
//        addFloatingButton = findViewById(R.id.addFloatingButton);
//        addFloatingButton.setOnClickListener(new AddFloatingButtonOnClickListener());
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        // Populate the ContactListMainActivity with the available data
//        // TODO: 3.3 Reading Contacts
//
//
//        // Populate the ContactListMainActivity with the available data
//        matiereFirestoreManager.getAllMatieres(new GetAllMatieresOnCompleteListener());
//    }
//
//    private class GetAllMatieresOnCompleteListener implements OnCompleteListener<QuerySnapshot> {
//        @Override
//        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//            if (task.isSuccessful()) {
//
//                // Get the query snapshot from the task result
//                QuerySnapshot querySnapshot = task.getResult();
//
//                if (querySnapshot != null) {
//
//                    // Get the contact list from the query snapshot
//                    matiereList = querySnapshot.toObjects(Matiere.class);
//                    // Populate the recycler view with the contact list
//                    populateMatiereRecyclerView(matiereList);
//                }
//
//            } else {
//                Log.w(TAG, "Error getting documents: ", task.getException());
//            }
//        }
//    }
//
////    Uncomment this class...
//   /* private class GetAllContactsOnCompleteListener implements OnCompleteListener<QuerySnapshot> {
////
//        @Override
//        public void onComplete(@NonNull Task<QuerySnapshot> task) {
////
////            // TODO: 3.3 Reading Contacts
////
////            // TODO 3.4 Populating the Main Screen
////          If the contactList is empty, show the emptyTextView. Otherwise, show the contactListRecyclerView
//            if (contactList == null || contactList.size() == 0) {
//                contactListRecyclerView.setVisibility(View.GONE);
//                emptyTextView.setVisibility(View.VISIBLE);
//
//            } else {
//                contactListRecyclerView.setVisibility(View.VISIBLE);
//                emptyTextView.setVisibility(View.GONE);
//            }
//        }
//    }
//*/
//    /** Called when the user clicks on an item of the contact list */
//    public class MatiereListRecyclerViewOnItemClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//
//            /*int itemIndex = matiereListRecyclerView.indexOfChild(view);
//            Log.d("MatiereListMainActivity", "" + itemIndex);
//
//            Matiere matiere = matiereList.get(itemIndex);
//
//            Intent intent = new Intent();
//            intent.setClass(MatiereListMainActivity.this, MatiereDetailsActivity.class);
//            intent.putExtra(MatiereDetailsActivity.OPERATION, MatiereDetailsActivity.EDITING);
//
//             */
//
//            // TODO: 4.2 Updating a Contact
//
//            int itemPosition = matiereListRecyclerView.indexOfChild(view);
//            Matiere matiere = matiereList.get(itemPosition);
//           /* Intent intent = new Intent();
//            intent.setClass(MatiereListMainActivity.this, MatiereDetailsActivity.class);
//            intent.putExtra(MatiereDetailsActivity.OPERATION, MatiereDetailsActivity.EDITING);
//            intent.putExtra(MatiereFirestoreDbMatiere.DOCUMENT_ID, matiere.getDocumentId());
//            intent.putExtra(MatiereFirestoreDbMatiere.FIELD_NAME_MATIERE, matiere.getNomMatiere());
//            intent.putExtra(MatiereFirestoreDbMatiere.FIELD_PROF, matiere.getProf());
//            intent.putExtra(MatiereFirestoreDbMatiere.FIELD_SEMESTRE, matiere.getSemestre());
//            intent.putExtra(MatiereFirestoreDbMatiere.FIELD_PERIODE, matiere.getPeriode());
//            startActivity(intent);*/
//        }
//
//
//    }
//    /** Sets the contact List in the Adapter to populate the RecyclerView */
//    private void populateMatiereRecyclerView(List<Matiere> matiereList) {
//
//        // TODO: 3.4 Populating the Main Screen
//        // Set the contactListMainRecyclerViewAdapter in the contactListRecyclerView
//        MatiereListMainRecyclerViewAdapter matiereListMainRecyclerViewAdapter = new MatiereListMainRecyclerViewAdapter(matiereList, new MatiereListRecyclerViewOnItemClickListener());
//        matiereListRecyclerView.setAdapter(matiereListMainRecyclerViewAdapter);
//    }
//
//
//
//    /** Called when the user clicks the Send Contacts button */
//    private class SendMatieresBulkFloatingButtonOnClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//
//            // TODO: 3.2 Sending Bulk Data to Firestore
//
//            matiereFirestoreManager.sendMatieresBulk();
//            Toast.makeText(MatiereListMainActivity.this, "Contacts bulk sent", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    /** Called when the user clicks the Add button */
//    private class AddFloatingButtonOnClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//
//            Intent intent = new Intent();
//            intent.setClass(MatiereListMainActivity.this, MatiereDetailsActivity.class);
//            intent.putExtra(MatiereDetailsActivity.OPERATION, MatiereDetailsActivity.CREATING);
//
//            startActivity(intent);
//        }
//    }
//}
