package com.example.coffeeshoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.coffeeshoffee.databinding.ActivityDetailBinding;
import com.example.coffeeshoffee.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        final int image = intent.getIntExtra("image", 0);
        final int price = Integer.parseInt(intent.getStringExtra("price"));
        final String name = intent.getStringExtra("name");

        binding.detailimage.setImageResource(image);
        binding.detailprice.setText(String.format("%d", price));
        binding.detailname.setText(name);

        DBHelper helper = new DBHelper(this);

        binding.buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  helper.insert(
                        binding.namebox.getText().toString(),
                        binding.phonebox.getText().toString(),
                        price,
                       Integer.parseInt(binding.quantity.getText().toString()),
                        image,
                        name

                );
               if(isInserted){
                   Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
               } else{
                   Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

}