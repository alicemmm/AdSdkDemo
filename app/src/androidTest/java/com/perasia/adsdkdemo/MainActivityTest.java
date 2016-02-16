package com.perasia.adsdkdemo;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    private Intent mainIntent;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
    }

    @MediumTest
    public void testButton_label() {

    }
}
