package com.example.mydesign.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mydesign.R;
import com.example.mydesign.model.UserStart;

public class OpenScreen extends AppCompatActivity {

    private Button admin;
    private Button user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_screen);
        admin = findViewById(R.id.admin_btn);
        user= findViewById(R.id.user_btn);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OpenScreen.this, SupplierStart.class));
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (OpenScreen.this , UserStart.class));
            }
        });
    }
}
