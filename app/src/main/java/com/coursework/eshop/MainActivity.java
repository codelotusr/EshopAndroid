package com.coursework.eshop;

import static com.coursework.eshop.helpers.Constants.VALIDATE_USER_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.coursework.eshop.helpers.Rest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validateUser(View view) {
        TextView username = findViewById(R.id.usernameField);
        TextView password = findViewById(R.id.passwordField);

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", username.getText().toString());
        jsonObject.addProperty("password", password.getText().toString());

        String info = gson.toJson(jsonObject);
        System.out.println(info);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(getMainLooper());

        executor.execute(() -> {
            try {
                String response = Rest.sendPost(VALIDATE_USER_URL, info);
                handler.post(() -> {
                   try {
                       if (!response.equals("Error") && !response.equals("false")) {
                           Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                           startActivity(intent);
                       } else {
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}