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

        ArrayList<String> asset = new ArrayList<>();
        asset.add("DG Set");
        asset.add("Industrial Machine");
        asset.add("Infrastructure Machine");
        asset.add("Heavy Vehicles");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, asset);
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text =" Item" + i+""+view.toString();
                Toast.makeText(Add_asset_Activity2.this,text, Toast.LENGTH_SHORT).show();
            }
        });


    }
}