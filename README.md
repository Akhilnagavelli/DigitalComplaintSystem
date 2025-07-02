Hey there, I’m Akhil 👋
Welcome to my Digital Complaint Management System repository! 🚀

📊 Table of Contents
About Me

Skills

Project Overview

Problem Statement

Key Features

Tech Stack & Architecture

Setup & Installation

Usage Examples

Database ER Diagram

Future Enhancements

Thank You & Sign‑Off

👨‍💻 About Me
Hey, I’m Akhil—a passionate fresher on a mission to master Java Full Stack development! I love solving real‑world problems with clean, modular code and a touch of creativity. 🌟

🛠 Skills
Java SE 17 🧩

JDBC & MySQL 🗄️

Object‑Oriented Design 🔄

Console‑UI Design 🎨

SQL Queries & Analytics 📈

Version Control (Git & GitHub) 🔧

Problem‑Solving & Debugging 🧐

📁 Project Overview
Problem Statement
Many colleges struggle to manage student complaints (infrastructure, academics, hostel, etc.) in a transparent, trackable way. This leads to delayed resolutions and unhappy students. ❌

What I Built
A console‑based application where:

Students can register, log in, submit complaints, and give feedback.

Admins can view all complaints, filter by department, update statuses.

Department Heads handle complaints specific to their department.

Feedback & Analytics track resolution effectiveness and department performance. ✅

Key Features
🔐 Role‑based Login (Student / Admin / Dept Head)

📝 Registration & Complaint Submission

🔄 Complaint Status Tracking (Pending → In‑Progress → Resolved)

⭐ Feedback Module for resolved complaints

📊 Basic Analytics (complaints by department, status counts)

💾 MySQL Database with clean schema & ER design


Tech Stack & Architecture
Console UI  ←→  Java Service Layer  ←→  JDBC DAO Layer  ←→  MySQL Database

Front‑end: Java console (Scanner-based menus)

Business Logic: Java service classes (role handling, validation)

Data Access: JDBC (PreparedStatement, Transactions)

Database: MySQL (3 tables: users, complaints, feedback)

⚙️ Setup & Installation
Clone the repo
git clone https://github.com/your‑username/DigitalComplaintSystem.git
cd DigitalComplaintSystem
Import into Eclipse/IntelliJ as a Java project.

Add MySQL JDBC Driver (mysql-connector-java.jar) to lib/ and your classpath.

Create the Database & Tables

sql
Copy
Edit
SOURCE database/schema.sql;
Update model/DBConnection.java with your MySQL username & password.

Run the application:

Main class: app.LoginApp

Enjoy! 🎉

📷 Usage Examples
1. Student Registration & Login
text
Copy
Edit
🎓 Welcome to Digital Complaint Management System  
1. Register as Student  
2. Login  
3. Exit  

Choose an option: 1  
📝 Student Registration:  
Enter name: Akhil  
Enter email: akhil@college.com  
Enter password: ********  
✅ Registration successful!
2. Submit Complaint
text
Copy
Edit
🔐 Login:  
Enter email: akhil@college.com  
Enter password: ********  
✅ Login successful! Welcome Akhil  

--- Student Menu ---  
1. Submit Complaint  
2. Give Feedback on Resolved Complaints  
3. Logout  
Choose option: 1  

Enter complaint category (Hostel/Academic/Infra): Hostel  
Enter department (CSE/ECE/etc): CSE  
Enter complaint description: AC not working in room 101  
📬 Complaint submitted successfully!
3. Admin View & Update
text
Copy
Edit
🔐 Login:  
Enter email: admin@college.com  
Enter password: admin123  
✅ Login successful! Welcome Admin  

📋 Admin Complaint Management Menu:  
1. View All Complaints  
2. View Complaints by Department  
3. Update Complaint Status  
4. Logout  
Choose option: 1  
ID:1 | Dept:CSE | Status:Pending  
...
🗺 Database ER Diagram
placeholder for ER diagram image

🚀 Future Enhancements
🔒 Password Hashing & stronger authentication

🧪 Unit Tests (JUnit) for DAOs & services

🌐 Web UI with Servlets/JSP or Spring Boot

✉️ Email Notifications on status changes

📊 Advanced Analytics dashboard with charts

🎉 Thank You & Sign‑Off
That’s a wrap! Thanks for stopping by. I built this project from scratch—every line of code is my handiwork. Feel free to ⭐ star ⭐ and give feedback!

— Akhil Nagavelli

🔗 LinkedIn

🐙 GitHub

