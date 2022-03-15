package com.dgdgjfm.l.reposproject.orders.currentOrders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dgdgjfm.l.reposproject.R;

public class CurrentOrdersFragment extends Fragment {



    public static CurrentOrdersFragment newInstance() {
        return new CurrentOrdersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.current_orders_fragment, container, false);
    }


}