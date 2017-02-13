package com.example.percentagelib;


public class Percentage {

    public static int getPercentage(PatientBean mPatient) {
        int percentage = 0;
        if (Integer.parseInt(mPatient.getAge()) <= Constants.MaxAge) {
            percentage = percentage + Constants.MinPercentageValue;
        }
        if (mPatient.getGender().equalsIgnoreCase(Constants.Male)) {
            percentage = percentage + Constants.MinPercentageValue;
        }
        if (mPatient.getMigraineCheck().equalsIgnoreCase(Constants.ISTRUE)) {
            percentage = percentage + Constants.MinPercentageValue;
        }
        if (mPatient.getDrugCheck().equalsIgnoreCase(Constants.ISTRUE)) {
            percentage = percentage + Constants.MinPercentageValue;
        }

        return percentage;
    }
}
