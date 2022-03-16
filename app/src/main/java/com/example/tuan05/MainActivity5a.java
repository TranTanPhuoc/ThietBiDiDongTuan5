package com.example.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tuan05.apdapter.ProductAdapter;
import com.example.tuan05.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5a extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Product> listProduct;
    private List<Product> listProductB = new ArrayList<>();
    private List<Product> listProductA = new ArrayList<>();
    private Button btnD,btnPD,btnF;
    private EditText txtSearch;
    private ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listProduct = new ArrayList<>();
        listProduct.add(new Product("Tasty Donut","Spicy tasty donut family",R.drawable.donut_yellow_1,"$10.00","Donut"));
        listProduct.add(new Product("Pink Donut","Spicy tasty donut family",R.drawable.tasty_donut_1,"$20.00","Pink Donut"));
        listProduct.add(new Product("Floating Donut","Spicy tasty donut family",R.drawable.green_donut_1,"$30.00","Floating"));
        listProduct.add(new Product("Tasty Donut","Spicy tasty donut family",R.drawable.donut_red_1,"$40.00","Donut"));
        adapter = new ProductAdapter(this,R.layout.item5a,listProductA);
        listView.setAdapter(adapter);
        btnD =findViewById(R.id.button2);
        btnPD =findViewById(R.id.button3);
        btnF = findViewById(R.id.button4);
        txtSearch= findViewById(R.id.txtSearch);
        XuLiClick(btnD,btnPD,btnF);

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLiClick(btnD,btnPD,btnF);
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLiClick(btnF,btnD,btnPD);
            }
        });
        btnPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLiClick(btnPD,btnD,btnF);
            }
        });
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                listProductA.clear();
                String regex = "^("+ charSequence.toString().toLowerCase()+").*";
                for(Product p  : listProductB){
                    if(p.getName().toLowerCase().matches(regex)){
                        listProductA.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    private void XuLiClick(Button btn1,Button btn2, Button btn3){
        btn1.setBackgroundColor(Color.YELLOW);
        btn2.setBackgroundColor(Color.RED);
        btn3.setBackgroundColor(Color.RED);
        listProductA.clear();
        listProductB.clear();
        String type = "Donut";
        if(btn1 == btnPD){
            type = "Pink Donut";
        }
        if (btn1 == btnF){
            type = "Floating";
        }
        for(Product product : listProduct){
            if(product.getType().equalsIgnoreCase(type.trim())){
                listProductA.add(product);
                listProductB.add(product);
            }
        }
        adapter.notifyDataSetChanged();
    }
}