package com.networkscanner;
public class ScanResult {
    private String ipAddress;
    private int port;
    private boolean isPortOpen;
    private String timeStamp;

    public ScanResult(String ipAddress, int port, boolean isPortOpen, String timestamp) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.isPortOpen = isPortOpen;
        this.timeStamp = timestamp;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    public boolean isPortOpen() {
        return isPortOpen;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    @Override 
    public String toString() {
        String label = "";
        if (isPortOpen) {
            label += "OPEN";
        } else {
            label += "CLOSED";
        }
        return "[" + timeStamp + "]" + ipAddress + ":" + port + " --> " + label;
    }

}