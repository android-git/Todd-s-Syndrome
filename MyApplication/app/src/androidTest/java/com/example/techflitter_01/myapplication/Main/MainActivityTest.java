package com.example.techflitter_01.myapplication.Main;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.techflitter_01.myapplication.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.AddNewPatient), withContentDescription("Add New Patient"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText2.perform(replaceText("Mark"));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.PatientName), withText("Mark"), isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.PatientContact), isDisplayed()));
        appCompatEditText4.perform(replaceText("250258250"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.PatientContact), withText("250258250"), isDisplayed()));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.PatientAge), isDisplayed()));
        appCompatEditText6.perform(replaceText("22"));

        pressBack();

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.PatientGenderFeMale), withText("Female"),
                        withParent(withId(R.id.PatientGender)),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.PatientGenderMale), withText("Male"),
                        withParent(withId(R.id.PatientGender)),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.BtnPatientNext), withText("Next"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatRadioButton3 = onView(
                allOf(withId(R.id.patientMigraineYes), withText("Yes"),
                        withParent(withId(R.id.patientMigraineRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton3.perform(click());

        ViewInteraction appCompatRadioButton4 = onView(
                allOf(withId(R.id.patientDrugYes), withText("Yes"),
                        withParent(withId(R.id.patientDrugRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton4.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.submitPatient), withText("Submit"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.AddNewPatient), withContentDescription("Add New Patient"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText7.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText8.perform(replaceText("henry"));

        pressBack();

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.BtnPatientNext), withText("Next"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.PatientContact), isDisplayed()));
        appCompatEditText9.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.PatientContact), isDisplayed()));
        appCompatEditText10.perform(replaceText("9999"));

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.PatientAge), isDisplayed()));
        appCompatEditText11.perform(replaceText("90"));

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.PatientWeight), isDisplayed()));
        appCompatEditText12.perform(replaceText("68"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.PatientHeight), isDisplayed()));
        appCompatEditText13.perform(replaceText("5.2"));

        ViewInteraction appCompatRadioButton5 = onView(
                allOf(withId(R.id.PatientGenderFeMale), withText("Female"),
                        withParent(withId(R.id.PatientGender)),
                        isDisplayed()));
        appCompatRadioButton5.perform(click());

        pressBack();

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.BtnPatientNext), withText("Next"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatRadioButton6 = onView(
                allOf(withId(R.id.patientMigraineYes), withText("Yes"),
                        withParent(withId(R.id.patientMigraineRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton6.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.submitPatient), withText("Submit"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.AddNewPatient), withContentDescription("Add New Patient"), isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText14.perform(click());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText15.perform(replaceText("Boss"));

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.PatientContact), isDisplayed()));
        appCompatEditText16.perform(replaceText("3586421"));

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.PatientAge), isDisplayed()));
        appCompatEditText17.perform(replaceText("12"));

        pressBack();

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.BtnPatientNext), withText("Next"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatRadioButton7 = onView(
                allOf(withId(R.id.patientMigraineYes), withText("Yes"),
                        withParent(withId(R.id.patientMigraineRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton7.perform(click());

        ViewInteraction appCompatRadioButton8 = onView(
                allOf(withId(R.id.patientDrugYes), withText("Yes"),
                        withParent(withId(R.id.patientDrugRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton8.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.submitPatient), withText("Submit"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction actionMenuItemView4 = onView(
                allOf(withId(R.id.action_search), withContentDescription("Search"), isDisplayed()));
        actionMenuItemView4.perform(click());

        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("boss"));


    }

}
