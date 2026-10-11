
import java.util.PriorityQueue;
import java.util.Comparator;

public class EmergencyManager {

    private PriorityQueue<EmergencyRequest> requests;
    private long nextArrivalOrder;

    public EmergencyManager() {

        requests = new PriorityQueue<>(
            Comparator.comparingInt(EmergencyRequest::getPriority)
                      .thenComparingLong(EmergencyRequest::getArrivalOrder)
        );

        nextArrivalOrder = 0;
    }

    // Add a new emergency request
    public void addRequest(EmergencyRequest request) {

        request.setArrivalOrder(nextArrivalOrder++);
        requests.add(request);

        System.out.println("Emergency request added successfully.");
    }

    // Process the highest-priority pending request
    public EmergencyRequest processNextRequest() {

        if (requests.isEmpty()) {
            System.out.println("No pending emergency requests.");
            return null;
        }

        EmergencyRequest request = requests.poll();

        request.setStatus("PROCESSING");

        System.out.println("\nProcessing next emergency:");
        request.displayRequest();

        return request;
    }

    // Mark a request as completed
    public void completeRequest(EmergencyRequest request) {

        if (request == null) {
            System.out.println("Invalid emergency request.");
            return;
        }

        request.setStatus("COMPLETED");

        System.out.println("Emergency request completed.");
    }

    // Display all pending requests
    public void displayPendingRequests() {

        if (requests.isEmpty()) {
            System.out.println("No pending emergency requests.");
            return;
        }

        PriorityQueue<EmergencyRequest> temp =
            new PriorityQueue<>(requests);

        System.out.println("\n===== PENDING EMERGENCIES =====");

        while (!temp.isEmpty()) {
            EmergencyRequest request = temp.poll();
            request.displayRequest();
            System.out.println("--------------------");
        }
    }
}