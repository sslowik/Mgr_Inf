package com.designpatterns.mgrinf;

public interface GUIObserver {
    public void onSummaryChanged(String... info);

    public void onProgressChanged(int value);
}
