//package com.example.myapplication.DAO;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QuerySnapshot;
//
//public class MatiereFirestoreManager {
//    private static final String COLLECTION_NAME = "matieres";
//
//    // TODO: 2.3 Creating a Database Manager
//
//    /* ContactsFirestoreManager object **/
//    private static MatiereFirestoreManager matiereFirestoreManager;
//
//
//    public static MatiereFirestoreManager newInstance() {
//        if (matiereFirestoreManager == null) {
//            matiereFirestoreManager = new MatiereFirestoreManager();
//        }
//        return matiereFirestoreManager;
//    }
//
//    /* Firestore objects */
//    private FirebaseFirestore firebaseFirestore;
//    private CollectionReference matieresCollectionReference;
//
//    private MatiereFirestoreManager() {
//        firebaseFirestore = FirebaseFirestore.getInstance();
//        matieresCollectionReference = firebaseFirestore.collection(COLLECTION_NAME);
//    }
//
//
//    public void createDocument(Matiere matiere) {
//        matieresCollectionReference.add(matiere);
//    }
//
//    public void getAllMatieres(OnCompleteListener<QuerySnapshot> onCompleteListener)
//    {
//        matieresCollectionReference.get().addOnCompleteListener(onCompleteListener);
//    }
//
//    public void updateMatiere(Matiere matiere) {
//        String documentId = matiere.getDocumentId();
//        DocumentReference documentReference = matieresCollectionReference.document(documentId);
//        documentReference.set(matiere);
//
//
//
//    }
//
//    public void deleteMatiere(String documentId) {
//        DocumentReference documentReference = matieresCollectionReference.document(documentId);
//        documentReference.delete();
//    }
//
//    public void sendMatieresBulk() {
//
//        // Create a new Contact document map of values and add it to the collection
//        createDocument(new Matiere("unity", "nafil", "4", "2"));
//
//        // Create a new Contact document map of values and add it to the collection
//        createDocument(new Matiere("test", "Johnson", "m_johnson@gmail.com", "test"));
//    }
//}