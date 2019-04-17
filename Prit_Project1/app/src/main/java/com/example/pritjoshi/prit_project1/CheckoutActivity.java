package com.example.pritjoshi.prit_project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    int numberOfItems = 1;
    Product product;
    private Button buttonConfirm;
    private EditText FirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

//        this.txtEmail = (TextView) findViewById(R.id.txtEmail);
//        this.email = (TextView) findViewById(R.id.email);
//        this.txtFnm = (TextView) findViewById(R.id.txtFnm);
            FirstName = (EditText) findViewById(R.id.FirstName);
//        this.txtLnm = (TextView) findViewById(R.id.txtLnm);
//        this.LastName = (TextView) findViewById(R.id.LastName);
//        this.txtNum = (TextView) findViewById(R.id.txtNum);
//        this.Phone = (EditText) findViewById(R.id.Phone);
//        this.txtNoItems = (TextView) findViewById(R.id.txtNoItems);
//        this.txtPayment = (TextView) findViewById(R.id.txtPayment);
//        this.rdGrp = (RadioGroup) findViewById(R.id.rdGrp);
          buttonConfirm = (Button) findViewById(R.id.buttonConfirm);

        Intent intent = getIntent();
        if (intent != null) {
            product = new Product();
            product.setName(intent.getStringExtra("name"));
            product.setImg(intent.getStringExtra("img"));
            product.setPrice(intent.getFloatExtra("price",0));

        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirstName.getText().toString().isEmpty()){
                    FirstName.setError("This Field is Required");
                }else {
                    Toast.makeText(CheckoutActivity.this, "Your Test Drive has been Booked.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), IndexActivity.class));
                }
            }
        });
     }
}
