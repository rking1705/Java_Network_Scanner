package com.networkscanner;
import java.util.*;
import java.net.Socket;
import java.time.LocalDateTime;



public class Scanner {

    private static final int TIMEOUT_MS = 500; //500ms per port



    // Holds all results
    
    
    public ArrayList<ScanResult> scan(String ip, ArrayList<Integer> ports) {
        ArrayList<ScanResult> results = new ArrayList<>();
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
        try (Socket socket = new Socket()) {
            //Timeout prevents hanging on closed ports
            socket.connect(new java.net.InetSocketAddress(ip, port), TIMEOUT_MS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    public void printResults(ArrayList<ScanResult> results) {
        long openCount = results.stream().filter(ScanResult::isPortOpen).count();
        System.out.println("\n--- Scan Results (" + openCount + " open / " + results.size() + " scanned) ---");
        results.stream().filter(ScanResult::isPortOpen).forEach(r -> System.out.println(" " + r));
        results.stream().filter(r -> !r.isPortOpen()).forEach(r -> System.out.println(" " + r));
        System.out.println("------------------------------------");
    }
}
