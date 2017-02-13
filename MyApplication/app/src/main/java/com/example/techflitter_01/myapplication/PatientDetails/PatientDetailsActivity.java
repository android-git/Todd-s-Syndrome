package com.example.techflitter_01.myapplication.PatientDetails;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.percentagelib.PatientBean;
import com.example.percentagelib.Percentage;
import com.example.techflitter_01.myapplication.R;
import com.example.techflitter_01.myapplication.Util.AppCont;
import com.example.techflitter_01.myapplication.Util.Utils;
import com.example.techflitter_01.myapplication.db.DatabaseHandler;


public class PatientDetailsActivity extends AppCompatActivity {

    Activity vActivity;
    EditText PatientName;
    EditText PatientContact;
    EditText PatientAge;
    EditText PatientWeight;
    EditText PatientHeight;
    RadioGroup PatientGender;
    RadioButton PatientGenderMale;
    RadioButton PatientGenderFeMale;
    RadioGroup patientMigraineRadioGroup, patientDrugRadioGroup;
    RadioButton patientMigraineYes, patientMigraineNo;
    RadioButton patientDrugYes, patientDrugNo;
    Button BtnPatientSave;
    PatientBean bean;
    private String MigraineCheck = "No";
    private String DrugCheck = "No";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        vActivity = this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bean = (PatientBean) getIntent().getSerializableExtra("PatientBean");
        init();
    }

    private void init() {
        PatientName = (EditText) findViewById(R.id.PatientName);
        PatientContact = (EditText) findViewById(R.id.PatientContact);
        PatientAge = (EditText) findViewById(R.id.PatientAge);
        PatientWeight = (EditText) findViewById(R.id.PatientWeight);
        PatientHeight = (EditText) findViewById(R.id.PatientHeight);
        PatientGender = (RadioGroup) findViewById(R.id.PatientGender);
        patientMigraineRadioGroup = (RadioGroup) findViewById(R.id.patientMigraineRadioGroup);
        patientDrugRadioGroup = (RadioGroup) findViewById(R.id.patientDrugRadioGroup);
        PatientGenderMale = (RadioButton) findViewById(R.id.PatientGenderMale);
        PatientGenderFeMale = (RadioButton) findViewById(R.id.PatientGenderFeMale);
        patientMigraineYes = (RadioButton) findViewById(R.id.patientMigraineYes);
        patientMigraineNo = (RadioButton) findViewById(R.id.patientMigraineNo);
        patientDrugYes = (RadioButton) findViewById(R.id.patientDrugYes);
        patientDrugNo = (RadioButton) findViewById(R.id.patientDrugNo);
        BtnPatientSave = (Button) findViewById(R.id.BtnPatientSave);

        BtnPatientSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();
            }
        });

        setData();
    }

    private void SaveData() {
        if (!isValidate()) {
            return;
        }

        PatientBean patient = new PatientBean();
        patient.setID(bean.getID());
        patient.setName(PatientName.getText().toString());
        patient.setContact(PatientContact.getText().toString());
        patient.setAge(PatientAge.getText().toString());
        patient.setWeight(PatientWeight.getText().toString());
        patient.setHeight(PatientHeight.getText().toString());
        int id = PatientGender.getCheckedRadioButtonId();
        PatientGenderMale = (RadioButton) findViewById(id);
        patient.setGender(PatientGenderMale.getText().toString());
        int Migraineid = patientMigraineRadioGroup.getCheckedRadioButtonId();
        int Drugid = patientDrugRadioGroup.getCheckedRadioButtonId();
        patientMigraineYes = (RadioButton) findViewById(Migraineid);
        MigraineCheck = patientMigraineYes.getText().toString();
        patientDrugYes = (RadioButton) findViewById(Drugid);
        DrugCheck = patientDrugYes.getText().toString();
        patient.setMigraineCheck(MigraineCheck);
        patient.setDrugCheck(DrugCheck);
        patient.setPercentage(String.valueOf(Percentage.getPercentage(patient)));
        if (DatabaseHandler.getInstance(vActivity).updateContact(patient) == 1) {
            Toast.makeText(vActivity, "Patient data updated!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    private boolean isValidate() {
        if (PatientName.getText().toString().trim().length() <= 0) {
            Utils.showToast(vActivity,"Please enter name");
            return false;
        }

        if (PatientContact.getText().toString().trim().length() <= 0) {
            Utils.showToast(vActivity,"Please enter contact number ");
            return false;
        }

        if (PatientAge.getText().toString().trim().length() <= 0) {
            Utils.showToast(vActivity,"Please enter age");
            return false;
        }

        return true;
    }

    private void setData() {
        if (bean != null) {
            PatientName.setText(bean.getName());
            PatientContact.setText(bean.getContact());
            PatientAge.setText(bean.getAge());
            PatientWeight.setText(bean.getWeight());
            PatientHeight.setText(bean.getHeight());
            if (bean.getGender().equalsIgnoreCase("Male")) {
                PatientGenderMale.setChecked(true);
                PatientGenderFeMale.setChecked(false);
            } else {
                PatientGenderMale.setChecked(false);
                PatientGenderFeMale.setChecked(true);
            }
            if (bean.getMigraineCheck().equalsIgnoreCase("Yes")) {
                patientMigraineYes.setChecked(true);
                patientMigraineNo.setChecked(false);
            } else {
                patientMigraineYes.setChecked(false);
                patientMigraineNo.setChecked(true);
            }
            if (bean.getDrugCheck().equalsIgnoreCase("Yes")) {
                patientDrugYes.setChecked(true);
                patientDrugNo.setChecked(false);
            } else {
                patientDrugYes.setChecked(false);
                patientDrugNo.setChecked(true);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
