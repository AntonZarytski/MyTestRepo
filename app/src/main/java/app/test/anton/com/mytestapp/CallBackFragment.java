package app.test.anton.com.mytestapp;

import android.support.v4.app.Fragment;

public interface CallBackFragment {
    void changeFragments(int containerViewId, Fragment newFragment, String tag, boolean addToBackStack);
}
