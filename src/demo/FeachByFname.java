package demo;

import java.sql.*;
import java.util.Scanner;

public class FeachByFname {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("enter the order(1.ASC,2.DESC):");
		String k=s.next();
		System.out.print("\nenter the data name:");
		String u=s.next();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user",
                "root", "root");
           
				PreparedStatement ps=c.prepareStatement("SELECT * FROM user ORDER BY ?"+k);
//				ps.setString(1, u);
				ResultSet rs=ps.executeQuery("SELECT * FROM user ORDER BY id desc");
				
				while (rs.next()) {
					
					System.out.println("id:         "+rs.getInt(1));

					System.out.println("fname:      "+rs.getString(2));

					System.out.println("gender:     "+rs.getString(3));

					System.out.println("pno:        "+rs.getLong(4));
					
					System.out.println("email:      "+rs.getString(5));	
					
					System.out.println("----------------------------------------------------");
					
					
				}

            
		} catch (Exception e) {
			e.printStackTrace();
			
			}
	}

}
