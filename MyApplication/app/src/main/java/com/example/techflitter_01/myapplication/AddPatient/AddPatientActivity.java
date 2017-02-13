package com.example.techflitter_01.myapplication.AddPatient;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.techflitter_01.myapplication.Adapter.MyPagerAdapter;
import com.example.techflitter_01.myapplication.R;


public class AddPatientActivity extends AppCompatActivity implements AddPatientView {

    ViewPager pager;
    Activity vActivity;
    private AddPatientPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_patient);
        vActivity = this;
        init();
    }

    private void init() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pager = (ViewPager) findViewById(R.id.viewpager);
        presenter = new AddPatientPresenterImpl(this, new MyPagerAdapter(getSupportFragmentManager()));
    }

    public void SetCurrentViewPagerID(int id) {
        pager.setCurrentItem(id);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (pager.getCurrentItem() == 1) {
                    SetCurrentViewPagerID(0);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setAdapter(MyPagerAdapter adapter) {
        pager.setAdapter(adapter);
    }
}
