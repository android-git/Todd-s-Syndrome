package com.example.techflitter_01.myapplication.AddPatient;

import com.example.techflitter_01.myapplication.Adapter.MyPagerAdapter;


public class AddPatientPresenterImpl implements AddPatientPresenter {

    private AddPatientView addPatientView;
    private MyPagerAdapter myPagerAdapter;

    public AddPatientPresenterImpl(AddPatientView addPatientView, MyPagerAdapter myPagerAdapter) {
        this.addPatientView = addPatientView;
        this.myPagerAdapter = myPagerAdapter;
    }

    @Override
    public void onResume() {
        if (addPatientView != null) {
            addPatientView.setAdapter(myPagerAdapter);
        }
    }

    @Override
    public void onDestroy() {
        addPatientView = null;
    }


    public AddPatientView getMainView() {
        return addPatientView;
    }
}
