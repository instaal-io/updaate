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
        cardView.setOnClickListener(view -> {
            new updaate.DefaultTheme(this)
                    .check();
        });


    }


}