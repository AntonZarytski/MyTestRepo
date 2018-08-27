package app.test.anton.com.mytestapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestFragmentFirst extends Fragment {
    public static final String TAG = "The First Test Fragment";
    @BindView(R.id.to_second_test_fragment_btn)
    Button toFirstFragment;
    private CallBackFragment callBackFragment;

    public static TestFragmentFirst newInstance() {
        return new TestFragmentFirst();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBackFragment = (CallBackFragment) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment_first, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.to_second_test_fragment_btn)
    public void toFirstFragment() {
        callBackFragment.changeFragments(R.id.main_layout_container, TestFragmentSecond.newInstance(), TestFragmentSecond.TAG, false);
    }

}
