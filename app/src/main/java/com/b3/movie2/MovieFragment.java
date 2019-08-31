package com.b3.movie2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements CardViewAdapter.OnItemClickListener {
    public static String EXTRA_MOVIE = "movieextra";

    private ArrayList<Movie> list = new ArrayList<>();
    private RecyclerView rvCategory;
    private String[] dataName, dataDesc;
    private TypedArray dataPhoto;
    View view;

    public MovieFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        for (int i = 0; i< dataName.length; i++) {
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setDesc(dataDesc[i]);
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            list.add(movie);
        }
        showRecyclerCardView();
        return view;
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new  LinearLayoutManager(getActivity()));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(getContext());
        cardViewAdapter.setListMovie(list);
        rvCategory.setAdapter(cardViewAdapter);


        CardViewAdapter.setOnItemClickListener(MovieFragment.this);
    }

    @Override
    public void onItemClick(int position) {
        Movie movie = new Movie();
        Bundle mBundle = new Bundle();

        mBundle.putParcelable(DetailMovie.EXTRA_MOVIE, movie);
        movie.setName(dataName[position]);
        movie.setDesc(dataDesc[position]);
        movie.setPhoto(dataPhoto.getResourceId(position, -1));
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(mBundle);

        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager != null) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.tabLayout, fragment);
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}

