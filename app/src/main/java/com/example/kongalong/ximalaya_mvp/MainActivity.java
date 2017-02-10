package com.example.kongalong.ximalaya_mvp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kongalong.ximalaya_mvp.fragments.DiscoverFragment;
import com.example.kongalong.ximalaya_mvp.fragments.ListenReadFragment;
import com.example.kongalong.ximalaya_mvp.fragments.LoadListenFragment;
import com.example.kongalong.ximalaya_mvp.fragments.PersonFragment;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {


    private RadioGroup mRadioGroup;

    private Fragment mTempFragment = null;
    private List<Fragment> mFragmentList;
    private FragmentManager mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initView();

        initFragments();

        initRadioGroupListener();

    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }


    private void initRadioGroupListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                        int index = 0;
                        if(checkedId<3){
                            index = checkedId-1;
                        }else{
                            index = checkedId-2;
                        }
                        if(mFragmentList.get(index).isAdded()){
                            mManager.beginTransaction()
                                    .hide(mTempFragment)
                                    .show(mFragmentList.get(index))
                                    .commit();
                            mTempFragment = mFragmentList.get(index);
                        }else{
                            mManager.beginTransaction()
                                    .hide(mTempFragment)
                                    .add(R.id.container,mFragmentList.get(index))
                                    .commit();
                            mTempFragment = mFragmentList.get(index);
                        }
                    }
        });


    }


    private void initFragments() {
        DiscoverFragment discoverFragment = new DiscoverFragment();
        ListenReadFragment listenReadFragment = new ListenReadFragment();
        LoadListenFragment loadListenFragment = new LoadListenFragment();
        PersonFragment personFragment = new PersonFragment();

        mFragmentList = new ArrayList<>();

        mFragmentList.add(discoverFragment);
        mFragmentList.add(listenReadFragment);
        mFragmentList.add(loadListenFragment);
        mFragmentList.add(personFragment);


        mManager = getSupportFragmentManager();
        mManager.beginTransaction()
                .add(R.id.container, mFragmentList.get(0))
                .commit();

        mTempFragment = mFragmentList.get(0);

        ((RadioButton)mRadioGroup.getChildAt(0)).setChecked(true);
    }
}
