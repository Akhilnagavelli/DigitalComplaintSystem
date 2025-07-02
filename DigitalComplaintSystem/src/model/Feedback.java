package model;

public class Feedback {
    private int feedbackId;
    private int complaintId;
    private int rating;
    private String comments;

    public Feedback() {}

    public Feedback(int feedbackId, int complaintId, int rating, String comments) {
        this.feedbackId = feedbackId;
        this.complaintId = complaintId;
        this.rating = rating;
        this.comments = comments;
    }
 // Constructor for new feedback (DB will set feedbackId)
    public Feedback(int complaintId, int rating, String comments) {
        this.complaintId = complaintId;
        this.rating = rating;
        this.comments = comments;
    }

    // Getters and Setters

    public int getFeedbackId() {
        return feedbackId;
    }
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getComplaintId() {
        return complaintId;
    }
    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
