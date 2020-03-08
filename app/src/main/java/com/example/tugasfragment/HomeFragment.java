package com.example.tugasfragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rv_llist;
    private ArrayList<heroesModel> list = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_llist = view.findViewById(R.id.rv_list);
        list.addAll(heroesData.getListData());

        ShowRecycleList();
        return view;
    }

    private void ShowRecycleList() {
        rv_llist.setLayoutManager(new LinearLayoutManager(getActivity()));
        heroesAdapter HeroesAdapter = new heroesAdapter(getActivity());
        HeroesAdapter.setTvList(list);
        rv_llist.setAdapter(HeroesAdapter);

    }

}
