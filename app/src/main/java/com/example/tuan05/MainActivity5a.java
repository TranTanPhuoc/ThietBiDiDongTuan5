package com.example.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tuan05.apdapter.ProductApdapter;
import com.example.tuan05.model.Product;

import java.util.ArrayList;

public class MainActivity5a extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Product> listProduct;
    private ProductApdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listProduct = new ArrayList<>();
        listProduct.add(new Product("Tasty Donut","Spicy tasty donut family",R.drawable.donut_yellow_1,"$10.00"));
        listProduct.add(new Product("Pink Donut","Spicy tasty donut family",R.drawable.tasty_donut_1,"$20.00"));
        listProduct.add(new Product("Floating Donut","Spicy tasty donut family",R.drawable.green_donut_1,"$30.00"));
        listProduct.add(new Product("Tasty Donut","Spicy tasty donut family",R.drawable.donut_red_1,"$40.00"));
        adapter = new ProductApdapter(this,R.layout.item5a,listProduct);
        listView.setAdapter(adapter);
    }
}