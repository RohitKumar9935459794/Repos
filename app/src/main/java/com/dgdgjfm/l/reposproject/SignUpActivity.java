package com.dgdgjfm.l.reposproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dgdgjfm.l.reposproject.databinding.ActivitySignUpBinding;
import com.dgdgjfm.l.reposproject.model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
      ActivitySignUpBinding binding;
        FirebaseAuth auth;
        FirebaseDatabase database;
        ProgressDialog progressDialog;
    private String  Phone;
    private String  full_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Phone=getIntent().getStringExtra("phone") ;
        full_name=getIntent().getStringExtra("fullName") ;

        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("You are singUp");
        progressDialog.setMessage("We are creating your account");

        binding.buttonAddCompanyDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.emailAddress.getText().toString(),
                        binding.enterPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.show();
                      if(task.isSuccessful()){
                          Users users= new Users(binding.emailAddress.getText().toString(),
                                  binding.enterPassword.getText().toString());

                          String id=task.getResult().getUser().getUid();
                          database.getReference().child("Users").child(id).setValue(users+Phone+full_name);
                         Intent intent= new Intent(SignUpActivity.this,CompanyRegistration.class);
                          intent.putExtra("UserId",id);
                          startActivity(intent);

                          Toast.makeText(SignUpActivity.this, "User created Successfully", Toast.LENGTH_SHORT).show();
                          
                      } else {
                          Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                      }
                    }
                }) ;
            }
        });
    }
}