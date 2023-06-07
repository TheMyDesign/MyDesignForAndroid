package com.example.mydesign.controler;
import static java.lang.Thread.sleep;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.example.mydesign.ShowUserDesignActivity;
import com.example.mydesign.model.HttpCallback;


public class HttpHelper extends AsyncTask<String, Void, String> {

    private Exception exception;
    private OkHttpClient client = new OkHttpClient();
    public HttpCallback callback;

    public String _result;

    public void setCallback(HttpCallback callback) {
        this.callback = callback;
    }

    protected String doInBackground(String... urls) {
        try {
            Request request = new Request.Builder()
                    .url(urls[0])
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            this.exception = e;
            return null;
        }
    }

    public String get_result() {
        return _result;
    }

    protected void onPostExecute(String result) {
        if (exception != null) {
            Log.e("HttpHelper", "Exception occurred: " + exception.getMessage());
            return ;
        }

// Call the callback with the result
        if (callback != null) {
            callback.onResult(result);
        }
        // Use the result
        this._result = result;
//        Log.d("Response body:", result);
    }
}
