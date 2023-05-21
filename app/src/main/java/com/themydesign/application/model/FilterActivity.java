package com.example.mydesign.model;

import com.example.mydesign.controler.FilterActivityController;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydesign.R;

import java.util.HashMap;

public class FilterActivity extends AppCompatActivity {

    public static final String SELECTED_OPTIONS_KEY = "selected_options";

    private boolean[] mSelectedOptions;
    private int[] mSelectedOptionsI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_user_design);

        // Initialize the selected options array
        mSelectedOptions = new boolean[9];
        mSelectedOptionsI = new int[12];

        //initiate a check box
        CheckBox checkbox_pants = (CheckBox) findViewById(R.id.checkbox_pants);
        CheckBox checkbox_mobile = (CheckBox) findViewById(R.id.checkbox_mobile);
        CheckBox checkbox_notebooks = (CheckBox) findViewById(R.id.checkbox_notebooks);
        CheckBox checkbox_office_supplies = (CheckBox) findViewById(R.id.checkbox_Office_Supplies);
        CheckBox checkbox_hats = (CheckBox) findViewById(R.id.checkbox_hats);
        CheckBox checkbox_games = (CheckBox) findViewById(R.id.checkbox_games);
        CheckBox checkbox_clothing = (CheckBox) findViewById(R.id.checkbox_clothing);
        CheckBox checkbox_puzzles = (CheckBox) findViewById(R.id.checkbox_puzzles);
        CheckBox checkbox_toys = (CheckBox) findViewById(R.id.checkbox_toys);

        //initiate sort
        Switch sort_py_price = (Switch) findViewById(R.id.switch_cheapest);

        //initiate the price range
        EditText price_low = (EditText) findViewById(R.id.et_low);
        EditText price_high = (EditText) findViewById(R.id.et_high);

        //initiate the filler button

        Button filter = (Button) findViewById(R.id.button_filter);
        filter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    System.out.println("filter.setOnClickListener");
                    // Create an Intent to return the selected options to the previous activity
                    mSelectedOptions[0] = checkbox_pants.isChecked();
                    mSelectedOptions[1] = checkbox_mobile.isChecked();
                    mSelectedOptions[2] = checkbox_notebooks.isChecked();
                    mSelectedOptions[3] = checkbox_office_supplies.isChecked();
                    mSelectedOptions[4] = checkbox_hats.isChecked();
                    mSelectedOptions[5] = checkbox_games.isChecked();
                    mSelectedOptions[6] = checkbox_clothing.isChecked();
                    mSelectedOptions[7] = checkbox_puzzles.isChecked();
                    mSelectedOptions[8] = checkbox_toys.isChecked();
                    int low =0;
                    int high =Integer.MAX_VALUE;
                    if(!price_low.getText().toString().equals("")){
                        low = Integer.parseInt(price_low.getText().toString());
                    }
                    if(!price_high.getText().toString().equals("")){
                        high = Integer.parseInt(price_high.getText().toString());
                    }
                    mSelectedOptionsI = FilterActivityController.getIntArrFromTheFilter(mSelectedOptions,low,high,sort_py_price.isChecked());

                    Intent resultIntent = new Intent();
//                    resultIntent.putExtra(SELECTED_OPTIONS_KEY, mSelectedOptions);
                    resultIntent.putExtra(SELECTED_OPTIONS_KEY, mSelectedOptionsI);
                    setResult(RESULT_OK, resultIntent);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //check current state of a check box (true or false)
        Boolean checkBoxState = checkbox_pants.isChecked();
    }

    public void onApplyFilter(View view) {
        // Create an Intent to return the selected options to the previous activity
        Intent resultIntent = new Intent();
//        resultIntent.putExtra(SELECTED_OPTIONS_KEY, mSelectedOptions);
        resultIntent.putExtra(SELECTED_OPTIONS_KEY, mSelectedOptionsI);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
