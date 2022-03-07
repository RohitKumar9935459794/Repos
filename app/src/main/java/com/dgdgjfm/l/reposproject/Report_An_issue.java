package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.dgdgjfm.l.reposproject.databinding.ActivityReportAnIssueBinding;
import com.dgdgjfm.l.reposproject.model.Report;
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

                Report report= new Report(binding.report.getText().toString());
                database.getReference("Report An Issue").child(Id).setValue(Id+report);

            }
        });
    }
}