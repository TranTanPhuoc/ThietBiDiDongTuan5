package com.example.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuan05.model.Product;

public class MainActivity5_aitem extends AppCompatActivity {
    private ImageView img ;
    private TextView txtName;
    private TextView txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_aitem);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");
        img = findViewById(R.id.imageView2);
        txtName = findViewById(R.id.txtNameitem);
        txtPrice = findViewById(R.id.txtPriceitem);
        img.setImageResource(product.getImg());
        txtName.setText(product.getName());
        txtPrice.setText(product.getPrice());
    }
}