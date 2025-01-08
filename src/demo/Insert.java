package demo;

import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("Enter ID:");
            int id = s.nextInt();

            System.out.println("Enter First Name:");
            String fname = s.next();

            System.out.println("Enter Last Name:");
            String lname = s.next();

            System.out.println("Enter Gender:");
            String gender = s.next();

            System.out.println("Enter Email:");
            String email = s.next();

            System.out.println("Enter Password:");
            String password = s.next();

            System.out.println("Enter Phone Number:");
            long phone = s.nextLong();

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user", // Replace `your_database_name` with the actual database name
                "root", // Replace with your database username
                "root"  // Replace with your database password
            );

            // SQL query
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO user (id, fname, lname, gender, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            // Set parameters
            ps.setInt(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setLong(7, phone);

            // Execute update
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data saved successfully!");
            } else {
                System.out.println("Failed to save data.");
            }

            // Close connection
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error occurred.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected error occurred.");
        } finally {
            s.close();
        }
    }
}
