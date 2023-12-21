package com.coursework.eshop;

import static com.coursework.eshop.helpers.Constants.GET_ALL_PRODUCTS_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.coursework.eshop.helpers.Rest;
import com.coursework.eshop.model.Product;
import com.google.gson.Gson;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(getMainLooper());

        executor.execute(() -> {
            try {
                String response = Rest.sendGet(GET_ALL_PRODUCTS_URL);
                handler.post(() -> {
                    try {
                        Gson gson = new Gson();
                        Product[] products = gson.fromJson(response, Product[].class);
                        ListView productList = findViewById(R.id.productListView);
                        ArrayList<String> listOfProducts = new ArrayList<String>();
                        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfProducts);
                        productList.setAdapter(adapter);
                        productList.setOnItemClickListener((parent, view, position, id) -> {

                        });
                        for (Product product : products) {
                            listOfProducts.add(product.toString());
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}