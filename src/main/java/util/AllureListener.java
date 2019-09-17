package util;

import io.qameta.allure.Attachment;
//import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.BaseSteps;

import static steps.BaseSteps.takeScreenshot;

public class AllureListener extends RunListener {
    @Override
    public void testFailure(Failure failure) throws Exception {
        takeScreenshot();
        super.testFailure(failure);
    }


}


