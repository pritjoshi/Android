package com.example.pritjoshi.prit_project1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayFragment extends Fragment {


    public static DisplayFragment newInstance(Product product) {

        Bundle args = new Bundle();
        args.putString("name", product.getName());
        args.putString("img", product.getImg());
        args.putFloat("price", product.getPrice());
        DisplayFragment frag = new DisplayFragment();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container,false);
        Product product = new Product();
        product.setName(getArguments().getString("name"));
        product.setImg(getArguments().getString("img"));
        product.setPrice(getArguments().getFloat("price"));
        TextView title = view.findViewById(R.id.textProdName);
        TextView price = view.findViewById(R.id.textProdPrice);
        ImageView img = view.findViewById(R.id.imageView2);
        title.setText(product.getName());
        price.setText(String.valueOf(product.getPrice()));
        img.setImageResource(getResources().getIdentifier("drawable/" + product.getImg(), null, getContext().getPackageName()));
        AppCompatButton checkout = view.findViewById(R.id.btnCheckout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CheckoutActivity.class));
            }
        });
        return view;
    }

}
