package com.example.edittextuitestdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testSubmitButton_expectedCorrectValue() {
        onView(withId(R.id.titleInput)).perform(typeText("Hello"))
        onView(withId(R.id.descriptionInput)).perform(typeText("Raj"), closeSoftKeyboard())

        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withId(R.id.textToShow)).check(matches(withText("Title - Hello | Desc - Raj")))
    }
}