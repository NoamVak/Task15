package com.example.task15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CreditAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0,0,500,"Back to Act");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String choice=item.getTitle().toString();
        if(choice.equals("Back to Act"))
            finish();
        return true;
    }
}