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
    private static final ArrayList<Integer> DEFAULT_PORTS = new ArrayList<>(Arrays.asList(21, 22, 23, 25, 53, 80, 110, 143, 443, 993, 995));
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Allow for user input
        System.out.println("============================");
        System.out.println("NETWORK SCANNER by Ryan King");
        System.out.println("============================");


        ScanHistory scanHistory = new ScanHistory();
        com.networkscanner.Scanner portScanner = new com.networkscanner.Scanner();

        ArrayList<Integer> ports = new ArrayList<>(DEFAULT_PORTS);


        boolean running = true;

        while (running) {
            System.out.println("\nMenu");
            System.out.println(" 1. Scan an IP address");
            System.out.println(" 2. Manage port list");
            System.out.println(" 3. View scan history");
            System.out.println(" 4. Exit");
            System.out.print("Enter your choice: ");
            String choice = input.nextLine().trim();

            if (choice.equals("1")) {
                // Scan an IP address
                runScan(portScanner, scanHistory, ports);
            } else if (choice.equals("2")) {
                // Manage port list4
                managePorts(ports);
            } else if (choice.equals("3")) {
                // View scan history
                scanHistory.printHistory();
            } else if (choice.equals("4")) {
                // Exit
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }

    private static void runScan(com.networkscanner.Scanner portScanner, ScanHistory scanHistory, ArrayList<Integer> ports) {
        String ip = promptIP();
        if (ip == null) return;

        System.out.println("\nScanning " + ports.size() + " port(s) on " + ip + " ...");
        ArrayList<ScanResult> results = portScanner.scan(ip, ports);
        scanHistory.addScan(results);
        portScanner.printResults(results);
    }

    private static void managePorts(ArrayList<Integer> ports) {
        boolean managing = true;
        while (managing) {
            System.out.println("\nPORT LIST: " + ports);
            System.out.println(" 1. Add a port");
            System.out.println(" 2. Remove a port");
            System.out.println(" 3. Reset to default");
            System.out.println(" 4. Back");
            System.out.println("Enter your choice: ");
            String choice = input.nextLine().trim();

            if (choice.equals("1")) {
                // Add a port
                System.out.print("Enter the port number to add: ");
                String portInput = input.nextLine();
                try {
                    int port = Integer.parseInt(portInput);
                    ports.add(port);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid port number.");
                }
            } else if (choice.equals("2")) {
                // Remove a port
                System.out.print("Enter the port number to remove: ");
                String portInput = input.nextLine();
                try {
                    int port = Integer.parseInt(portInput);
                    ports.remove(Integer.valueOf(port));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid port number.");
                }
            } else if (choice.equals("3")) {
                // Reset to default
                ports.clear();
                ports.addAll(DEFAULT_PORTS);
            } else if (choice.equals("4")) {
                // Back
                managing = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    private static String promptIP() {
        System.out.print("\nEnter IP address to scan: ");
        String ip = input.nextLine().trim();
        String ipv4Pattern =
            "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
            "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        if (ip.isEmpty() || !ip.matches(ipv4Pattern)) {
            System.err.println("Invalid IP address.");
            return null;
        }
        return ip;
    }

    private static Integer parsePort(String s) {
        try {
            int port = Integer.parseInt(s);
            if (port < 1 || port > 65535) throw new NumberFormatException();
            return port;
        } catch (NumberFormatException e) {
            System.err.println("Invalid port — must be a number between 1 and 65535.");
            return null;
        }
    }
}

        

    
