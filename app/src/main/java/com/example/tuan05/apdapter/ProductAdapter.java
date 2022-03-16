package com.example.tuan05.apdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuan05.MainActivity5_aitem;
import com.example.tuan05.model.Product;
import com.example.tuan05.R;

import java.io.Serializable;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> listProduct;
    private int positionSelect = -1;

    public ProductAdapter(Context context, int idLayout, List<Product> listProduct) {
        this.context = context;
        this.idLayout = idLayout;
        this.listProduct = listProduct;
    }



    @Override
    public int getCount() {
        if (listProduct.size() != 0 && !listProduct.isEmpty()) {
            return listProduct.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvmoTa = convertView.findViewById(R.id.txtAbout);
        TextView tvProductName = (TextView) convertView.findViewById(R.id.txtName);
        TextView tvProductPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        final Product product = listProduct.get(position);


        if (listProduct != null && !listProduct.isEmpty()) {
            tvmoTa.setText(product.getAbout());
            tvProductName.setText(product.getName());
            imageView.setImageResource(product.getImg());
            tvProductPrice.setText(product.getPrice());
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity5_aitem.class);
                intent.putExtra("product", product);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
