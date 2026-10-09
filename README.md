
# 🚨 Emergency Disaster Route Planner

A Java-based Data Structures and Algorithms (DSA) project designed to help plan emergency routes, manage emergency requests by priority, and reroute vehicles when roads become blocked.

## 📌 Project Overview

During disasters such as floods, accidents, and other emergencies, reaching hospitals, rescue centers, and affected areas quickly is crucial.

The Emergency Disaster Route Planner simulates an emergency transportation network using a weighted, undirected graph. It calculates shortest routes, handles reported road blockages, and organizes emergency requests according to their priority.

The project demonstrates the practical application of graph algorithms and data structures in emergency response planning.

## 🎯 Objectives

- Find the shortest available route between two stations.
- Manage emergency requests according to their priority.
- Reroute vehicles when a road becomes blocked.
- Display stations and connections in the network.
- Maintain a history of completed emergency operations.
- Apply DSA concepts to a practical, real-world-inspired problem.

## ✨ Features

### 1. Shortest Emergency Route
Uses **Dijkstra's Algorithm** to calculate the shortest available route between a source station and a destination station.

### 2. Emergency Request Management
Accepts emergency requests and organizes pending requests using a **Priority Queue**, allowing higher-priority emergencies to be processed first.

### 3. Road Blockage and Rerouting
Allows a user to report a blocked road. The system updates the graph and runs Dijkstra's Algorithm again to find an alternative route from the vehicle's current station to its destination.

### 4. Network Display
Displays the available stations and their road connections, including blocked roads.

### 5. Emergency History
Maintains records of completed emergency operations using a custom **Singly Linked List**. Users can view and search previous records.

## 🧠 Data Structures and Algorithms Used

| Concept | Application |
|---|---|
| Graph | Represents stations and road connections |
| Adjacency List | Stores connections between stations |
| Dijkstra's Algorithm | Finds the shortest available route |
| Priority Queue | Processes pending emergencies by priority |
| Singly Linked List | Stores emergency history |
| Classes and Objects | Organizes the project into modular components |
| Switch-Case | Handles the main menu operations |

## 🏗️ Project Structure

```text
Emergency-Disaster-Route-Planner/
│
├── src/
│   ├── Main.java
│   ├── Graph.java
│   ├── Edge.java
│   ├── RoadBlockage.java
│   ├── EmergencyRequest.java
│   ├── EmergencyManager.java
│   ├── EmergencyRecord.java
│   └── EmergencyHistory.java
│
└── README.md
```

### File Responsibilities

- **Main.java** — Displays the main menu, accepts user input, and controls operations using switch-case.
- **Graph.java** — Represents the network and implements Dijkstra's shortest-path algorithm.
- **Edge.java** — Stores the destination station, road distance, and blocked status of a connection.
- **RoadBlockage.java** — Handles road blockage reports and requests route recalculation.
- **EmergencyRequest.java** — Represents an individual emergency request, including its source, destination, type, priority, and status.
- **EmergencyManager.java** — Manages pending emergency requests using a priority queue.
- **EmergencyRecord.java** — Represents one emergency record containing route details and outcome.
- **EmergencyHistory.java** — Stores and searches completed emergency records using a singly linked list.

## 🔄 Overall Program Flow

When the program starts, the following main menu is displayed:

```text
========================================
   EMERGENCY DISASTER ROUTE PLANNER
========================================

1. File a New Emergency
2. Process Next Emergency
3. Find Shortest Emergency Route
4. Report Road Blockage and Reroute
5. View Stations and Connections
6. View Emergency History
7. Search Emergency History
0. Exit

Enter your choice:
```

### 1. File a New Emergency

The user enters the emergency details, including the source station, destination station, emergency type, and priority.

```text
--- FILE A NEW EMERGENCY ---

Enter Request ID: E101
Enter Source Station: A
Enter Destination Station: D
Enter Emergency Type: Medical Emergency
Enter Priority (1 = Highest): 1

Emergency request filed successfully!
Request ID: E101
Status: Pending
```

The request is added to the priority queue and waits to be processed.

### 2. Process Next Emergency

The system selects the highest-priority pending emergency from the priority queue and calculates a route for it.

```text
--- PROCESS NEXT EMERGENCY ---

Processing the highest-priority emergency...

Request ID: E101
Emergency Type: Medical Emergency
Source: A
Destination: D

Calculating the shortest available route...

Route: A -> B -> D
Total Distance: 9 km
Status: Processing
```

If the priority queue is empty:

```text
No pending emergency requests.
```

Once the emergency operation is completed, its status and outcome are updated, and its record is added to emergency history.

### 3. Find Shortest Emergency Route

The user enters a source and destination station. The system uses Dijkstra's Algorithm to find the shortest available route.

```text
--- FIND SHORTEST EMERGENCY ROUTE ---

Enter Source Station: A
Enter Destination Station: D

Calculating shortest route...

Shortest Route: A -> B -> D
Total Distance: 9 km
```

If no available route exists:

```text
No available route between the selected stations.
```

If a station does not exist:

```text
Invalid station. Please enter a valid station.
```

### 4. Report Road Blockage and Reroute

The user reports a blocked road and enters the vehicle's current station and destination.

```text
--- ROAD BLOCKAGE AND REROUTING ---

Enter blocked road's first station: B
Enter blocked road's second station: C
Enter vehicle's current station: B
Enter destination station: D
Enter reason for blockage: Flood

Road B-C marked as blocked.
Recalculating the route...

New Route: B -> E -> D
Total Distance: 9 km
```

The system updates the graph and runs Dijkstra's Algorithm again, ignoring the blocked road.

If no alternative route exists:

```text
No alternative route is available.
Please seek further assistance.
```

If the reported road does not exist:

```text
Invalid road connection.
No changes made to the network.
```

If the road is already blocked, the system informs the user without changing its status.

### 5. View Stations and Connections

Displays all stations and their road connections, including blocked roads.

```text
--- STATIONS AND CONNECTIONS ---

A -> B (4 km), C (3 km)
B -> A (4 km), D (5 km), E (2 km)
C -> A (3 km), D (4 km), E (4 km)
D -> B (5 km), C (4 km), F (3 km), G (4 km)
E -> B (2 km), C (4 km), F (6 km), G (3 km)
F -> D (3 km), E (6 km)
G -> D (4 km), E (3 km), H (2 km)
H -> G (2 km)

Blocked roads, if any, are marked as BLOCKED.
```

### 6. View Emergency History

Displays previously completed emergency operations.

```text
--- EMERGENCY HISTORY ---

Request ID: E101
Type: Medical Emergency
Source: A
Destination: D
Route Taken: A -> B -> D
Total Distance: 9 km
Outcome: Completed

----------------------------------------
```

If no records exist:

```text
No emergency history available.
```

### 7. Search Emergency History

The user searches for an emergency using its request ID.

```text
--- SEARCH EMERGENCY HISTORY ---

Enter Request ID: E101

Emergency record found!

Request ID: E101
Type: Medical Emergency
Source: A
Destination: D
Route Taken: A -> B -> D
Total Distance: 9 km
Outcome: Completed
```

If the record does not exist:

```text
No record found for the given Request ID.
```

### 0. Exit

Terminates the program.

```text
Exiting Emergency Disaster Route Planner.
Thank you!
```

## 🔮 Future Enhancements

- Integrate live maps and GPS tracking.
- Incorporate real-time traffic and weather information.
- Add a graphical user interface.
- Store emergency records persistently in a database.
- Implement route caching to reuse valid previous calculations.
- Introduce additional emergency categories and configurable priority levels.
