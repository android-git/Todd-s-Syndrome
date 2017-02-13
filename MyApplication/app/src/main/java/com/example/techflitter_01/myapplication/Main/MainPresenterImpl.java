package com.example.techflitter_01.myapplication.Main;

import com.example.percentagelib.PatientBean;

import java.util.List;


public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;

    public MainPresenterImpl(MainView mainView, FindItemsInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        findItemsInteractor.LoadItemFormDB(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<PatientBean> items) {
        if (mainView != null) {
            mainView.setItems(items);
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}
