package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBConnection;

public class FeedbackDAO {
    /** Inserts a new feedback record. */
    public boolean submitFeedback(Feedback fb) {
        String sql = 
          "INSERT INTO feedback (complaint_id, rating, comments) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fb.getComplaintId());
            ps.setInt(2, fb.getRating());
            ps.setString(3, fb.getComments());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Feedback failed: " + e.getMessage());
            return false;
        }
    }
}
