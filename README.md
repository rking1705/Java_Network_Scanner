## Java Network Scanner
I built a network scanner to better understand how Nmap functions, and to gain familiarity with data structures in Java.
The program attempts identifies ports as OPEN or CLOSED. The program features a list of ports that can be modified to customize scan.
There is also a view scan history feature to avoid repeat identical scans.


## Testing the program against scanme.nmap.com (45.33.32.156)
<img width="1582" height="614" alt="image" src="https://github.com/user-attachments/assets/dee8352f-a3af-4878-bca1-b1ee3baadc8d" />

## Results from terminal 

Menu
 1. Scan an IP address
 2. Manage port list
 3. View scan history
 4. Exit
Enter your choice: 
1

Enter IP address to scan: 
45.33.32.156

Scanning 11 port(s) on 45.33.32.156 ...

--- Scan Results (2 open / 11 scanned) ---
 [2026-09-25T15:48:22.628125600]45.33.32.156:22 --> OPEN
 [2026-09-25T15:48:24.196779400]45.33.32.156:80 --> OPEN
 [2026-09-25T15:48:22.556715]45.33.32.156:21 --> CLOSED
 [2026-09-25T15:48:23.129185100]45.33.32.156:23 --> CLOSED
 [2026-09-25T15:48:23.630234800]45.33.32.156:25 --> CLOSED
 [2026-09-25T15:48:24.132407500]45.33.32.156:53 --> CLOSED
 [2026-09-25T15:48:24.697487200]45.33.32.156:110 --> CLOSED
 [2026-09-25T15:48:25.198504700]45.33.32.156:143 --> CLOSED
 [2026-09-25T15:48:25.699033]45.33.32.156:443 --> CLOSED
 [2026-09-25T15:48:26.199658]45.33.32.156:993 --> CLOSED
 [2026-09-25T15:48:26.701001800]45.33.32.156:995 --> CLOSED
------------------------------------

My scanner correctly identified port 22 and port 80 as OPEN, and the remaining ports as CLOSED.

Here is a screenshot from scanme.nmap.com that produced the same results.
<img width="1368" height="534" alt="image" src="https://github.com/user-attachments/assets/01c629d3-87a1-4b9c-8086-00f4e2dfe7ee" />

I learned how to build a network scanner that correctly identifies TCP ports and produces consistent results.
