package io.instaal.updaate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executors;


public class updaate {

    public static final String SIMPLE_THEME = "simple";
    public static final String DEFAULT_THEME = "default";
    public static final String ADVANCED_THEME = "advanced";
    public static final String ANIMATION_1 = "anim1";
    public static final String ANIMATION_2 = "anim2";
    public static final String ANIMATION_3 = "anim3";
    public static final String ANIMATION_4 = "anim4";
    public static final String ANIMATION_5 = "anim5";
    public static final String ANIMATION_6 = "anim6";
    public static final String ANIMATION_7 = "anim7";
    public static final String ANIMATION_8 = "anim8";
    public static final String ANIMATION_9 = "anim9";
    public static final String IMAGE_1 = "img1";
    public static final String IMAGE_2 = "img2";
    public static final String IMAGE_3 = "img3";
    public static final String IMAGE_4 = "img4";
    public static final String IMAGE_5 = "img5";
    public static final String IMAGE_6 = "img6";
    public static final String IMAGE_7 = "img7";
    public static final String IMAGE_8 = "img8";
    public static final String IMAGE_9 = "img9";
    private static final String DEFAULT_TITLE = "New Update Available";
    private static final int DEFAULT_APP_ICON = R.drawable.update_icon_main;
    private static final int DEFAULT_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_NEGATIVE_COLOR = Color.parseColor("#dddddd");
    private static final int DEFAULT_PRIMARY_COLOR = Color.parseColor("#5a3ae7");
    private static final int DEFAULT_SECONDARY_COLOR = Color.parseColor("#666666");
    private static final int DEFAULT_POSITIVE_TEXT_COLOR = Color.parseColor("#FFFFFF");
    private static final String LAUNCHES = "launches";
    private final Activity activity;
    SharedPreferences sharedPreferences;
    private String THEME = "default";
    private String TITLE = "main";
    private int APP_ICON = 0;
    private String NOT_NOW = "not_now";
    private String UPDATE = "update_now";
    private int COLOR = 0;
    private int NEGATIVE_COLOR = 0;
    private int PRIMARY_COLOR = 0;
    private int SECONDARY_COLOR = 0;
    private int POSITIVE_TEXT_COLOR = 0;
    private int ICON_COLOR = 0;
    private int USER_LAUNCH_COUNT = 0;
    private String CURRENT_VERSION = "";
    private String LATEST_VERSION = "";
    private boolean isImageOn = false;
    private String ANIM_SELECT = "0";
    private String IMAGE_SELECT = "0";
    private boolean isCancelable = true;
    private boolean hideNegativeButton = false;
    private int cardCornerRadius = 10;
    private int buttonCornerRadius = 10;

    public updaate(Activity activity) {
        this.activity = activity;
        sharedPreferences = this.activity.getApplicationContext().getSharedPreferences("updaate", Activity.MODE_PRIVATE);
    }


    public void check() {

        PackageManager packageManager = activity.getPackageManager();
        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            CURRENT_VERSION = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        if (USER_LAUNCH_COUNT == 0) {
            CheckForUpdate();

        } else {

            int LAUNCH_COUNT = sharedPreferences.getInt(LAUNCHES, 0);
            sharedPreferences.edit().putInt(LAUNCHES, ++LAUNCH_COUNT).apply();

            if (LAUNCH_COUNT >= USER_LAUNCH_COUNT) {
                CheckForUpdate();
                sharedPreferences.edit().putInt(LAUNCHES, 0).apply();
            }
        }

    }

