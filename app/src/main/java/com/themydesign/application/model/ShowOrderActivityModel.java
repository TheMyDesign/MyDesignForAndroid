package com.example.mydesign.model;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ShowOrderActivityModel {
    private FirebaseFirestore _store;
    private ArrayList<String> _image_list;
    private ArrayList<String[]> _info;

    public ShowOrderActivityModel(FirebaseFirestore store) {
        this._store = store;
        _image_list = new ArrayList<>();
        _info = new ArrayList<>();
    }

    public ArrayList<String> get_image_list() {
        System.out.printf("get_image_list Show Order " + _image_list.toString());
        return _image_list;
    }

    public ArrayList<String[]> get_info() {
        System.out.printf("get info Show Order " + _info.toString());
        return _info;
    }

    public ArrayList<String> getAdminOrders() {
        ArrayList<String> image_list = new ArrayList<>();
        ArrayList<String[]> info = new ArrayList<>();

        this._store.collection("Admins").document(FirebaseAuth.getInstance()
                .getCurrentUser().getUid()).collection("Order").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.contains("Bid")) {
                            String bid = document.get("Bid").toString();
                            String description = document.get("Description").toString();
                            String file = document.get("File Name").toString();
                            String user_name = document.get("Name").toString();
                            String email = document.get("Email").toString();
                            String url = document.get("URL").toString();
                            String order_state = document.get("Order State").toString();
                            String[] user_details = {user_name, email, "Product Name - " + file, "Description - " + description, "Price - " + bid, order_state};
                            image_list.add(url);
                            info.add(user_details);
                        } else {
                            String quantity = document.get("Quantity").toString();
                            String size = document.get("SIZE").toString();
                            String user_name = document.get("Name").toString();
                            String email = document.get("User Email").toString();
                            String total_price = document.get("Total Price").toString();
                            String url = document.get("URL").toString();
                            String order_state = document.get("Order State").toString();
                            String[] user_details = {user_name, email, "Quantity - " + quantity,
                                    "Size - " + size, "Total price - " + total_price, order_state};
                            image_list.add(url);
                            info.add(user_details);
                        }
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

        this._image_list = image_list;
        this._info = info;
        return image_list;
    }
}

