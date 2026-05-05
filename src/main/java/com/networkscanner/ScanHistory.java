package com.networkscanner;

import java.util.ArrayList;

public class ScanHistory {
    
    private ArrayList<ArrayList<ScanResult>> history = new ArrayList<>();

    public void addScan(ArrayList<ScanResult> results) {
        history.add(results);
    }

    public ArrayList<ArrayList<ScanResult>> getHistory() {
        return history;
    }
    
    public void printHistory() {
        for (ArrayList<ScanResult> scan : history) {
            for (ScanResult result : scan) {
                System.out.println(result);
            }
        }
    }
}
