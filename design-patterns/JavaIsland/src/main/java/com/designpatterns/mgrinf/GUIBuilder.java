package com.designpatterns.mgrinf;

import com.designpatterns.mgrinf.singleton.SingletonDesignPattern;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBuilder implements GUIObserver {

    private Logger logger = Logger.getLogger(GUIBuilder.class);
    private TestRunner testRunner;

    private JTextArea summaryTextArea;
    private JProgressBar progressBar;
    private JButton repeatBtn, singletonBtn, factoryBtn, builderBtn, stopBtn;
    private Thread singletonThread, factoryThread, builderThread;

    private boolean isSingletonRunning = false;
    private boolean isFactoryRunning = false;
    private boolean isBuilderRunning = false;

    public GUIBuilder() {
        singletonThread = new Thread() {
            public void run() {
                testRunner.runSingletonTests();
            }
        };

        factoryThread = new Thread() {
            public void run() {
                testRunner.runFactoryTests();
            }
        };
    }

    public void setTestRunner(TestRunner testRunner) {
        this.testRunner = testRunner;
    }

    public void buildGUI() {
        JFrame frame = new JFrame("UG Design Patterns App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setLocation(200, 200);
//        frame.setLayout(new FlowLayout());

        JPanel centerPane = new JPanel();
        summaryTextArea = new JTextArea(10, 25);
        summaryTextArea.setEditable(false);

        JPanel southPane = new JPanel();
        southPane.setLayout(new FlowLayout());

        JPanel northPane = new JPanel();
        northPane.setLayout(new FlowLayout());

        progressBar = new JProgressBar();
        final Dimension progressBarSize = new Dimension(400, progressBar.getPreferredSize().height);
        progressBar.setMinimumSize(progressBarSize);
        progressBar.setPreferredSize(progressBarSize);
        progressBar.setMaximumSize(progressBarSize);

        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        singletonBtn = new JButton("RUN SINGLETON TESTS");
        singletonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSingletonRunning) {
                    singletonThread.interrupt();
                } else {
                    singletonThread.start();
                    singletonBtn.setText("STOP SINGLETON TESTS");
                }
                isSingletonRunning = !isSingletonRunning;
            }
        });

        factoryBtn = new JButton("RUN FACTORY TESTS");
        factoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFactoryRunning) {
                    factoryThread.interrupt();
                } else {
                    factoryThread.start();
                    factoryBtn.setText("STOP FACTORY TESTS");
                }
                isFactoryRunning = !isFactoryRunning;
            }
        });

        builderBtn = new JButton("RUN BUILDER TESTS");
        builderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isBuilderRunning) {
                    builderThread.interrupt();
                } else {
                    builderThread.start();
                    builderBtn.setText("STOP BUILDER TESTS");
                }
                isBuilderRunning = !isBuilderRunning;
            }
        });


        repeatBtn = new JButton("Repeat -> TRUE");
        repeatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (repeatBtn.getText().contains("TRUE")) {
                    SingletonDesignPattern.setRerun(false);
                    repeatBtn.setText("Repeat -> FALSE");
                } else {
                    SingletonDesignPattern.setRerun(true);
                    repeatBtn.setText("Repeat -> TRUE");
                }
            }
        });

        stopBtn = new JButton("Stop App");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Goodbye world of Design Patterns!");
                System.exit(0);
            }
        });

        northPane.add(progressBar, 0);
        northPane.add(repeatBtn, 1);
        northPane.add(stopBtn, 2);

        centerPane.add(summaryTextArea, 0);

        southPane.add(singletonBtn, 0);
        southPane.add(factoryBtn, 1);
        southPane.add(builderBtn, 2);

        frame.add(BorderLayout.NORTH, northPane);
        frame.add(BorderLayout.CENTER, centerPane);
        frame.add(BorderLayout.SOUTH, southPane);
        frame.setVisible(true);
    }

    @Override
    public void onSummaryChanged(String... info) {
        summaryTextArea.setText("");
        for (int i = 0; i < info.length; i++) {
            summaryTextArea.append(info[i] + "\n");
        }
    }

    @Override
    public void onProgressChanged(int value) {
        progressBar.setValue(value);
    }
}
