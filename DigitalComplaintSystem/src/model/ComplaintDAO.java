package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.DBConnection;

public class ComplaintDAO {
    private Connection conn;

    public ComplaintDAO() {
        conn = DBConnection.getConnection();
    }
    
 // Method to submit a complaint (called by student)
    public boolean submitComplaint(Complaint complaint) {
        boolean success = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO complaints (user_id, category, department, description, status, created_at) " +
                         "VALUES (?, ?, ?, ?, ?, NOW())";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, complaint.getUserId());
            stmt.setString(2, complaint.getCategory());
            stmt.setString(3, complaint.getDepartment());
            stmt.setString(4, complaint.getDescription());
            stmt.setString(5, complaint.getStatus());

            int rows = stmt.executeUpdate();
            success = (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    // 1. View all complaints
    public List<Complaint> getAllComplaints() {
        List<Complaint> list = new ArrayList<>();
        String query = "SELECT * FROM complaints";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Complaint c = new Complaint();
                c.setComplaintId(rs.getInt("complaint_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setCategory(rs.getString("category"));
                c.setDepartment(rs.getString("department"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all complaints: " + e.getMessage());
        }
        return list;
    }

    // 2. View complaints by department
    public List<Complaint> getComplaintsByDepartment(String dept) {
        List<Complaint> list = new ArrayList<>();
        String query = "SELECT * FROM complaints WHERE department = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, dept);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Complaint c = new Complaint();
                c.setComplaintId(rs.getInt("complaint_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setCategory(rs.getString("category"));
                c.setDepartment(rs.getString("department"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching complaints by department: " + e.getMessage());
        }
        return list;
    }

    // 3. Update complaint status
    public boolean updateStatus(int complaintId, String newStatus) {
        String query = "UPDATE complaints SET status = ? WHERE complaint_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, complaintId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating status: " + e.getMessage());
            return false;
        }
    }
}
