package com.example.coffeeshoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.coffeeshoffee.Adapters.MainAdapter;
import com.example.coffeeshoffee.Models.MainModel;
import com.example.coffeeshoffee.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
              
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.americano, "Americano", "5"));
        list.add(new MainModel(R.drawable.doubleespresso, "Double Espresso", "4"));
        list.add(new MainModel(R.drawable.caffeelatte, "Caffe Latte", "6"));
        list.add(new MainModel(R.drawable.caffeemocha, "Caffe Mocha", "7"));
        list.add(new MainModel(R.drawable.cappuccino, "Cappuccino", "6"));
        list.add(new MainModel(R.drawable.coldbrewcoffee, "Cold Brew", "4"));
        list.add(new MainModel(R.drawable.espresso, "Espresso", "2"));
        list.add(new MainModel(R.drawable.frappe, "Frappuccino", "7"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerview.setLayoutManager(gridLayoutManager);
    }

}