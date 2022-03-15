package com.dgdgjfm.l.reposproject.ui.profile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dgdgjfm.l.reposproject.Report_An_issue;
import com.dgdgjfm.l.reposproject.Update_profile;
import com.dgdgjfm.l.reposproject.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private com.dgdgjfm.l.reposproject.ui.profile.ProfileViewModel ProfileViewModel;
    private FragmentProfileBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    DatabaseReference reference;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        auth=FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                 /* // String Name= dataSnapshot.child("fullName").getValue().toString();
                    String Email= dataSnapshot.child("email").getValue().toString();
                    String Phone= dataSnapshot.child("mobile").getValue().toString();

                   // binding.profileName.setText(Name);
                    binding.profileEmail.setText(Email);
                    binding.editTextPhone.setText(Phone);*/
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }) ;



        ProfileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        binding.logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            auth.signOut();
            FirebaseAuth.getInstance().signOut();
             // startActivity( new Intent(getActivity(),LoginActivity.class));

            }
        });

        binding.updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(getActivity(), Update_profile.class));
            }
        });

        binding.ReportAnIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Report_An_issue.class));
            }
        });

        binding.supportText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

      

       final TextView textView = binding.supportText;
        ProfileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}