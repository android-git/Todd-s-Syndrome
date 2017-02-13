package com.example.percentagelib;


import java.io.Serializable;

public class PatientBean implements Serializable {

    private String Name;
    private String Contact;
    private String Age;
    private String Gender;
    private String Weight;
    private String Height;
    private String ID;
    private String Percentage;
    private String MigraineCheck = "No";
    private String DrugCheck = "No";

    public PatientBean(String ID, String name, String contact, String age, String weight, String height, String gender, String migraineCheck, String drugCheck, String percentage) {
        this.Name = name;
        this.Contact = contact;
        this.Age = age;
        this.Gender = gender;
        this.Weight = weight;
        this.Height = height;
        this.ID = ID;
        this.MigraineCheck = migraineCheck;
        this.DrugCheck = drugCheck;
        this.Percentage = percentage;
    }

    public PatientBean() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getMigraineCheck() {
        return MigraineCheck;
    }

    public void setMigraineCheck(String migraineCheck) {
        MigraineCheck = migraineCheck;
    }

    public String getDrugCheck() {
        return DrugCheck;
    }

    public void setDrugCheck(String drugCheck) {
        DrugCheck = drugCheck;
    }
}
