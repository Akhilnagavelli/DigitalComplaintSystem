package model;

public class Complaint {
    private int complaintId;
    private int userId;
    private String category;
    private String department;
    private String description;
    private String status;

    // Constructors
    public Complaint() {}

    public Complaint(int userId, String category, String department, String description) {
        this.userId = userId;
        this.category = category;
        this.department = department;
        this.description = description;
        this.status = "Pending";
    }

    // Getters and Setters
    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
