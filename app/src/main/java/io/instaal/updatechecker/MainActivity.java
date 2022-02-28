package io.instaal.updatechecker;

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
                        .hideNegativeButton(true)
                        .check());


        CardView cardView2 = findViewById(R.id.checkButton2);
        cardView2.setOnClickListener(view ->
                new updaate(this)
                        .setTheme(updaate.SMART_THEME)
                        .hideNegativeButton(false)
                        .setCancelable(true)
                        .check());

        CardView cardView3 = findViewById(R.id.checkButton3);
        cardView3.setOnClickListener(view ->
                new updaate(this)
                        .setTheme(updaate.FANCY_THEME)
                        .useImageInsteadAnim(false)
                        .setHeaderImage(updaate.IMAGE_9)
                        .setHeaderAnimation(updaate.ANIMATION_4)
                        .hideNegativeButton(false)
                        .setDialogCornerRadius(10)
                        .setButtonCornerRadius(10)
                        .setCancelable(true)
                        .check());


    }


}