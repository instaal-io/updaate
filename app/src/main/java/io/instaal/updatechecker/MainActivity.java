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
                        .setAppIcon(R.mipmap.ic_launcher)
                        .setTitle("An Update Available")
                        .setPositiveLabel("Update Now")
                        .setNegativeLabel("Maybe Later")
                        .setIconColor(R.color.colorAccent)
                        .setBackgroundColor(Color.parseColor("#FFFFFF"))
                        .setNegativeButtonColor(Color.parseColor("#dddddd"))
                        .setPrimaryColor(R.color.colorPrimary)
                        .setSecondaryColor(Color.parseColor("#666666"))
                        .setPositiveTextColor(Color.WHITE)
                        .hideNegativeButton(true)
                        .setDialogCornerRadius(10)
                        .setButtonCornerRadius(10)
                        .shouldCheckAfterLaunch(1)
                        .setCancelable(true)
                        .check());

    }


}