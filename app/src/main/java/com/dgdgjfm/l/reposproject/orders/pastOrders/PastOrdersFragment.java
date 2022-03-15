package com.dgdgjfm.l.reposproject.orders.pastOrders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dgdgjfm.l.reposproject.R;

public class PastOrdersFragment extends Fragment {



    public static PastOrdersFragment newInstance() {
        return new PastOrdersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.past_orders_fragment, container, false);
    }



}