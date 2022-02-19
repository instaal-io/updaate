package io.instaal.miniupdatechecker;

public interface OnUpdateEventListener {

    boolean Success(boolean success, boolean isUpdateAvailable, String newVersion);

}
