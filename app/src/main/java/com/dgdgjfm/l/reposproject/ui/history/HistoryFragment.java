package com.dgdgjfm.l.reposproject.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.dgdgjfm.l.reposproject.R;
import com.dgdgjfm.l.reposproject.adapter.HistoryFragmentAdpter;
import com.dgdgjfm.l.reposproject.databinding.FragmentHistoryBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HistoryFragment extends Fragment {

    //private HistoryViewModel historyViewModel;
    private @NonNull
    FragmentHistoryBinding binding;
    HistoryFragmentAdpter historyFragmentAdpter;
    private String[] titles= new String[]{"Current order,Past order"};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        historyFragmentAdpter= new HistoryFragmentAdpter(this);





       BottomNavigationView navView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.current_order_menu, R.id.past_order_menu)
                .build();
      /* / NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_order_main);
        .setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);  */




        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}