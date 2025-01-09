package demo;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class fetchAll {
    public static void main(String[] args) {
        String csvFilePath = "src/ecommerce_dataset_updated.csv"; // Adjust this path as needed

        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user", // Replace with your database
                "root", // Replace with your username
                "root"  // Replace with your password
            );
            System.out.println("Connected to the database.");
            
            // Prepare SQL Insert Query
            String query = "INSERT INTO your_table_name (User_ID, Product_ID, Category, Price, Discount, Final_Price, Payment_Method, Purchase_Date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            // Read the CSV File
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
            String line;
            int lineCount = 0;

            // Define a date formatter to convert dates
            SimpleDateFormat csvDateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Format in CSV
            SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format for MySQL

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (lineCount == 0) {
                    lineCount++;
                    continue;
                }

                // Split the line by commas
                String[] values = line.split(",");
                
                if (values.length != 8) {
                    System.out.println("Invalid row: " + line);
                    continue; // Skip this row if it doesn't have exactly 8 columns
                }

                // Parse values with error handling
                try {
                    int userId = values[0].isEmpty() ? 0 : Integer.parseInt(values[0]);
                    int productId = values[1].isEmpty() ? 0 : Integer.parseInt(values[1]);
                    String category = values[2].isEmpty() ? "Unknown" : values[2];
                    double price = values[3].isEmpty() ? 0.0 : Double.parseDouble(values[3]);
                    double discount = values[4].isEmpty() ? 0.0 : Double.parseDouble(values[4]);
                    double finalPrice = values[5].isEmpty() ? 0.0 : Double.parseDouble(values[5]);
                    String paymentMethod = values[6].isEmpty() ? "Unknown" : values[6];

                    // Convert date format
                    String purchaseDate = values[7].isEmpty() ? "1970-01-01" : dbDateFormat.format(csvDateFormat.parse(values[7]));

                    // Set values in PreparedStatement
                    ps.setInt(1, userId);
                    ps.setInt(2, productId);
                    ps.setString(3, category);
                    ps.setDouble(4, price);
                    ps.setDouble(5, discount);
                    ps.setDouble(6, finalPrice);
                    ps.setString(7, paymentMethod);
                    ps.setString(8, purchaseDate);

                    // Execute Insert Query
                    ps.executeUpdate();
                    System.out.println("Inserted row: " + line);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid numeric value in row: " + line);
                } catch (ParseException e) {
                    System.out.println("Invalid date format in row: " + line);
                }
            }

            br.close();
            ps.close();
            con.close();
            System.out.println("Data insertion completed.");
            
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + csvFilePath);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
