package io.instaal.miniupdatechecker;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

public class MiniUpdateChecker {

    public static final String DEFAULT_THEME = "default";
    public static final String MINI_THEME = "mini";
    public static final String SIMPLE_THEME = "simple";
    private static final String DEFAULT_TITLE = "New Update Available";
    private static final int DEFAULT_APP_ICON = R.drawable.update_icon;
    private static final int DEFAULT_CLOSE_ICON = R.drawable.cancel_icon;
    private static final String DEFAULT_DESCRIPTION = "There is a new version available for";
    private static final String DEFAULT_NOT_NOW = "Not Now";
    private static final String DEFAULT_UPDATE = "Update";
    private static final int DEFAULT_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_POSITIVE_COLOR = Color.parseColor("#29B7C8");
    private static final int DEFAULT_NEGATIVE_COLOR = Color.parseColor("#dddddd");
    private static final int DEFAULT_PRIMARY_COLOR = Color.parseColor("#29B7C8");
    private static final int DEFAULT_SECONDARY_COLOR = Color.parseColor("#444444");
    private static final int DEFAULT_POSITIVE_TEXT_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_NEGATIVE_TEXT_COLOR = Color.parseColor("#444444");
    private static final String LAUNCHES = "launches";

    private final Activity activity;
    OnUpdateEventListener onUpdateEventListener;
    SharedPreferences sharedPreferences;
    private String packageName, oldVersionCode, newVersionCode, changes;
    private String updateText, remindText, negativeText;

    private String THEME = "default";
    private String TITLE = "main";
    private int APP_ICON = 0;
    private int CLOSE_ICON = 0;
    private String DESCRIPTION = "desc";
    private String APP_NAME = "app_name";
    private String NOT_NOW = "not_now";
    private String UPDATE = "update_now";
    private int COLOR = 0;
    private int POSITIVE_COLOR = 0;
    private int NEGATIVE_COLOR = 0;
    private int PRIMARY_COLOR = 0;
    private int SECONDARY_COLOR = 0;
    private int POSITIVE_TEXT_COLOR = 0;
    private int NEGATIVE_TEXT_COLOR = 0;
    private int LAUNCH_COUNT = 0;
    private int USER_LAUNCH_COUNT = 0;

    public MiniUpdateChecker(Activity activity) {
        this.activity = activity;
        sharedPreferences = this.activity.getApplicationContext().getSharedPreferences("MiniUpdateChecker", Activity.MODE_PRIVATE);
    }


    public void checkUpdate() {

        if (USER_LAUNCH_COUNT == 0) {
            showDialog();
        } else {

            LAUNCH_COUNT = sharedPreferences.getInt(LAUNCHES, 0);
            sharedPreferences.edit().putInt(LAUNCHES, ++LAUNCH_COUNT).apply();

            if (LAUNCH_COUNT == USER_LAUNCH_COUNT) {
                showDialog();
                sharedPreferences.edit().putInt(LAUNCHES, 0).apply();
            }
        }


    }


    private void showDialog() {

        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // set layout for different theme
        if (THEME.equals(MINI_THEME)) {
            dialog.setContentView(R.layout.minimal_layout);
        } else if (THEME.equals(SIMPLE_THEME)) {
            dialog.setContentView(R.layout.simple_layout);
        } else if (THEME.equals("default")) {
            dialog.setContentView(R.layout.default_layout);
        } else {
            dialog.setContentView(R.layout.default_layout);
        }

        // setting up dialog
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);


