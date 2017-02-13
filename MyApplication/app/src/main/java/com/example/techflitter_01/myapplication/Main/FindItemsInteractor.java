package com.example.techflitter_01.myapplication.Main;

import com.example.percentagelib.PatientBean;

import java.util.List;


public interface FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<PatientBean> items);
    }

    void LoadItemFormDB(OnFinishedListener listener);
}
