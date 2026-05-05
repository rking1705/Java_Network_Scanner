package com.networkscanner;
import java.util.*;
import java.net.Socket;
import java.time.LocalDateTime;



public class Scanner {

    // Holds all results
    private ArrayList<ScanResult> results = new ArrayList<>();
    
    public ArrayList<ScanResult> scan(String ip, ArrayList<Integer> ports) {
        // checks each port for services
        for (int port : ports) {
            boolean isPortOpen = checkPort(ip, port);
            String time = LocalDateTime.now().toString();
            results.add(new ScanResult(ip, port, isPortOpen, time));
            // ScanResult(String ipAddress, int port, boolean isPortOpen, String timestamp)
            
        }
        return results;
    }

    private boolean checkPort(String ip, int port) {
        try (Socket socket = new Socket(ip, port)) {
            if (socket.isClosed()) {
                return false;
            } else {
                return true;
        }
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<ScanResult> getResults() {
        return results;
    }
    
    public void printResults() {
        for (ScanResult result : results) {
            System.out.println(result);
        }
    }
}
