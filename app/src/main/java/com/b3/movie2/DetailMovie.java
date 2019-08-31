package com.b3.movie2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "movie";
    ImageView imgPhotoDetail;
    TextView NameDetail, DescDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        new Bundle();
        Bundle mBundle;

        mBundle = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String Name = mBundle.getString("name");
        String Desc = mBundle.getString("desc");
        int imgPhoto = mBundle.getInt("photo");

        NameDetail.setText(Name);
        DescDetail.setText(Desc);
        imgPhotoDetail.setImageResource(imgPhoto);

        imgPhotoDetail = findViewById(R.id.img_photo_detail);
        NameDetail = findViewById(R.id.name_detail);
        DescDetail = findViewById(R.id.desc_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        }
    }
}
