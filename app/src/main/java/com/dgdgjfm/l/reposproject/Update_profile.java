package com.dgdgjfm.l.reposproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.databinding.ActivityUpdateProfileBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Update_profile extends AppCompatActivity {
    ActivityUpdateProfileBinding binding;
     FirebaseDatabase database;
    private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
         database=FirebaseDatabase.getInstance();
        Id=getIntent().getStringExtra("ID") ;




        binding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                HashMap hashMap= new HashMap();
                hashMap.put("Update_Email",binding.updateEmail.getText().toString());
                hashMap.put("Update_Name", binding.updateName.getText().toString());
                hashMap.put("Update_Phone",binding.updatePhone.getText().toString());
                hashMap.put("Update_Company_Name",binding.updateCompanyName.getText().toString());
                hashMap.put("Update_Official_emailAddress",binding.updateOfficialEmail.getText().toString());
                hashMap.put("Update_IndustryType",binding.updateIndustryType.getText().toString());
                hashMap.put("Update_Password",binding.updatePassword.getText().toString());



                database.getReference().child("User").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Update_profile.this, "Update is successful", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }


}