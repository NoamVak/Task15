package com.example.task15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    LinearLayout lL;
    final String [] colors={"Red","Green","Blue"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lL=(LinearLayout)findViewById(R.id.lL);
    }

    public void RGB_Change(View view) {
        int [] color= {0,0,0};

        adb= new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Core Colors Change");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                lL.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

    public void RGB_Mix(View view) {
        int [] color= {0,0,0};

        adb= new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Core Colors Mix");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)   color[which]=255;
                else if(color[which]==255)  color[which]=0;
            }
        });
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lL.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });
        adb.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

    public void Back_To_White(View view) {
        lL.setBackgroundColor(Color.WHITE);
    }

    public void Text_Message(View view) {
    }
}