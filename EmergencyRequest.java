
public class EmergencyRequest {

    private int requestId;
    private String source;
    private String destination;
    private String emergencyType;
    private int priority;
    private String status;
    private long arrivalOrder;

    public EmergencyRequest(int requestId, String source,
                            String destination, String emergencyType,
                            int priority) {

        this.requestId = requestId;
        this.source = source;
        this.destination = destination;
        this.emergencyType = emergencyType;
        this.priority = priority;
        this.status = "PENDING";
    }

    public int getRequestId() {
        return requestId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public long getArrivalOrder() {
        return arrivalOrder;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setArrivalOrder(long arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }

    public void displayRequest() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
    }
}