

package app;

import java.util.List;
import java.util.Scanner;

import model.Complaint;
import model.ComplaintDAO;
import model.User;
import model.UserDAO;
import model.Feedback;
import model.FeedbackDAO;


public class LoginApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ComplaintDAO complaintDAO = new ComplaintDAO();

        System.out.println("🎓 Welcome to Digital Complaint Management System");

        while (true) {
            System.out.println("\n1. Register as Student");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("📝 Student Registration:");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setEmail(email);
                    newUser.setPassword(password);
                    newUser.setRole("student");  // default role

                    boolean registered = userDAO.registerUser(newUser);
                    System.out.println(registered ? "✅ Registration successful!" : "❌ Registration failed.");
                    break;

                case 2:
                    System.out.println("🔐 Login:");
                    System.out.print("Enter email: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = sc.nextLine();

                    User user = userDAO.loginUser(loginEmail, loginPassword);
                    if (user != null) {
                        System.out.println("✅ Login successful! Welcome " + user.getName());
                        

                        
                        if (user.getRole().equalsIgnoreCase("student")) {
                            boolean logout = false;
                            while (!logout) {
                                System.out.println("\n--- Student Menu ---");
                                System.out.println("1. Submit Complaint");
                                System.out.println("2. Give Feedback on Resolved Complaints");
                                System.out.println("3. Logout");
                                System.out.print("Choose option: ");
                                int sChoice = sc.nextInt(); 
                                sc.nextLine();

                                switch (sChoice) {
                                    case 1:
                                        // ─── Complaint Submission (exactly your existing code) ───
                                        System.out.print("Enter complaint category (Hostel/Academic/Infra): ");
                                        String category = sc.nextLine();
                                        System.out.print("Enter department (CSE/ECE/EEE/MECH etc): ");
                                        String dept = sc.nextLine();
                                        System.out.print("Enter complaint description: ");
                                        String desc = sc.nextLine();

                                        Complaint complaint = new Complaint();
                                        complaint.setUserId(user.getUserId());
                                        complaint.setCategory(category);
                                        complaint.setDepartment(dept);
                                        complaint.setDescription(desc);
                                        complaint.setStatus("Pending");

                                        boolean success = complaintDAO.submitComplaint(complaint);
                                        System.out.println(success 
                                            ? "\u001B[32m 📬 Complaint submitted successfully!" 
                                            : "❌ Submission failed.");
                                        break;

                                    case 2:
                                        // ─── Feedback Section ───
                                        // 1) List Resolved Complaints for this user:
                                        System.out.println("\nYour Resolved Complaints:");
                                        for (Complaint c : complaintDAO.getAllComplaints()) {
                                            if (c.getUserId() == user.getUserId() 
                                                && c.getStatus().equalsIgnoreCase("Resolved")) {
                                                System.out.println("ID:" + c.getComplaintId()
                                                    + " | Dept:" + c.getDepartment()
                                                    + " | Desc:" + c.getDescription());
                                            }
                                        }

                                        // 2) Capture feedback only if there is at least one:
                                        System.out.print("\nEnter Complaint ID to give feedback (or 0 to cancel): ");
                                        int fid = sc.nextInt(); 
                                        sc.nextLine();
                                        if (fid != 0) {
                                            System.out.print("Rating (1-5): ");
                                            int rating = sc.nextInt(); 
                                            sc.nextLine();
                                            System.out.print("Comments: ");
                                            String comments = sc.nextLine();

                                            Feedback fb = new Feedback(fid, rating, comments);
                                            boolean ok = new FeedbackDAO().submitFeedback(fb);
                                            System.out.println(ok 
                                                ? "\u001B[32m ✅ Feedback submitted!" 
                                                : "❌ Failed to submit feedback.");
                                        }
                                        break;

                                    case 3:
                                        logout = true;
                                        System.out.println("👋\u001B[32m Logging out.");
                                        break;

                                    default:
                                        System.out.println("❌ Invalid choice.");
                                }
                            }
                        }


                        else if (user.getRole().equalsIgnoreCase("admin") || user.getRole().equalsIgnoreCase("DepartmentHead")) {
                            // Admin or Dept Head menu
                            boolean back = false;
                            while (!back) {
                                System.out.println("\n \u001B[34m📋 Complaint Management Menu:");
                                System.out.println("\u001B[30m 1. View All Complaints");
                                System.out.println("\u001B[30m 2. View Complaints by Department");
                                System.out.println("\u001B[30m 3. Update Complaint Status");
                                System.out.println("\u001B[30m 4. Logout");

                                System.out.print("Choose option: ");
                                int adminChoice = sc.nextInt(); sc.nextLine();

                                switch (adminChoice) {
                                    case 1:
                                        List<Complaint> all = complaintDAO.getAllComplaints();
                                        for (Complaint c : all) {
                                            System.out.println("ID: " + c.getComplaintId() + " | Dept: " + c.getDepartment()
                                                + " | Desc: " + c.getDescription() + " | Status: " + c.getStatus());
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Enter department name: ");
                                        String dept = sc.nextLine();
                                        List<Complaint> byDept = complaintDAO.getComplaintsByDepartment(dept);
                                        for (Complaint c : byDept) {
                                            System.out.println("ID: " + c.getComplaintId() + " | Dept: " + c.getDepartment()
                                                + " | Desc: " + c.getDescription() + " | Status: " + c.getStatus());
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Enter complaint ID to update: ");
                                        int id = sc.nextInt(); sc.nextLine();
                                        System.out.print("Enter new status (Pending/In-Progress/Resolved): ");
                                        String status = sc.nextLine();
                                        boolean updated = complaintDAO.updateStatus(id, status);
                                        System.out.println(updated ? "✅ Status updated successfully!" : "❌ Update failed.");
                                        break;
                                    case 4:
                                        back = true;
                                        break;
                                    default:
                                        System.out.println("\u001B[31m Invalid option.");
                                }
                            }
                        } else {
                            System.out.println("\u001B[31m ⚠️ Unknown role. Access denied.");
                        }
                    } else {
                        System.out.println("\u001B[31m ❌ Invalid credentials.");
                    }
                    break;

                case 3:
                    System.out.println("👋\u001B[32m Exiting. Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\u001B[31m ⚠️ Invalid option. Try again.");
            }
        }
    }
}
