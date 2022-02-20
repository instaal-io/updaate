package io.instaal.updatechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import io.instaal.miniupdatechecker.MiniUpdateChecker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.image_button);
        imageView.setOnClickListener(view -> {
            new MiniUpdateChecker(this)
                    .setTheme(MiniUpdateChecker.DEFAULT_THEME)
                    .setTitle("New Version Available")
                    .setAppIcon(R.drawable.update_icon)
                    .showDialog();
        });




    }
}