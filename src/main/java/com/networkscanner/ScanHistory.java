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
        if (history.isEmpty()) {
            System.out.println("  No scans recorded yet.");
            return;
        }
        System.out.println("\n========== SCAN HISTORY (" + history.size() + " scan(s)) ==========");
        for (int i = 0; i < history.size(); i++) {
            ArrayList<ScanResult> scan = history.get(i);
            String ip = scan.isEmpty() ? "unknown" : scan.get(0).getIpAddress();
            System.out.println("\n  Scan #" + (i + 1) + " — " + ip);
            for (ScanResult result : scan) {
                System.out.println("    " + result);
            }
        }
        System.out.println("====================================================");
    }
}
