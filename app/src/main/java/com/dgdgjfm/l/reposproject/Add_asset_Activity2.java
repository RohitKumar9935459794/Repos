package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dgdgjfm.l.reposproject.databinding.ActivityAddAsset2Binding;

public class Add_asset_Activity2 extends AppCompatActivity {
     ActivityAddAsset2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddAsset2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }
}