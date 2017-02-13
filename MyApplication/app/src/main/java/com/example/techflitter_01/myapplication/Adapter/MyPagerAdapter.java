package com.example.techflitter_01.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.techflitter_01.myapplication.Fragement.AddPatientAnsAndQueFragment;
import com.example.techflitter_01.myapplication.Fragement.AddPatientDetailsFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {

            case 0:
                return AddPatientDetailsFragment.newInstance("AddPatientDetailsFragment");
            case 1:
                return AddPatientAnsAndQueFragment.newInstance("AddPatientAnsAndQueFragment");
            default:
                return AddPatientDetailsFragment.newInstance("AddPatientDetailsFragment");
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
