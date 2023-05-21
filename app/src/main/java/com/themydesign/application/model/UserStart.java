package com.example.mydesign.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mydesign.R;
import com.example.mydesign.controler.UserStartController;

public class UserStart extends AppCompatActivity implements View.OnClickListener {
    private UserStartController userStartController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_start);

        // Initialize the userController
        userStartController = new UserStartController(this);

        // Set click listeners for the login and signup buttons
        findViewById(R.id.sign_up).setOnClickListener(this);
        findViewById(R.id.sign_in).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up:
                // Start the UserSignUp activity
                userStartController.startSignUpActivity();
                break;
            case R.id.sign_in:
                // Start the UserSignIn activity
                userStartController.startSignInActivity();
                break;
            default:
                break;
        }
    }
}
