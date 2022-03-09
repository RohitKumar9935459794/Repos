package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.dgdgjfm.l.reposproject.databinding.ActivityAddAsset2Binding;

import java.util.ArrayList;

public class Add_asset_Activity2 extends AppCompatActivity {
     ActivityAddAsset2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddAsset2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

          binding.myLocation.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

              }
          });




    }
}