package com.cosmo.LecturaXML.views.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cosmo.LecturaXML.R;
import com.cosmo.LecturaXML.model.Product;

import java.util.ArrayList;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> productArrayList;
    private Activity context;
    private Product product;
    private TextView name;


    public ProductAdapter(Activity context, int resource, ArrayList<Product> productArrayList) {
        super(context, resource, productArrayList);
        this.context = context;
        this.productArrayList = productArrayList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        this.product = this.productArrayList.get(position);
        loadView(convertView);
        name.setText(product.getName());
        return convertView;
    }

    private void loadView(View convertView){
        name = (TextView) convertView.findViewById(R.id.item_name_product);
    }
}
