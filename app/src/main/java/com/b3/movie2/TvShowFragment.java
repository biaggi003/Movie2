package com.b3.movie2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private ArrayList<TvShow> list = new ArrayList<>();
    private RecyclerView rvCategory;
    private String[] dataName, dataDesc;
    private TypedArray dataPhoto;
    View view;

    public TvShowFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        dataName = getResources().getStringArray(R.array.data_name2);
        dataDesc = getResources().getStringArray(R.array.data_description2);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo2);

        for (int i = 0; i< dataName.length; i++) {
            TvShow tvshow = new TvShow();
            tvshow.setName(dataName[i]);
            tvshow.setDesc(dataDesc[i]);
            tvshow.setPhoto(dataPhoto.getResourceId(i, -1));
            list.add(tvshow);
        }
        showRecyclerCardView();
        return view;
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewAdapter2 cardViewAdapter = new CardViewAdapter2(list);
        rvCategory.setAdapter(cardViewAdapter);
    }
}
