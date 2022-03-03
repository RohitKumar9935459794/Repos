package com.dgdgjfm.l.reposproject.ui.asset;

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

import com.dgdgjfm.l.reposproject.Add_AssetFragment;
import com.dgdgjfm.l.reposproject.R;
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
        Add_AssetFragment add_assetFragment =new Add_AssetFragment();
        binding.buttonAddAsset1.setOnClickListener(view -> {


                    FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.assetFragment,add_assetFragment);
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