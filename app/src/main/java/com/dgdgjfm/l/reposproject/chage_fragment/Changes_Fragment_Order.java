package com.dgdgjfm.l.reposproject.chage_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.dgdgjfm.l.reposproject.R;
import com.dgdgjfm.l.reposproject.databinding.FragmentChangeOrderBinding;

public class Changes_Fragment_Order extends Fragment {

     FragmentChangeOrderBinding fragmentChangeOrderBinding;
     ListView listView;

     String[]  pump={"Ranchi",};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        


        return inflater.inflate(R.layout.fragment_change_order, container, false);
       /* ArrayAdapter<String> adapter= new ArrayAdapter<String>
                (Changes_Fragment_Order.this, android.R.layout.simple_expandable_list_item_1);
        // Using volley here
        // listView.    */

    }
}