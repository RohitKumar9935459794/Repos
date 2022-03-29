package com.dgdgjfm.l.reposproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.databinding.ActivityCompanyRegistrationBinding;
import com.dgdgjfm.l.reposproject.model.Users;
import com.google.firebase.database.FirebaseDatabase;

public class CompanyRegistration extends AppCompatActivity {
    ActivityCompanyRegistrationBinding binding;
    FirebaseDatabase database;
   private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCompanyRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        database=FirebaseDatabase.getInstance();
        Id=getIntent().getStringExtra("ID") ;



        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users= new Users(binding.companyName.getText().toString(),
                        binding.officialEmailAddress.getText().toString(),
                        binding.industryType.getText().toString());

              //  reference.setValue(users);
                database.getReference("CompanyDetails").child(users.getEmail()).setValue(Id+users);
                Intent intent= new Intent(CompanyRegistration.this,MainActivity.class);
                intent.putExtra("UserId",Id);
               startActivity(intent);

            }
        });
    }
}