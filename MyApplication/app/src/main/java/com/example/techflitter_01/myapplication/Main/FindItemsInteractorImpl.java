package com.example.techflitter_01.myapplication.Main;


import android.os.Handler;

import com.example.percentagelib.PatientBean;
import com.example.techflitter_01.myapplication.Application;
import com.example.techflitter_01.myapplication.db.DatabaseHandler;

import java.util.List;

public class FindItemsInteractorImpl implements FindItemsInteractor {

    @Override
    public void LoadItemFormDB(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getAllPatients());
            }
        }, 2000);
    }

    private List<PatientBean> getAllPatients() {
        return DatabaseHandler.getInstance(Application.context()).getAllPatients();
    }
}
