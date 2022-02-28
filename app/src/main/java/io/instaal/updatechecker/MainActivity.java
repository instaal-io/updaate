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
                        .setTheme(updaate.SIMPLE_THEME)
                        .setAppIcon(R.mipmap.ic_launcher)
                        .setTitle("An Update Available")
                        .setPositiveLabel("Update Now")
                        .setNegativeLabel("Maybe Later")
                        .setBackgroundColor(Color.parseColor("#FFFFFF"))
                        .setNegativeButtonColor(Color.parseColor("#dddddd"))
                        .setPrimaryColor(R.color.colorPrimary)
                        .setSecondaryColor(Color.parseColor("#666666"))
                        .setPositiveTextColor(Color.WHITE)
                        .shouldCheckAfterLaunch(1)
                        .setCancelable(true)
                        .check());


        CardView cardView2 = findViewById(R.id.checkButton2);
        cardView2.setOnClickListener(view ->
                new updaate(this)
                        .check());

        CardView cardView3 = findViewById(R.id.checkButton3);
        cardView3.setOnClickListener(view ->
                new updaate(this)
                        .check());


    }


}