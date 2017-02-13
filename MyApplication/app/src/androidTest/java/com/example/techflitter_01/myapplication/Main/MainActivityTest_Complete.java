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
public class MainActivityTest_Complete {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_Complete() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.AddNewPatient), withContentDescription("Add New Patient"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText2.perform(replaceText("Alex"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.PatientContact), isDisplayed()));
        appCompatEditText3.perform(replaceText("123456789"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.PatientContact), withText("123456789"), isDisplayed()));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.PatientAge), isDisplayed()));
        appCompatEditText5.perform(replaceText("15"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.PatientAge), withText("15"), isDisplayed()));
        appCompatEditText6.perform(pressImeActionButton());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.PatientWeight), isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.PatientHeight), isDisplayed()));
        appCompatEditText8.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.BtnPatientNext), withText("Next"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.patientMigraineYes), withText("Yes"),
                        withParent(withId(R.id.patientMigraineRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.submitPatient), withText("Submit"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.AddNewPatient), withContentDescription("Add New Patient"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText9.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.PatientName), isDisplayed()));
        appCompatEditText10.perform(replaceText("Ronnie"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.PatientContact), isDisplayed()));
        appCompatEditText11.perform(replaceText("987654321"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.PatientAge), isDisplayed()));
        appCompatEditText12.perform(replaceText("21"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.PatientGenderFeMale), withText("Female"),
                        withParent(withId(R.id.PatientGender)),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());


            ViewInteraction appCompatButton3 = onView(
                    allOf(withId(R.id.BtnPatientNext), withText("Next"), isDisplayed()));
            appCompatButton3.perform(click());



        ViewInteraction appCompatRadioButton3 = onView(
                allOf(withId(R.id.patientDrugYes), withText("Yes"),
                        withParent(withId(R.id.patientDrugRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton3.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withText("Do You have Migraine?"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatRadioButton4 = onView(
                allOf(withId(R.id.patientMigraineYes), withText("Yes"),
                        withParent(withId(R.id.patientMigraineRadioGroup)),
                        isDisplayed()));
        appCompatRadioButton4.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.submitPatient), withText("Submit"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.action_search), withContentDescription("Search"), isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("ro"), closeSoftKeyboard());



    }

}
