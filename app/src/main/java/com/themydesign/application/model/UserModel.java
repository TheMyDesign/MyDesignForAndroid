package com.example.mydesign.model;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
    private FirebaseFirestore store;
    public FirebaseAuth mAuth;

    public UserModel() {
        store = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
    }

    public void registerUser(String username, String name, String email, String password,
                             OnSuccessListener<AuthResult> successListener,
                             OnFailureListener failureListener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(successListener)
                .addOnFailureListener(failureListener);
    }

    public void saveUserInfo(String userId, String username, String name, String email) {
        DocumentReference df = store.collection("Users").document(userId);
        Map<String, Object> user_info = new HashMap<>();
        user_info.put("User Name", username);
        user_info.put("Name", name);
        user_info.put("Email", email);
        df.set(user_info);
    }
}
