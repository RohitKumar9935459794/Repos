package com.dgdgjfm.l.reposproject.chage_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.dgdgjfm.l.reposproject.R;
import com.dgdgjfm.l.reposproject.databinding.FragmentChangeOrderBinding;

public class Changes_Fragment_Order extends Fragment {

     FragmentChangeOrderBinding fragmentChangeOrderBinding;
     ListView listView;

     String[]  pump={"Ranchi",};
    RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_change_order, container, false);

        // Using volley here for entering
     /*  requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1"
                , null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
            Log.d("my app","the reponse is"+response.getString("Pritrol"));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(" myapp"," Sommewthing went wrong");
            }
        });   */

    }
}