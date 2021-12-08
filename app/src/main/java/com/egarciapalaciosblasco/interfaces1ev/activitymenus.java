package com.egarciapalaciosblasco.interfaces1ev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class activitymenus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        }
    public void onClick(View v) {
        Intent intent=new Intent(activitymenus.this, MainActivity.class);
        startActivity(intent);
    }
    public void openMain2(View v){
        Intent intent=new Intent(activitymenus.this, MainActivity.class);
        startActivity(intent);

    }
    }