package com.dgdgjfm.l.reposproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.databinding.ActivityAddAsset2Binding;

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
               startActivity( new Intent(Add_asset_Activity2.this,MapsActivity.class));
              }
          });

          





    }
}