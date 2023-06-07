package com.example.mydesign.controler;

import android.content.Context;
import android.content.Intent;

import com.example.mydesign.UserSignIn;

public class UserStartController {
    private final Context context;

    public UserStartController(Context context) {
        this.context = context;
    }

    public void startSignUpActivity() {
        // Start the UserSignUp activity with the CLEAR_TASK and CLEAR_TOP flags
        Intent intent = new Intent(context, com.example.mydesign.UserSignUp.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void startSignInActivity() {
        // Start the UserSignIn activity with the CLEAR_TASK and CLEAR_TOP flags
        Intent intent = new Intent(context, UserSignIn.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}


