package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dgdgjfm.l.reposproject.databinding.ActivityCompanyRegistrationBinding;
import com.dgdgjfm.l.reposproject.model.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompanyRegistration extends AppCompatActivity {
    ActivityCompanyRegistrationBinding binding;
    FirebaseDatabase database;
   // DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCompanyRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        database=FirebaseDatabase.getInstance();
        //reference=database.getReference("CompanyDetails");



        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users= new Users(binding.companyName.getText().toString(),
                        binding.officialEmailAddress.getText().toString(),
                        binding.industryType.getText().toString());

              //  reference.setValue(users);
                database.getReference("CompanyDetails").child(users.getEmail()).setValue(users);
                startActivity(new Intent(CompanyRegistration.this,LoginActivity.class));


            }
        });
    }
}