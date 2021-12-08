package com.egarciapalaciosblasco.interfaces1ev;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

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

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menucontextual, menu);

        //las tres lineas de abajo estaban comentadas
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);

    }

    public void showAlertDialogButtonClicked(activitymenus activitymenus){
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(this);

        builder.setTitle("Mi dialogo de alerta");
        builder.setMessage("Dialogo emergente");
        builder.setCancelable(false);

        builder.setPositiveButton("MainActivty", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent=new Intent(activitymenus.this,MainActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Sin hacer nada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("otros", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public boolean onContextItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                final ConstraintLayout mLayout=findViewById(R.id.cl);
                Snackbar snackbar=Snackbar.make(mLayout,"Hola Mundo",Snackbar.LENGTH_LONG)
                .setAction("unidos", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1=Snackbar.make(mLayout,"Luces camara accion",Snackbar.LENGTH_LONG);
                        snackbar1.show();
                    }
                });
                snackbar.show();
                return true;

            case R.id.item2:
                Toast toast2=Toast.makeText(this,"Descargas",Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.kiketazoappbar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==R.id.item1){
            Toast t=Toast.makeText(this,"Nightlife",Toast.LENGTH_LONG);
            t.show();
        }

        if (id == R.id.item2){
            Toast t=Toast.makeText(this,"Contado las horas",Toast.LENGTH_LONG);
            t.show();
        }
        if (id == R.id.item4){
            showAlertDialogButtonClicked(activitymenus.this);
        }

        return super.onOptionsItemSelected(item);
    }
    }