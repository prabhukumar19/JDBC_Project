package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) {
		System.out.println("JDBC Example!");
//		System.out.println(getConnection());
		getData();
//		insert();
//		delete(5);
//		update(1);
		
	}
	
	public static Connection getConnection() {
		
		try {
			String url ="jdbc:mysql://localhost:3306/test";
			String userName ="root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Database Connected!");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void getData() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet res = stmt.executeQuery("Select * from users");
			
			while(res.next()) {
				System.out.println("Id :- "+res.getString("id"));
				System.out.println("Email :- "+res.getString("email"));
				System.out.println("Name :- "+res.getString("name"));
				System.out.println("Mobile Number :- "+res.getString("mobile_number"));
				System.out.println();
			}
			System.out.println("Records Ended!");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insert() {
		try {
			Statement statement = getConnection().createStatement();
			int result = statement.executeUpdate("insert into users (name,email,mobile_number) values('Randhir','priti@test.com',78945561230)");
			if(result==1) {
				System.out.println("Record added");
			}else {
				System.out.println("Record not added");
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void update(int id ) {
		try {
			Statement statement = getConnection().createStatement();
			int result = statement.executeUpdate("update users set name ='Prabhu Kumar' where id="+id);
			if(result==1) {
				System.out.println("Record updated");
			}else {
				System.out.println("Record not updated");
			}
		}catch(Exception e) {
			
		}
	}
    public static void delete(int id) {
    	try {
			Statement statement = getConnection().createStatement();
			int result = statement.executeUpdate("delete from users where id="+id);
			if(result==1) {
				System.out.println("Record deleted");
			}else {
				System.out.println("Record not deleted");
			}
		}catch(Exception e) {
			
		}
	}
}
