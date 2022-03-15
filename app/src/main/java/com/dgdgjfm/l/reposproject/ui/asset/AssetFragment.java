package com.dgdgjfm.l.reposproject.ui.asset;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dgdgjfm.l.reposproject.Add_asset_Activity2;
import com.dgdgjfm.l.reposproject.R;
import com.dgdgjfm.l.reposproject.chage_fragment.Change_Fragement_Asset;
import com.dgdgjfm.l.reposproject.databinding.FragmentAssetBinding;

public class AssetFragment extends Fragment {

    private AssetViewModel assetViewModel;
    private FragmentAssetBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assetViewModel =
                new ViewModelProvider(this).get(AssetViewModel.class);

        binding = FragmentAssetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Change_Fragement_Asset change_fragement_asset= new Change_Fragement_Asset();
        binding.buttonAddAsset1.setOnClickListener(view -> {
             // this open the Add asset activity
             startActivity(new Intent(getActivity(), Add_asset_Activity2.class));

             // this changes the fragment design
                    FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.assetFragment, change_fragement_asset);
                    fragmentTransaction.commit();
        });

        final TextView textView = binding.textHome;
        assetViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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