package com.dgdgjfm.l.reposproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.databinding.ActivityAddAsset2Binding;
import com.dgdgjfm.l.reposproject.model.Add_Asset;
import com.google.firebase.database.FirebaseDatabase;

public class Add_asset_Activity2 extends AppCompatActivity {

     ActivityAddAsset2Binding binding;
     FirebaseDatabase database;
     private String location;

    private String Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddAsset2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        database=FirebaseDatabase.getInstance();
        Id=getIntent().getStringExtra("ID") ;
        location= getIntent().getStringExtra("location");
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Add_Asset add_asset= new Add_Asset(binding.assetCapacity.getText().toString(),binding.assetName.getText().toString()) ;
                  database.getReference("Asset").child("Added Asset").setValue(add_asset+location+Id);

                Toast.makeText(Add_asset_Activity2.this, "Asset add successfully", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

          binding.myLocation.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
               startActivity( new Intent(Add_asset_Activity2.this,MapsActivity.class));
              }
          });

          binding.buttonC1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  binding.assetCapacity.setText("100");
              }
          });
        binding.buttonC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetCapacity.setText("400");
            }
        });
        binding.buttonC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetCapacity.setText("200");
            }
        });
        binding.buttonC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetCapacity.setText("600");
            }
        });
        binding.buttonC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetCapacity.setText("300");
            }
        });
        binding.buttonC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetCapacity.setText("800");
            }
        });


        binding.djCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetName.setText("Dj_Set");
                Toast.makeText(Add_asset_Activity2.this, "You selected Dj set", Toast.LENGTH_SHORT).show();
            }
        });
        binding.industryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetName.setText("Industry");
                Toast.makeText(Add_asset_Activity2.this, "You selected Industry", Toast.LENGTH_SHORT).show();
            }
        });

        binding.infraCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetName.setText("Infrastructure");
                Toast.makeText(Add_asset_Activity2.this, "You selected Inftra structure", Toast.LENGTH_SHORT).show();
            }
        });

        binding.heavyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.assetName.setText("Heavy Vachel");
                Toast.makeText(Add_asset_Activity2.this, "You selected Heavy vechail", Toast.LENGTH_SHORT).show();
            }
        });

    }
}