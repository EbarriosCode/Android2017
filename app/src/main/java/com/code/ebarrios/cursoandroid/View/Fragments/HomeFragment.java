package com.code.ebarrios.cursoandroid.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code.ebarrios.cursoandroid.Adapter.RecyclerViewCardView;
import com.code.ebarrios.cursoandroid.Models.Picture;
import com.code.ebarrios.cursoandroid.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.inicio),false,view);
        RecyclerView picturesRecycler = (RecyclerView)view.findViewById(R.id.cardViewRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        // este es el adapter
        RecyclerViewCardView recyclerViewCardView = new RecyclerViewCardView(buildPictures(),R.layout.cardview_picture,getActivity());

        picturesRecycler.setAdapter(recyclerViewCardView);
        return view;
    }

    public ArrayList<Picture> buildPictures()
    {
        ArrayList<Picture> pictures = new ArrayList<>();

        pictures.add(new Picture("http://image.hotdog.hu/imagerotator/viccccca/hold.jpg","Eduardo Barrios","4 días","10 Me gusta"));
        pictures.add(new Picture("http://k33.kn3.net/taringa/3/2/E/6/4/8/KonahsFvZ/B18.jpg","Fernanda Herrera","1 días","5 Me gusta"));
        pictures.add(new Picture("http://www.blogdelfotografo.com/wp-content/uploads/2014/01/Fotografia-de-Paisajes-1-1024x520.jpg","Rafael Hernandez","3 días","6 Me gusta"));


        return pictures;
    }

    public void showToolbar(String title, boolean btnRegreso, View view)
    {
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(btnRegreso);
    }

}
