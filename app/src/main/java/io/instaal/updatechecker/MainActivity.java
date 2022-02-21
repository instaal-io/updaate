package io.instaal.updatechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import io.instaal.miniupdatechecker.MiniUpdateChecker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.image_button);
    //    imageView.setOnClickListener(view -> {
            new MiniUpdateChecker(this)
                    .setTheme(MiniUpdateChecker.DEFAULT_THEME)
                    .setTitle("App Updater")
                    .setAppIcon(R.drawable.ic_baseline_10mp_24)
                    .setCloseIcon(R.drawable.ic_android_black_24dp)
                    .setDescription("New Update For")
                    .setAppName("MY APP")
                    .setPositiveLabel("Do It")
                    .setNegativeLabel("Never")
                    .setBackgroundColor(Color.parseColor("#eeeeee"))
                    .setPositiveButtonColor(Color.parseColor("#FFA726"))
                    .setNegativeButtonColor(Color.parseColor("#FF7043"))
                    .setPrimaryTextColor(R.color.colorAccent)
                    .setSecondaryTextColor(Color.MAGENTA)
                    .setPositiveTextColor(R.color.black)
                    .setNegativeTextColor(R.color.white)
                    .shouldCheckAfterLaunch(2)
                    .checkUpdate();

     //   });


    }
}