    // Done
    private void CheckForUpdate() {

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
//                LATEST_VERSION = Objects.requireNonNull(Jsoup.connect("https://play.google.com/store/apps/details?id=" + activity.getPackageName() + "&hl=en")
//                        .timeout(30000)
//                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
//                        .referrer("http://www.google.com")
//                        .get()
//                        .select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
//                        .first())
//                        .ownText();
                LATEST_VERSION = Objects.requireNonNull(Jsoup.connect("https://play.google.com/store/apps/details?id=com.andronius.numberconverterplus&hl=en")
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                        .first())
                        .ownText();

                activity.runOnUiThread(() -> ValidateUpdate(LATEST_VERSION));

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TAG", "CheckForUpdate: Not Found");
            }
        });


    }


    private void ValidateUpdate(String latest_version) {

        if (!latest_version.equals(CURRENT_VERSION)) {
            chooseDialog();
        } else {
            Log.d("TAG", "ValidateUpdate: Already Latest Version");
        }


    }

    private void chooseDialog() {
        switch (THEME) {
            case ADVANCED_THEME:
                showAdvancedDialog();
                break;
            case SIMPLE_THEME:
                showSimpleDialog();
                break;
            case DEFAULT_THEME:
            default:
                showDefaultDialog();
                break;
        }

    }


    // Done
    @SuppressLint("SetTextI18n")
    private void showSimpleDialog() {

        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(isCancelable);
        dialog.setContentView(R.layout.simple_layout);

        TextView titleText = dialog.findViewById(R.id.title_text);
        TextView current_version = dialog.findViewById(R.id.current_version);
        TextView latest_version = dialog.findViewById(R.id.latest_version);
        TextView ur_version_text = dialog.findViewById(R.id.ur_version_text);
        TextView lt_version_text = dialog.findViewById(R.id.lt_version_text);
        CardView update_button = dialog.findViewById(R.id.update_button);
        CardView not_now_button = dialog.findViewById(R.id.not_now_button);
        TextView negative_text = dialog.findViewById(R.id.negative_text);
        TextView positive_text = dialog.findViewById(R.id.positive_text);
        ImageView app_icon = dialog.findViewById(R.id.app_icon);

        if (APP_ICON == 0) {
            app_icon.setImageResource(DEFAULT_APP_ICON);
        } else {
            app_icon.setImageResource(APP_ICON);
        }

        if (TITLE.equals("main")) {
            titleText.setText(DEFAULT_TITLE);
        } else {
            titleText.setText(TITLE);
        }

        if (UPDATE.equals("update_now")) {
            positive_text.setText("Update");
        } else {
            positive_text.setText(UPDATE);
        }

        if (NOT_NOW.equals("not_now")) {
            negative_text.setText("Not Now");
        } else {
            negative_text.setText(NOT_NOW);
        }


        // primary colors

        if (PRIMARY_COLOR == 0) {
            update_button.setCardBackgroundColor(DEFAULT_PRIMARY_COLOR);
            lt_version_text.setTextColor(DEFAULT_PRIMARY_COLOR);
            latest_version.setTextColor(DEFAULT_PRIMARY_COLOR);

        } else {
            try {
                update_button.setCardBackgroundColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                lt_version_text.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                latest_version.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));


            } catch (Resources.NotFoundException e) {
                update_button.setCardBackgroundColor(PRIMARY_COLOR);
                lt_version_text.setTextColor(PRIMARY_COLOR);
                latest_version.setTextColor(PRIMARY_COLOR);

            }
        }

        // secondary colors
        if (SECONDARY_COLOR == 0) {
            titleText.setTextColor(DEFAULT_SECONDARY_COLOR);
            negative_text.setTextColor(DEFAULT_SECONDARY_COLOR);
            current_version.setTextColor(DEFAULT_SECONDARY_COLOR);
            ur_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);

        } else {
            try {
                negative_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                current_version.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                ur_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                titleText.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));


            } catch (Resources.NotFoundException e) {
                negative_text.setTextColor(SECONDARY_COLOR);
                current_version.setTextColor(SECONDARY_COLOR);
                ur_version_text.setTextColor(SECONDARY_COLOR);
                titleText.setTextColor(SECONDARY_COLOR);


            }
        }


        if (NEGATIVE_COLOR == 0) {
            not_now_button.setCardBackgroundColor(DEFAULT_NEGATIVE_COLOR);

        } else {
            try {
                not_now_button.setCardBackgroundColor(ContextCompat.getColor(activity, NEGATIVE_COLOR));

            } catch (Resources.NotFoundException e) {

                not_now_button.setCardBackgroundColor(NEGATIVE_COLOR);

            }
        }

        // Positive Button Text Color
        if (POSITIVE_TEXT_COLOR == 0) {
            positive_text.setTextColor(DEFAULT_POSITIVE_TEXT_COLOR);

        } else {
            try {
                positive_text.setTextColor(ContextCompat.getColor(activity, POSITIVE_TEXT_COLOR));

            } catch (Resources.NotFoundException e) {
                positive_text.setTextColor(POSITIVE_TEXT_COLOR);


            }
        }


        // background color
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

        not_now_button.setOnClickListener(view -> dialog.dismiss());
        update_button.setOnClickListener(view -> {
                    dialog.dismiss();
                    launchForUpdate();
                }
        );


        current_version.setText(CURRENT_VERSION);
        latest_version.setText(LATEST_VERSION);

        dialog.show();
    }


    // Done
    @SuppressLint("SetTextI18n")
    private void showDefaultDialog() {

        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(isCancelable);
        dialog.setContentView(R.layout.default_layout);


        TextView titleText = dialog.findViewById(R.id.title_text);
        TextView current_version = dialog.findViewById(R.id.current_version);
        TextView latest_version = dialog.findViewById(R.id.latest_version);
        TextView ur_version_text = dialog.findViewById(R.id.ur_version_text);
        TextView lt_version_text = dialog.findViewById(R.id.lt_version_text);
        CardView update_button = dialog.findViewById(R.id.update_button);
        CardView not_now_button = dialog.findViewById(R.id.not_now_button);
        TextView negative_text = dialog.findViewById(R.id.negative_text);
        TextView positive_text = dialog.findViewById(R.id.positive_text);
        ImageView app_icon = dialog.findViewById(R.id.app_icon);
        CardView wholeView = dialog.findViewById(R.id.main_card);


        if (APP_ICON == 0) {
            app_icon.setImageResource(DEFAULT_APP_ICON);
        } else {
            app_icon.setImageResource(APP_ICON);
        }

        if (TITLE.equals("main")) {
            titleText.setText(DEFAULT_TITLE);
        } else {
            titleText.setText(TITLE);
        }

        if (UPDATE.equals("update_now")) {
            positive_text.setText("Update");
        } else {
            positive_text.setText(UPDATE);
        }

        if (NOT_NOW.equals("not_now")) {
            negative_text.setText("Not Now");
        } else {
            negative_text.setText(NOT_NOW);
        }

        if (hideNegativeButton) {
            not_now_button.setVisibility(View.GONE);
        } else {
            not_now_button.setVisibility(View.VISIBLE);
        }


        // primary colors
        if (PRIMARY_COLOR == 0) {
            titleText.setTextColor(DEFAULT_PRIMARY_COLOR);
            update_button.setCardBackgroundColor(DEFAULT_PRIMARY_COLOR);
            lt_version_text.setTextColor(DEFAULT_PRIMARY_COLOR);
            latest_version.setTextColor(DEFAULT_PRIMARY_COLOR);

        } else {
            try {
                update_button.setCardBackgroundColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                lt_version_text.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                latest_version.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                titleText.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));


            } catch (Resources.NotFoundException e) {
                update_button.setCardBackgroundColor(PRIMARY_COLOR);
                lt_version_text.setTextColor(PRIMARY_COLOR);
                latest_version.setTextColor(PRIMARY_COLOR);
                titleText.setTextColor(PRIMARY_COLOR);

            }
        }


        if (ICON_COLOR != 0) {
            try {
                app_icon.setColorFilter(ContextCompat.getColor(activity, ICON_COLOR));


            } catch (Resources.NotFoundException e) {

                app_icon.setColorFilter(ICON_COLOR);
            }
        }

        // secondary colors
        if (SECONDARY_COLOR == 0) {
            negative_text.setTextColor(DEFAULT_SECONDARY_COLOR);
            current_version.setTextColor(DEFAULT_SECONDARY_COLOR);
            ur_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);

        } else {
            try {
                negative_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                current_version.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                ur_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));


            } catch (Resources.NotFoundException e) {
                negative_text.setTextColor(SECONDARY_COLOR);
                current_version.setTextColor(SECONDARY_COLOR);
                ur_version_text.setTextColor(SECONDARY_COLOR);


            }
        }


        if (NEGATIVE_COLOR == 0) {
            not_now_button.setCardBackgroundColor(DEFAULT_NEGATIVE_COLOR);

        } else {
            try {
                not_now_button.setCardBackgroundColor(ContextCompat.getColor(activity, NEGATIVE_COLOR));

            } catch (Resources.NotFoundException e) {

                not_now_button.setCardBackgroundColor(NEGATIVE_COLOR);

            }
        }

        // Positive Button Text Color
        if (POSITIVE_TEXT_COLOR == 0) {
            positive_text.setTextColor(DEFAULT_POSITIVE_TEXT_COLOR);

        } else {
            try {
                positive_text.setTextColor(ContextCompat.getColor(activity, POSITIVE_TEXT_COLOR));

            } catch (Resources.NotFoundException e) {
                positive_text.setTextColor(POSITIVE_TEXT_COLOR);


            }
        }


        // background color
        if (COLOR == 0) {
            wholeView.setCardBackgroundColor(DEFAULT_COLOR);
        } else {

            try {
                wholeView.setCardBackgroundColor(ContextCompat.getColor(activity, COLOR));
            } catch (Resources.NotFoundException e) {
                wholeView.setCardBackgroundColor(COLOR);
            }

        }

        wholeView.setRadius(cardCornerRadius * 4);
        not_now_button.setRadius(buttonCornerRadius * 4);
        update_button.setRadius(buttonCornerRadius * 4);

        current_version.setText(CURRENT_VERSION);
        latest_version.setText(LATEST_VERSION);

        not_now_button.setOnClickListener(view -> dialog.dismiss());
        update_button.setOnClickListener(view -> {
                    dialog.dismiss();
                    launchForUpdate();
                }
        );

        dialog.show();
    }

    // Done
    @SuppressLint("SetTextI18n")
    private void showAdvancedDialog() {

        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(isCancelable);
        dialog.setContentView(R.layout.advanced_layout);

        TextView titleText = dialog.findViewById(R.id.title_text);
        TextView current_version = dialog.findViewById(R.id.current_version);
        TextView latest_version = dialog.findViewById(R.id.latest_version);
        TextView ur_version_text = dialog.findViewById(R.id.ur_version_text);
        TextView lt_version_text = dialog.findViewById(R.id.lt_version_text);
        CardView update_button = dialog.findViewById(R.id.update_button);
        TextView negative_text = dialog.findViewById(R.id.negative_text);
        TextView positive_text = dialog.findViewById(R.id.positive_text);

        LottieAnimationView lottieAnimationView = dialog.findViewById(R.id.animation_view);

        switch (ANIM_SELECT) {
            case ANIMATION_2:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_2);
                break;
            case ANIMATION_3:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_3);
                break;
            case ANIMATION_4:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_4);
                break;
            case ANIMATION_5:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_5);
                break;
            case ANIMATION_6:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_6);
                break;
            case ANIMATION_7:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_7);
                break;
            case ANIMATION_8:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_8);
                break;
            case ANIMATION_9:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_9);
                break;
            case ANIMATION_1:
            default:
                lottieAnimationView.setAnimation(R.raw.fancy_anim_1);
                break;
        }


        ImageView imageView = dialog.findViewById(R.id.imageView);

        switch (IMAGE_SELECT) {
            case IMAGE_2:
                imageView.setImageResource(R.drawable.img_2);
                break;
            case IMAGE_3:
                imageView.setImageResource(R.drawable.img_3);
                break;
            case IMAGE_4:
                imageView.setImageResource(R.drawable.img_4);
                break;
            case IMAGE_5:
                imageView.setImageResource(R.drawable.img_5);
                break;
            case IMAGE_6:
                imageView.setImageResource(R.drawable.img_6);
                break;
            case IMAGE_7:
                imageView.setImageResource(R.drawable.img_7);
                break;
            case IMAGE_8:
                imageView.setImageResource(R.drawable.img_8);
                break;
            case IMAGE_9:
                imageView.setImageResource(R.drawable.img_9);
                break;
            case IMAGE_1:
            default:
                imageView.setImageResource(R.drawable.img_1);
                break;
        }


        if (isImageOn) {
            lottieAnimationView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        } else {
            lottieAnimationView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        }

        if (TITLE.equals("main")) {
            titleText.setText(DEFAULT_TITLE);
        } else {
            titleText.setText(TITLE);
        }

        if (UPDATE.equals("update_now")) {
            positive_text.setText("Update Now");
        } else {
            positive_text.setText(UPDATE);
        }

        if (NOT_NOW.equals("not_now")) {
            negative_text.setText("Maybe Later");
        } else {
            negative_text.setText(NOT_NOW);
        }

        if (hideNegativeButton) {
            negative_text.setVisibility(View.GONE);
        } else {
            negative_text.setVisibility(View.VISIBLE);
        }

        // primary colors

        if (PRIMARY_COLOR == 0) {
            update_button.setCardBackgroundColor(DEFAULT_PRIMARY_COLOR);
            titleText.setTextColor(DEFAULT_PRIMARY_COLOR);
            lt_version_text.setTextColor(DEFAULT_PRIMARY_COLOR);
            latest_version.setTextColor(DEFAULT_PRIMARY_COLOR);

        } else {
            try {
                update_button.setCardBackgroundColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                titleText.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                lt_version_text.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));
                latest_version.setTextColor(ContextCompat.getColor(activity, PRIMARY_COLOR));


            } catch (Resources.NotFoundException e) {
                update_button.setCardBackgroundColor(PRIMARY_COLOR);
                titleText.setTextColor(PRIMARY_COLOR);
                lt_version_text.setTextColor(PRIMARY_COLOR);
                latest_version.setTextColor(PRIMARY_COLOR);


            }
        }

        // secondary colors
        if (SECONDARY_COLOR == 0) {
            negative_text.setTextColor(DEFAULT_SECONDARY_COLOR);
            current_version.setTextColor(DEFAULT_SECONDARY_COLOR);
            ur_version_text.setTextColor(DEFAULT_SECONDARY_COLOR);

        } else {
            try {
                negative_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                current_version.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));
                ur_version_text.setTextColor(ContextCompat.getColor(activity, SECONDARY_COLOR));


            } catch (Resources.NotFoundException e) {
                negative_text.setTextColor(SECONDARY_COLOR);
                current_version.setTextColor(SECONDARY_COLOR);
                ur_version_text.setTextColor(SECONDARY_COLOR);


            }
        }

        // Positive Button Text Color
        if (POSITIVE_TEXT_COLOR == 0) {
            positive_text.setTextColor(DEFAULT_POSITIVE_TEXT_COLOR);

        } else {
            try {
                positive_text.setTextColor(ContextCompat.getColor(activity, POSITIVE_TEXT_COLOR));

            } catch (Resources.NotFoundException e) {
                positive_text.setTextColor(POSITIVE_TEXT_COLOR);


            }
        }


        // background color
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

        negative_text.setOnClickListener(view -> dialog.dismiss());

        update_button.setOnClickListener(view -> {
                    dialog.dismiss();
                    launchForUpdate();
                }
        );


        wholeView.setRadius(cardCornerRadius * 4);
        update_button.setRadius(buttonCornerRadius * 4);

        current_version.setText(CURRENT_VERSION);
        latest_version.setText(LATEST_VERSION);

        dialog.show();
    }


    private void launchForUpdate() {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }
    }


    public updaate setTheme(String string) {
        THEME = string;
        return this;

    }

    public updaate setTitle(String string) {
        TITLE = string;
        return this;
    }

    public updaate setAppIcon(int res) {
        APP_ICON = res;
        return this;
    }


    public updaate setPositiveLabel(String string) {
        UPDATE = string;
        return this;
    }

    public updaate setNegativeLabel(String string) {
        NOT_NOW = string;
        return this;
    }

    public updaate setBackgroundColor(int color) {
        COLOR = color;
        return this;
    }


    public updaate setNegativeButtonColor(int color) {
        NEGATIVE_COLOR = color;
        return this;
    }


    public updaate setPrimaryColor(int color) {
        PRIMARY_COLOR = color;
        return this;
    }

    public updaate setSecondaryColor(int color) {
        SECONDARY_COLOR = color;
        return this;
    }


    public updaate setPositiveTextColor(int color) {
        POSITIVE_TEXT_COLOR = color;
        return this;
    }

    public updaate setIconColor(int color) {
        ICON_COLOR = color;
        return this;
    }

    public updaate shouldCheckAfterLaunch(int launch) {
        USER_LAUNCH_COUNT = launch;
        return this;

    }

    public updaate useImageInsteadAnim(boolean trueOrfalse) {
        isImageOn = trueOrfalse;
        return this;
    }

    public updaate setHeaderAnimation(String animationName) {
        ANIM_SELECT = animationName;
        return this;
    }

    public updaate setHeaderImage(String imageName) {
        IMAGE_SELECT = imageName;
        return this;

    }

    public updaate setCancelable(boolean cancelable) {
        isCancelable = cancelable;
        return this;
    }

    public updaate hideNegativeButton(boolean hide) {
        hideNegativeButton = hide;
        return this;
    }

    public updaate setButtonCornerRadius(int cornerRadius) {
        buttonCornerRadius = cornerRadius;
        return this;
    }

    public updaate setDialogCornerRadius(int cornerRadius) {
        cardCornerRadius = cornerRadius;
        return this;
    }

}
