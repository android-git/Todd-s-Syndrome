package com.example.techflitter_01.myapplication.Fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.percentagelib.Percentage;
import com.example.techflitter_01.myapplication.R;
import com.example.techflitter_01.myapplication.Util.AppCont;
import com.example.techflitter_01.myapplication.db.DatabaseHandler;
import com.google.gson.Gson;


public class AddPatientAnsAndQueFragment extends Fragment {
    Button submitPatient;
    RadioGroup patientMigraineRadioGroup, patientDrugRadioGroup;
    RadioButton radioButton;
    private String MigraineCheck = "No";
    private String DrugCheck = "No";
    private String GenderMale = "Male";

    //{"Age":"20","Contact":"1234567890","DrugCheck":"No","Gender":"Male","Height":"","MigraineCheck":"Yes","Name":"Vivek","Percentage":"50","Weight":""}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.question_ans_layout, container, false);

        return v;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submitPatient = (Button) view.findViewById(R.id.submitPatient);
        patientMigraineRadioGroup = (RadioGroup) view.findViewById(R.id.patientMigraineRadioGroup);
        patientDrugRadioGroup = (RadioGroup) view.findViewById(R.id.patientDrugRadioGroup);
        submitPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Migraineid = patientMigraineRadioGroup.getCheckedRadioButtonId();
                int Drugid = patientDrugRadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) view.findViewById(Migraineid);
                MigraineCheck = radioButton.getText().toString();
                radioButton = (RadioButton) view.findViewById(Drugid);
                DrugCheck = radioButton.getText().toString();

                AppCont.patient.setMigraineCheck(MigraineCheck);
                AppCont.patient.setDrugCheck(DrugCheck);
                AppCont.patient.setPercentage(String.valueOf(Percentage.getPercentage(AppCont.patient)));
                DatabaseHandler.getInstance(getActivity()).addPatient(AppCont.patient);
                Gson gson = new Gson();
                Log.d("mytag", "Josn::" + gson.toJson(AppCont.patient));
                getActivity().finish();

            }
        });
    }

    public static AddPatientAnsAndQueFragment newInstance(String text) {
        AddPatientAnsAndQueFragment f = new AddPatientAnsAndQueFragment();

        return f;
    }
}
