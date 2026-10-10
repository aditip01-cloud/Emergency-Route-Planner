import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Graph graph = new Graph();

        // Create the graph only once
        graph.createGraph(sc);

        int choice;

        do {
            System.out.println("\n===== EMERGENCY DISASTER ROUTE PLANNER =====");
            System.out.println("1. Find Shortest Emergency Route");
            System.out.println("2. Display Road Network");
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

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}