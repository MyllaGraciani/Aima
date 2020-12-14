package com.ai.app.aima.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    private static DatabaseReference refFirebase;
    private static FirebaseAuth refAutenticar;

    //para retornar a ref do database
    public static DatabaseReference getRefFirebase(){
        if (refFirebase == null){
            refFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return refFirebase;
    }


    //para retornar a instancia do firebaseauth
    public static FirebaseAuth getRefAutenticar(){
        if (refAutenticar == null){
            refAutenticar = FirebaseAuth.getInstance();
        }
        return refAutenticar;
    }
}
