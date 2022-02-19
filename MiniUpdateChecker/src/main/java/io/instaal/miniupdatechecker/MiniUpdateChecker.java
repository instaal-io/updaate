package io.instaal.miniupdatechecker;

import android.app.Activity;
import android.content.SharedPreferences;

public class MiniUpdateChecker {

    private Activity activity;
    private String packageName, oldVersionCode, newVersionCode, changes;
    private String updateText, remindText, negativeText;
    OnUpdateEventListener onUpdateEventListener;
    SharedPreferences sharedPreferences;

    public MiniUpdateChecker(Activity activity, SharedPreferences sharedPreferences) {
        this.activity = activity;
        this.sharedPreferences = sharedPreferences;
    }

    public void setUpdateText(String updateText) {
        this.updateText = updateText;

    }


}
