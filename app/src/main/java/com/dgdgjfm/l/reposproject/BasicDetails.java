package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dgdgjfm.l.reposproject.databinding.ActivityBasicDetailsBinding;
import com.dgdgjfm.l.reposproject.model.Users;
import com.google.firebase.database.FirebaseDatabase;

public class BasicDetails extends AppCompatActivity {

    ActivityBasicDetailsBinding binding;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBasicDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=FirebaseDatabase.getInstance();

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users= new Users(binding.fullName.getText().toString(),binding.phone.getText().toString());
                database.getReference("Basic Details").child(users.getEmail()).setValue(users);
                startActivity(new Intent(BasicDetails.this,CompanyRegistration.class));
            }
        });

        binding.loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicDetails.this,LoginActivity.class));
            }
        });
    }
}