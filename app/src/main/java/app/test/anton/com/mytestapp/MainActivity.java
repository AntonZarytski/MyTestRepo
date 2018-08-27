package app.test.anton.com.mytestapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CallBackFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        initToolbar();
        changeFragments(R.id.main_layout_container, TestFragmentFirst.newInstance(), TestFragmentFirst.TAG, false);
    }

    @Override
    public void changeFragments(int containerViewId, Fragment newFragment, String tag, boolean addToBackStack) {
        if (addToBackStack) {
            //на случай если хотим вернуться по onBackPressed()
            fm.beginTransaction().replace(containerViewId, newFragment, tag).addToBackStack(tag).commitAllowingStateLoss();
        } else {
            fm.beginTransaction().replace(containerViewId, newFragment).commitAllowingStateLoss();
        }
        toolbar.setTitle(tag);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}
