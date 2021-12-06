package com.egarciapalaciosblasco.interfaces1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView hey=(ImageView) findViewById(R.id.heyl);

        Glide.with(this)
                .load(R.drawable.hey)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.cardview_light_background)))
                //.circleCrop()
                //.diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(hey);
    }
}