package app.test.anton.com.mytestapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestFragmentSecond extends Fragment {
    public static final String TAG = "The Second Test Fragment";
    @BindView(R.id.to_first_fragment_btn)
    Button toSecondFragment;
    private CallBackFragment callBackFragment;

    public static TestFragmentSecond newInstance() {
        return new TestFragmentSecond();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBackFragment = (CallBackFragment) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment_second, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.to_first_fragment_btn)
    public void toSecondFragment() {
        callBackFragment.changeFragments(R.id.main_layout_container, TestFragmentFirst.newInstance(), TestFragmentFirst.TAG, false);
    }

}
