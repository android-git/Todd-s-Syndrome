package com.example.techflitter_01.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.percentagelib.PatientBean;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "PatientManager";

    // Contacts table name
    private static final String TABLE_PATIENT = "Patient";

    // Contacts Table Columns names
    private static final String KEY_ID = "KEY_ID";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_CONTACT = "KEY_CONTACT";
    private static final String KEY_AGE = "KEY_AGE";
    private static final String KEY_WEIGHT = "KEY_WEIGHT";
    private static final String KEY_HEIGHT = "KEY_HEIGHT";
    private static final String KEY_GENDER = "KEY_GENDER";
    private static final String KEY_MIGRATION = "KEY_MIGRATION";
    private static final String KEY_DRUG = "KEY_DRUG";
    private static final String KEY_PERCENTAGE = "KEY_PERCENTAGE";

    public static DatabaseHandler inst;

    public static DatabaseHandler getInstance(Context context) {
        if (inst == null) {
            inst = new DatabaseHandler(context);
        }
        return inst;
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PATIENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_CONTACT + " TEXT,"
                + KEY_AGE + " TEXT,"
                + KEY_WEIGHT + " TEXT,"
                + KEY_HEIGHT + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_MIGRATION + " TEXT,"
                + KEY_DRUG + " TEXT,"
                + KEY_PERCENTAGE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENT);

        // Create tables again
        onCreate(db);
    }

    // Adding new Patient
    public void addPatient(PatientBean vPatient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, vPatient.getName());
        values.put(KEY_CONTACT, vPatient.getContact());
        values.put(KEY_AGE, vPatient.getAge());
        values.put(KEY_WEIGHT, vPatient.getWeight());
        values.put(KEY_HEIGHT, vPatient.getHeight());
        values.put(KEY_GENDER, vPatient.getGender());
        values.put(KEY_MIGRATION, vPatient.getMigraineCheck());
        values.put(KEY_DRUG, vPatient.getDrugCheck());
        values.put(KEY_PERCENTAGE, vPatient.getPercentage());

        // Inserting Row
        db.insert(TABLE_PATIENT, null, values);
        db.close(); // Closing database connection
    }

    // Getting single patient
    public PatientBean getPatient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PATIENT, new String[]{KEY_ID,
                        KEY_NAME, KEY_CONTACT, KEY_AGE, KEY_WEIGHT, KEY_HEIGHT, KEY_GENDER, KEY_MIGRATION, KEY_DRUG, KEY_PERCENTAGE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        PatientBean patient = new PatientBean(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
        // return patient
        return patient;
    }

    // Getting All Patients
    public List<PatientBean> getAllPatients() {
        List<PatientBean> patientList = new ArrayList<PatientBean>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PATIENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PatientBean patient = new PatientBean(cursor.getString(0),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
                // Adding contact to list
                patientList.add(patient);
            } while (cursor.moveToNext());
        }

        // return PatientBean list
        return patientList;
    }

    // Deleting single PatientBean
    public void deletePatient(PatientBean patient) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PATIENT, KEY_ID + " = ?",
                new String[]{patient.getID()});
        db.close();
    }

    public int updateContact(PatientBean vPatient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, vPatient.getName());
        values.put(KEY_CONTACT, vPatient.getContact());
        values.put(KEY_AGE, vPatient.getAge());
        values.put(KEY_WEIGHT, vPatient.getWeight());
        values.put(KEY_HEIGHT, vPatient.getHeight());
        values.put(KEY_GENDER, vPatient.getGender());
        values.put(KEY_MIGRATION, vPatient.getMigraineCheck());
        values.put(KEY_DRUG, vPatient.getDrugCheck());
        values.put(KEY_PERCENTAGE, vPatient.getPercentage());

        // updating row
        return db.update(TABLE_PATIENT, values, KEY_ID + " = ?",
                new String[]{vPatient.getID()});
    }

    // Getting Patients Count
    public int getPatientsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PATIENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
