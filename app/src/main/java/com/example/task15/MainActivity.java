package com.example.task15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 *
 * @author Noam Vaknin <noamvak765@gmail.com>
 * @version 1.6 (current version number of program) - I don't know exactly what to do here
 * @since 21 /8/2016 (the date of the package the class was added)
 */
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


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0,0,500,"Credit Activity");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String choice=item.getTitle().toString();
        if(choice.equals("Credit Activity")){
            Intent res=new Intent(this,CreditAct.class);
            startActivity(res);
        }

        return true;
    }

    /**
     * Rgb change. - Changes the screen color to one of the RGB colors.
     *
     * @param view the view
     */
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

    /**
     * Rgb mix. - Changes the screen color to a mix of the RGB colors.
     *
     * @param view the view
     */
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

    /**
     * Back to white. -  Changes the screen color back to white
     *
     * @param view the view
     */
    public void Back_To_White(View view) {
        lL.setBackgroundColor(Color.WHITE);
    }

    /**
     * Text message. - An Alert dialog which has an edit text and shows the input on a Toast
     *
     * @param view the view
     */
    public void Text_Message(View view) {
        adb= new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Message Input");
        final EditText eT= new EditText(this);
        eT.setHint("Type Message Here");
        adb.setView(eT);
        adb.setPositiveButton("Show", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str= eT.getText().toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }
}