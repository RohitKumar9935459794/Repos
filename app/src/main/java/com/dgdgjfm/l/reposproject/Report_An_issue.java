package com.dgdgjfm.l.reposproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.databinding.ActivityReportAnIssueBinding;
import com.dgdgjfm.l.reposproject.model.Report_model;
import com.google.firebase.database.FirebaseDatabase;

public class Report_An_issue extends AppCompatActivity {
    ActivityReportAnIssueBinding binding;
    FirebaseDatabase database;
    private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReportAnIssueBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=FirebaseDatabase.getInstance();
        Id=getIntent().getStringExtra("ID") ;
        getSupportActionBar().hide();
        binding.sendReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Report_model reportModel = new Report_model(binding.reportModel.getText().toString());
                database.getReference("Report_model An Issue").setValue(Id+ reportModel);

                Toast.makeText(Report_An_issue.this, "Send Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}