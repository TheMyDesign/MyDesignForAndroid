package com.example.mydesign.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mydesign.R;
import com.example.mydesign.SupplierSignIn;
import com.example.mydesign.SupplierSignUp;

public class SupplierStart extends AppCompatActivity {

    private Button sign_up; // for new user
    private Button sign_in; // for exist user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_start);
        sign_up = findViewById(R.id.sign_up);
        sign_in = findViewById(R.id.sign_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupplierStart.this, SupplierSignIn.class));
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupplierStart.this, SupplierSignUp.class));
            }
        });

    }
}
