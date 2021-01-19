package com.designpatterns.mgrinf;

import com.designpatterns.mgrinf.singleton.SingletonDesignPattern;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class TestRunner {

    SingletonDesignPattern singletonDP;

    private static Logger logger = Logger.getLogger(TestRunner.class);

    private static final String SHEET_TESTS = "tests";

    private String[] columns;
    private List<String[]> data;
    private XSSFSheet sheet;


    private GUIObserver guiObserver;
    private int totalNumberOfSteps;
    private String currentStep;
    private int numberOfFailedTests = 0;
    private int numberOfSkippedTests = 0;
    private int numberOfPassedTests = 0;
    private ITestListener testListener;

    public TestRunner() {
        singletonDP = new SingletonDesignPattern();
    }

    public TestRunner(GUIObserver guiObserver) {
        this();
        this.guiObserver = guiObserver;
        totalNumberOfSteps = 5;
        guiObserver.onSummaryChanged("Number of steps to run: " + totalNumberOfSteps);

        testListener = new ITestListener() {
            @Override
            public void onTestStart(ITestResult result) {
                currentStep = result.getName();
                updateUI();
            }

            @Override
            public void onTestFailure(ITestResult result) {
                numberOfFailedTests++;
                currentStep = "";
                updateUI();
            }

            @Override
            public void onTestSkipped(ITestResult result) {
                numberOfSkippedTests++;
                currentStep = "";
                updateUI();
            }

            @Override
            public void onTestSuccess(ITestResult result) {
                numberOfPassedTests++;
                currentStep = "";
                updateUI();
            }
        };
    }

    public void runSingletonTests() {
        guiObserver.onSummaryChanged("1. Runned Singleton Pattern Example.");
        TestNG ng = new TestNG();
        ng.setUseDefaultListeners(false);
        ng.addListener(testListener);
        ng.setConfigFailurePolicy(XmlSuite.FailurePolicy.CONTINUE);
        ng.setDefaultSuiteName("Design Paterns Test Suite");
        ng.setDefaultTestName("My DP Test ...");
        ng.setTestClasses(new Class[]{SingletonDesignPattern.class});
        ng.run();
    }

    public void runFactoryTests() {
        //TODO implemenet factory ....
        System.out.println("Factory tests under construction ...");
    }

    private void updateUI() {
        if (guiObserver != null) {
            guiObserver.onSummaryChanged(String.format("Summary changed: %s", true));
            int stepsExecuted = numberOfPassedTests + numberOfFailedTests + numberOfSkippedTests;
            int progress = (stepsExecuted * 100) / totalNumberOfSteps;
            guiObserver.onProgressChanged(progress);
        }
    }

    public static void copyFile(String sourcePath, String targerPath) throws Exception {
        FileInputStream fis = new FileInputStream(new File(sourcePath));
        FileOutputStream fos = new FileOutputStream(new File(targerPath));
        try {
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }
    }
}

