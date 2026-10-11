import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Graph graph = new Graph();

        // Create the graph only once
        graph.createGraph(sc);

        EmergencyManager emergencyManager = new EmergencyManager();

        int choice;

        do {
            System.out.println("\n===== EMERGENCY DISASTER ROUTE PLANNER =====");
            System.out.println("1. Find Shortest Emergency Route");
            System.out.println("2. Display Road Network");
            System.out.println("3. Add Emergency Request");
            System.out.println("4. Process Next Emergency");
            System.out.println("5. Display Pending Emergencies");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    graph.findShortestEmergencyRoute(sc);
                    break;

                case 2:
                    graph.displayGraph();
                    break;

                case 0:
                    System.out.println("Exiting Emergency Disaster Route Planner.");
                    break;

                    ```java
                case 3:
                    System.out.print("Enter Request ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter Destination: ");
                    String destination = sc.nextLine();

                    System.out.print("Enter Emergency Type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter Priority (1 = highest): ");
                    int priority = sc.nextInt();
                    sc.nextLine();

                    EmergencyRequest request = new EmergencyRequest(id, source, destination, type, priority);

                    emergencyManager.addRequest(request);
                    break;

                case 4:
                    emergencyManager.processNextRequest();
                    break;

                case 5:
                    emergencyManager.displayPendingRequests();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