        // changes for each theme
        if (THEME.equals(MINI_THEME)) {
            ImageView app_icon = dialog.findViewById(R.id.app_icon);
            ImageView close_icon = dialog.findViewById(R.id.close_icon);
            TextView current_version = dialog.findViewById(R.id.current_version);
            TextView latest_version = dialog.findViewById(R.id.latest_version);
            TextView ur_version_text = dialog.findViewById(R.id.ur_version_text);
            TextView lt_version_text = dialog.findViewById(R.id.lt_version_text);


            if (APP_ICON == 0) {
                app_icon.setImageResource(DEFAULT_APP_ICON);
            } else {
                app_icon.setImageResource(APP_ICON);
            }

            if (CLOSE_ICON == 0) {
                close_icon.setImageResource(DEFAULT_CLOSE_ICON);
            } else {
                close_icon.setImageResource(CLOSE_ICON);
            }

            close_icon.setOnClickListener(view -> dialog.dismiss());


            if (PRIMARY_COLOR == 0) {
                latest_version.setTextColor(DEFAULT_PRIMARY_COLOR);
            } else {
                try {
                    latest_version.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                } catch (Resources.NotFoundException e) {
                    latest_version.setTextColor(PRIMARY_COLOR);
                }
            }

            if (SECONDARY_COLOR == 0) {
                current_version.setTextColor(DEFAULT_SECONDARY_COLOR);
                ur_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);
                lt_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);
            } else {
                try {
                    current_version.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                    ur_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                    lt_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));

                } catch (Resources.NotFoundException e) {

                    current_version.setTextColor(SECONDARY_COLOR);
                    ur_version_text.setTextColor(SECONDARY_COLOR);
                    lt_version_text.setTextColor(SECONDARY_COLOR);

                }
            }


        } else if (THEME.equals(SIMPLE_THEME)) {

            // nothing special
            CardView not_now_button = dialog.findViewById(R.id.not_now_button);


        } else {

            ImageView app_icon = dialog.findViewById(R.id.app_icon);
            ImageView close_icon = dialog.findViewById(R.id.close_icon);
            TextView update_description = dialog.findViewById(R.id.update_description);
            TextView app_name = dialog.findViewById(R.id.app_name);
            TextView current_version = dialog.findViewById(R.id.current_version);
            TextView latest_version = dialog.findViewById(R.id.latest_version);
            TextView ur_version_text = dialog.findViewById(R.id.ur_version_text);
            TextView lt_version_text = dialog.findViewById(R.id.lt_version_text);

            if (APP_ICON == 0) {
                app_icon.setImageResource(DEFAULT_APP_ICON);
            } else {
                app_icon.setImageResource(APP_ICON);
            }

            if (CLOSE_ICON == 0) {
                close_icon.setImageResource(DEFAULT_CLOSE_ICON);
            } else {
                close_icon.setImageResource(CLOSE_ICON);
            }

            if (DESCRIPTION.equals("desc")) {
                update_description.setText(DEFAULT_DESCRIPTION);
            } else {
                update_description.setText(DESCRIPTION);
            }

            if (APP_NAME.equals("app_name")) {
                String appName = "";
                PackageManager packageManager = activity.getPackageManager();
                try {
                    appName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    Log.e("TAG", " Can't find AppName ");
                }
                app_name.setText(appName);

            } else {
                app_name.setText(APP_NAME);
            }

            if (PRIMARY_COLOR == 0) {
                latest_version.setTextColor(DEFAULT_PRIMARY_COLOR);
                app_name.setTextColor(DEFAULT_PRIMARY_COLOR);
            } else {

                try {
                    latest_version.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                    app_name.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));


                } catch (Resources.NotFoundException e) {

                    latest_version.setTextColor(PRIMARY_COLOR);
                    app_name.setTextColor(PRIMARY_COLOR);

                }

            }

            if (SECONDARY_COLOR == 0) {
                current_version.setTextColor(DEFAULT_SECONDARY_COLOR);
                ur_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);
                lt_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);
                update_description.setTextColor(DEFAULT_SECONDARY_COLOR);
            } else {

                try {
                    current_version.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                    ur_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                    lt_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                    update_description.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));

                } catch (Resources.NotFoundException e) {

                    current_version.setTextColor(SECONDARY_COLOR);
                    ur_version_text.setTextColor(SECONDARY_COLOR);
                    lt_version_text.setTextColor(SECONDARY_COLOR);
                    update_description.setTextColor(SECONDARY_COLOR);

                }


            }


            close_icon.setOnClickListener(view -> dialog.dismiss());


        }


        // All Theme
        TextView titleText = dialog.findViewById(R.id.title_text);
        if (TITLE.equals("main")) {
            titleText.setText(DEFAULT_TITLE);
        } else {
            titleText.setText(TITLE);
        }

        if (PRIMARY_COLOR == 0) {
            titleText.setTextColor(DEFAULT_PRIMARY_COLOR);
        } else {

            try {
                titleText.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));

            } catch (Resources.NotFoundException e) {
                titleText.setTextColor(PRIMARY_COLOR);
            }

        }


        CardView wholeView = dialog.findViewById(R.id.main_card);
        if (COLOR == 0) {
            wholeView.setCardBackgroundColor(DEFAULT_COLOR);
        } else {

            try {
                wholeView.setCardBackgroundColor(ContextCompat.getColor(activity, COLOR));
            } catch (Resources.NotFoundException e) {
                wholeView.setCardBackgroundColor(COLOR);
            }

        }


        CardView not_now_button = dialog.findViewById(R.id.not_now_button);
        if (NEGATIVE_COLOR == 0) {
            not_now_button.setCardBackgroundColor(DEFAULT_NEGATIVE_COLOR);
        } else {

            try {
                not_now_button.setCardBackgroundColor(ContextCompat.getColor(activity, NEGATIVE_COLOR));
            } catch (Resources.NotFoundException e) {
                not_now_button.setCardBackgroundColor(NEGATIVE_COLOR);
            }

        }

        CardView update_button = dialog.findViewById(R.id.update_button);
        if (POSITIVE_COLOR == 0) {
            update_button.setCardBackgroundColor(DEFAULT_POSITIVE_COLOR);
        } else {

            try {
                update_button.setCardBackgroundColor(ContextCompat.getColor(activity, POSITIVE_COLOR));
            } catch (Resources.NotFoundException e) {
                update_button.setCardBackgroundColor(POSITIVE_COLOR);
            }

        }


        TextView positive_text = dialog.findViewById(R.id.positive_text);
        if (UPDATE.equals("update_now")) {
            positive_text.setText(DEFAULT_UPDATE);
        } else {
            positive_text.setText(UPDATE);
        }
        if (POSITIVE_TEXT_COLOR == 0) {
            positive_text.setTextColor(DEFAULT_POSITIVE_TEXT_COLOR);
        } else {

            try {
                positive_text.setTextColor(ContextCompat.getColor(activity, POSITIVE_TEXT_COLOR));

            } catch (Resources.NotFoundException e) {
                positive_text.setTextColor(POSITIVE_TEXT_COLOR);
            }

        }


        TextView negative_text = dialog.findViewById(R.id.negative_text);
        if (NOT_NOW.equals("not_now")) {
            negative_text.setText(DEFAULT_NOT_NOW);
        } else {
            negative_text.setText(NOT_NOW);
        }
        if (NEGATIVE_TEXT_COLOR == 0) {
            negative_text.setTextColor(DEFAULT_NEGATIVE_TEXT_COLOR);
        } else {

            try {
                negative_text.setTextColor(ContextCompat.getColor(activity, NEGATIVE_TEXT_COLOR));

            } catch (Resources.NotFoundException e) {
                negative_text.setTextColor(NEGATIVE_TEXT_COLOR);
            }

        }


        not_now_button.setOnClickListener(view -> dialog.dismiss());

        dialog.show();


    }


    public MiniUpdateChecker setTheme(String s) {
        THEME = s;
        return this;

    }

    public MiniUpdateChecker setTitle(String s) {
        TITLE = s;
        return this;
    }

    public MiniUpdateChecker setAppIcon(int i) {
        APP_ICON = i;
        return this;
    }

    public MiniUpdateChecker setCloseIcon(int i) {
        CLOSE_ICON = i;
        return this;
    }


    public MiniUpdateChecker setDescription(String s) {
        DESCRIPTION = s;
        return this;
    }

    public MiniUpdateChecker setAppName(String s) {
        APP_NAME = s;
        return this;
    }

    public MiniUpdateChecker setPositiveLabel(String s) {
        UPDATE = s;
        return this;
    }

    public MiniUpdateChecker setNegativeLabel(String s) {
        NOT_NOW = s;
        return this;
    }

    public MiniUpdateChecker setBackgroundColor(int i) {
        COLOR = i;
        return this;
    }

    public MiniUpdateChecker setPositiveButtonColor(int i) {
        POSITIVE_COLOR = i;
        return this;
    }

    public MiniUpdateChecker setNegativeButtonColor(int i) {
        NEGATIVE_COLOR = i;
        return this;
    }


    public MiniUpdateChecker setPrimaryTextColor(int i) {
        PRIMARY_COLOR = i;
        return this;
    }

    public MiniUpdateChecker setSecondaryTextColor(int i) {
        SECONDARY_COLOR = i;
        return this;
    }


    public MiniUpdateChecker setPositiveTextColor(int i) {
        POSITIVE_TEXT_COLOR = i;
        return this;
    }

    public MiniUpdateChecker setNegativeTextColor(int i) {
        NEGATIVE_TEXT_COLOR = i;
        return this;
    }

    public MiniUpdateChecker shouldCheckAfterLaunch(int i) {
        USER_LAUNCH_COUNT = i;
        return this;

    }

}
