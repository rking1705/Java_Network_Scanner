package com.networkscanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



/**
 * Java Network Scanner
 * 
 * Network scanning too that checks the status of ports on a given IP address.
 * Stores the results of the network scan to ScanHistory
 * @author Ryan King
 */
//main
public class NetworkScanner {
    // Initialize ports and Scanner
    private static ArrayList<Integer> ports = new ArrayList<>(Arrays.asList(21, 22, 23, 25, 53, 80, 110, 143, 443, 993, 995));
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Allow for user input
        System.out.println("NETWORK SCANNER by Ryan King");

        //Enter the IP address to scan
        System.out.print("Enter the IP address to scan: ");
        String ipAddress = scanner.nextLine();
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            System.err.println("Invalid IP address.");
            return;
        } else if (ipAddress.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")) {
            // IP address is valid
            ipAddress = ipAddress.trim();
        } else {
            System.err.println("Invalid IP address.");
            return;
        }

        //Allow user to choose which ports to scan
        System.out.println("View current port list: ");
        for (int port: ports) {
            System.out.println("Port: " + port);
        }
        System.out.print("Would you like to add more ports? (y/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter the port number to add: ");
            String portInput = scanner.nextLine();
            try {
                int port = Integer.parseInt(portInput);
                ports.add(port);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number.");
            }
        }

        System.out.println("Scanning ports " + Arrays.toString(ports.toArray()) + " on " + ipAddress + "...");
        ScanHistory scanHistory = new ScanHistory();
        com.networkscanner.Scanner portScanner = new com.networkscanner.Scanner();
        ArrayList<ScanResult> results = portScanner.scan(ipAddress, ports);
        scanHistory.addScan(results);
        portScanner.printResults();

        System.out.println("Press enter to view scan history...");
        
    scanner.nextLine(); // waits for user to press Enter
    scanHistory.printHistory();
        
    

    
}}