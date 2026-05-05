# Java Network Scanner

A simple network scanner implemented in Java for educational purposes. This project demonstrates the use of various data structures such as Lists, ArrayLists, LinkedLists, Stacks, and Queues while performing network port scanning.

## Features

- Port scanning for a given IP address
- Custom implementations of data structures:
  - Custom LinkedList for storing results
  - Custom Stack (basic implementation)
- Uses Java's built-in collections: ArrayList, LinkedList (as Queue)

## Prerequisites

- Java 11 or higher
- Maven

## Building the Project

```bash
mvn clean compile
```

## Running the Scanner

```bash
mvn exec:java -Dexec.args="192.168.1.1 1 1024"
```

Replace `192.168.1.1` with the IP address you want to scan, and `1 1024` with the port range.

## Example Output

```
Custom LinkedList results: [22, 80, 443]
Open ports on 192.168.1.1: [22, 80, 443]
```

## Data Structures Used

- **Queue (LinkedList)**: For managing ports to be scanned
- **ArrayList**: For storing open ports
- **Custom LinkedList**: Custom implementation for educational purposes
- **Custom Stack**: Basic stack implementation (for future extensions)

## Learning Objectives

This project helps in understanding:
- Network programming with Java sockets
- Implementation of basic data structures
- Maven project structure
- Command-line argument handling