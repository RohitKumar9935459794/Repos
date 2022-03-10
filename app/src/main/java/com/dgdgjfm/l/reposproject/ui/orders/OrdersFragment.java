package com.dgdgjfm.l.reposproject.ui.orders;

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

import com.dgdgjfm.l.reposproject.Changes_Fragment_Order;
import com.dgdgjfm.l.reposproject.Add_asset_Activity2;
import com.dgdgjfm.l.reposproject.R;
import com.dgdgjfm.l.reposproject.databinding.FragmentOrdersBinding;


public class OrdersFragment extends Fragment {

    private OrdersViewModel ordersViewModel;
    private FragmentOrdersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ordersViewModel = new ViewModelProvider(this).get(OrdersViewModel.class);

        binding = FragmentOrdersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Changes_Fragment_Order changesFragment =new Changes_Fragment_Order();

        binding.buttonAddAsset1.setOnClickListener(view -> {
            // this open the Add asset activity
            startActivity(new Intent(getActivity(), Add_asset_Activity2.class));

            // this changes the fragment
            FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.orderFragment, changesFragment);
            fragmentTransaction.commit();




        });

        final TextView textView = binding.ordersText;
        ordersViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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