package com.egarciapalaciosblasco.interfaces1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnmenu=(Button) findViewById(R.id.button2);

        ImageView hey=(ImageView) findViewById(R.id.heyl);

        ImageView cascos=(ImageView) findViewById(R.id.imageView);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.cascos);
        cascos.startAnimation(anim);

        Glide.with(this)
               .load(R.drawable.mesa)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.cardview_light_background)))
                //.circleCrop()
                //.diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(hey);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, activitymenus.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        TextView mycontext=(TextView) findViewById(R.id.textView);
        registerForContextMenu(mycontext);
    }

    public void openMenus(View view){
        Intent intent=new Intent(MainActivity.this, activitymenus.class);
        startActivity(intent);
    }

    public void openMain2(View view){
        Intent intent=new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
    }
}