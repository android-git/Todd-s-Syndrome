package com.example.techflitter_01.myapplication.Main;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.percentagelib.PatientBean;
import com.example.techflitter_01.myapplication.Adapter.PatientListAdapter;
import com.example.techflitter_01.myapplication.AddPatient.AddPatientActivity;
import com.example.techflitter_01.myapplication.PatientDetails.PatientDetailsActivity;
import com.example.techflitter_01.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, SearchView.OnQueryTextListener, PatientListAdapter.ItemClickListner {

    private List<PatientBean> vPatientList;
    PatientListAdapter patientListAdapter;
    RecyclerView vRecyclerView;
    Activity vActivity;
    TextView EmptytextView;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vActivity = this;
        init();
    }

    private void init() {
        EmptytextView = (TextView) findViewById(R.id.EmptytextView);
        vRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        vRecyclerView.setLayoutManager(new LinearLayoutManager(vActivity));
        patientListAdapter = new PatientListAdapter(vActivity, vPatientList, this);
        vRecyclerView.setAdapter(patientListAdapter);
        presenter = new MainPresenterImpl(this, new FindItemsInteractorImpl());
    }

    public void ShowEmptyView(boolean b) {
        vRecyclerView.setVisibility(b ? View.GONE : View.VISIBLE);
        EmptytextView.setVisibility(b ? View.VISIBLE : View.GONE);
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
    public void setItems(List<PatientBean> items) {
        this.vPatientList = items;
        patientListAdapter.setvPatientList(vPatientList);
        if (vPatientList.size() == 0) {
            ShowEmptyView(true);
        } else {
            ShowEmptyView(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);//Menu Resource, Menu
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<PatientBean> filteredModelList = filter(vPatientList, query);
        patientListAdapter.setvPatientList(filteredModelList);
        vRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.AddNewPatient:
                Intent intent = new Intent(MainActivity.this, AddPatientActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private static List<PatientBean> filter(List<PatientBean> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<PatientBean> filteredModelList = new ArrayList<>();
        for (PatientBean model : models) {
            final String text = model.getName().toLowerCase();
            final String text2 = model.getContact().toLowerCase();
            if (text.contains(lowerCaseQuery) || text2.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public void onItemClick(int pos, PatientBean bean) {
        Intent intent = new Intent(MainActivity.this, PatientDetailsActivity.class);
        intent.putExtra("PatientBean", bean);
        startActivity(intent);
    }
}
