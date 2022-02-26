package io.instaal.updatechecker;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import io.instaal.updaate.updaate;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView = findViewById(R.id.checkButton);
        cardView.setOnClickListener(view ->
                new updaate(this)
                        .setTheme(updaate.DEFAULT_THEME)
                        .setPrimaryColor(R.color.colorAccent)
                        .setSecondaryColor(R.color.colorPrimary)
                        .setPositiveTextColor(R.color.white)
                        .setTitle("A New Update Available")
                        .setPositiveLabel("Update")
                        .setNegativeLabel("Later")
                        .setNegativeButtonColor(R.color.white)
                        .setBackgroundColor(Color.WHITE)
                        .shouldCheckAfterLaunch(1)
                        .check());


        CardView cardView2 = findViewById(R.id.checkButton2);
        cardView2.setOnClickListener(view ->
                new updaate(this)
                        .setTheme(updaate.SMART_THEME)
                        .setPrimaryColor(R.color.colorAccent)
                        .setSecondaryColor(R.color.colorPrimary)
                        .setPositiveTextColor(R.color.white)
                        .setIconColor(R.color.black)
                        .setTitle("A New Update Available")
                        .setAppIcon(R.drawable.update_icon)
                        .setPositiveLabel("Update")
                        .setNegativeLabel("Later")
                        .setNegativeButtonColor(R.color.white)
                        .setBackgroundColor(Color.WHITE)
                        .shouldCheckAfterLaunch(1)
                        .check());

        CardView cardView3 = findViewById(R.id.checkButton3);
        cardView3.setOnClickListener(view ->
                new updaate(this)
                        .setTheme(updaate.FANCY_THEME)
                        .setPrimaryColor(R.color.colorAccent)
                        .setSecondaryColor(R.color.colorPrimary)
                        .setPositiveTextColor(R.color.white)
                        .setTitle("A New Update Available")
                        .setPositiveLabel("Update")
                        .setNegativeLabel("Later")
                        .setBackgroundColor(Color.WHITE)
                        .shouldCheckAfterLaunch(1)
                        .check());


    }



}