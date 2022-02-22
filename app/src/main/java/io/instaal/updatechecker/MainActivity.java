package io.instaal.updatechecker;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import io.instaal.miniupdatechecker.MiniUpdateChecker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView = findViewById(R.id.checkButton);
        cardView.setOnClickListener(view -> checkForUpdate());

        checkForUpdate();

    }

    private void checkForUpdate() {
        new MiniUpdateChecker(this)
                .setTheme(MiniUpdateChecker.DEFAULT_THEME)
                .setTitle("App Updater")
                .setAppIcon(R.drawable.ic_baseline_10mp_24)
                .setCloseIcon(R.drawable.ic_android_black_24dp)
                .setDescription("New Update For")
                .setAppName("MY APP")
                .setPositiveLabel("Do It")
                .setNegativeLabel("Never")
                .setBackgroundColor(Color.parseColor("#ffffff"))
                .setPositiveButtonColor(Color.parseColor("#00ACC1"))
                .setNegativeButtonColor(Color.parseColor("#DDDDDD"))
                .setPrimaryTextColor(Color.parseColor("#00ACC1"))
                .setSecondaryTextColor(Color.parseColor("#444444"))
                .setPositiveTextColor(Color.parseColor("#FFFFFF"))
                .setNegativeTextColor(Color.parseColor("#444444"))
                .shouldCheckAfterLaunch(1)
                .check();
    }


}