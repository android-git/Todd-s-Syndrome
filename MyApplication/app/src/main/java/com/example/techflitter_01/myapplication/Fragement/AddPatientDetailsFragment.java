package com.example.techflitter_01.myapplication.Fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.percentagelib.PatientBean;
import com.example.techflitter_01.myapplication.AddPatient.AddPatientActivity;
import com.example.techflitter_01.myapplication.R;
import com.example.techflitter_01.myapplication.Util.AppCont;
import com.example.techflitter_01.myapplication.Util.Utils;


public class AddPatientDetailsFragment extends Fragment {

    EditText PatientName;
    EditText PatientContact;
    EditText PatientAge;
    EditText PatientWeight;
    EditText PatientHeight;
    RadioGroup PatientGender;
    RadioButton PatientGenderMale;
    Button BtnPatientNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_patient_detail, container, false);

        return v;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PatientName = (EditText) view.findViewById(R.id.PatientName);
        PatientContact = (EditText) view.findViewById(R.id.PatientContact);
        PatientAge = (EditText) view.findViewById(R.id.PatientAge);
        PatientWeight = (EditText) view.findViewById(R.id.PatientWeight);
        PatientHeight = (EditText) view.findViewById(R.id.PatientHeight);
        PatientGender = (RadioGroup) view.findViewById(R.id.PatientGender);
        BtnPatientNext = (Button) view.findViewById(R.id.BtnPatientNext);

        BtnPatientNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidate()) {
                    return;
                }
                PatientBean patient = new PatientBean();
                patient.setName(PatientName.getText().toString());
                patient.setContact(PatientContact.getText().toString());
                patient.setAge(PatientAge.getText().toString());
                patient.setWeight(PatientWeight.getText().toString());
                patient.setHeight(PatientHeight.getText().toString());
                int id = PatientGender.getCheckedRadioButtonId();
                PatientGenderMale = (RadioButton) view.findViewById(id);
                patient.setGender(PatientGenderMale.getText().toString());
                AppCont.patient = patient;
                ((AddPatientActivity) getActivity()).SetCurrentViewPagerID(1);
            }
        });
    }

    private boolean isValidate() {
        if (PatientName.getText().toString().trim().length() <= 0) {
            Utils.showToast(getContext(), "Please enter name");
            return false;
        }

        if (PatientContact.getText().toString().trim().length() <= 0) {
            Utils.showToast(getContext(), "Please enter contact number ");
            return false;
        }

        if (PatientAge.getText().toString().trim().length() <= 0) {
            Utils.showToast(getContext(), "Please enter age");
            return false;
        }

        return true;
    }


    public static AddPatientDetailsFragment newInstance(String text) {
        AddPatientDetailsFragment f = new AddPatientDetailsFragment();

        return f;
    }
}
