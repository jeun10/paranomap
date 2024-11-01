package com.example.project;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseDonfigTest {
	 static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testConnection() {
	        try (Connection con =
	                    DriverManager.getConnection(
	                            "jdbc:mysql://127.0.0.1:3306/?user=root",
	                            "root",
	                            "emb306")) {
	            System.out.println("DB Connection => " + con);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
}
