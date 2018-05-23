package com.dobi.interviewandroid.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dobi.interviewandroid.R;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        inti();
    }

    private void inti() {
        //1.添加FragmentTransaction实例
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //2.添加
        TestFragment testFragment = new TestFragment();
        fragmentTransaction.add(R.id.fl,testFragment,"testFragment");

        fragmentTransaction.addToBackStack("testFragment");
        //3.使其生效
        fragmentTransaction.commit();

    }
}
