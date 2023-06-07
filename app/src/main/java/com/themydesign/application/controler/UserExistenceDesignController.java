package com.example.mydesign.controler;


import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserExistenceDesignController {
        ArrayList<String> image_list = new ArrayList<>();
        ArrayList<String[]> info = new ArrayList<>();

        public ArrayList<String> getImage_list() {
            return image_list;
        }

        public ArrayList<String[]> getInfo() {
            return info;
        }


    public void readJsonToImagePlusInfo(String resultJson) {

        if (resultJson != null) {

            ArrayList<String> image_list = new ArrayList<>();
            ArrayList<String[]> info = new ArrayList<>();
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Map<String, String>>>() {
            }.getType();
            List<Map<String, String>> items = gson.fromJson(resultJson, listType);

            for (Map<String, String> item : items) {

                String company = item.get("Company Name");
                String id = item.get("Supplier ID");
                String price = item.get("Price");
                image_list.add(item.get("Image URL"));
                String name = item.get("File Name");
                String description = item.get("Product Description");
                String[] item_info = {id, company, name, description, price};
                info.add(item_info);
            }

                this.image_list = image_list;
                this.info = info;
        } else {
            Log.d(TAG, "Error getting documents: ");
        }
    }
}
