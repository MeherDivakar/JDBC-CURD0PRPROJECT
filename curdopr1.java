package curdopr1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class curdopr1 {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3307/emp";;
	private static PreparedStatement pmst;
	private static Connection conn;
	
public static void main(String[] args) {
	Scanner scr=new Scanner(System.in);
	int ch;
	do {
		getdetails();
		ch=Integer.parseInt(scr.next());
		switch (ch) {
		case 1:
			login();
			break;
		case 2:
			registration();
			break;
		case 3:
			adduser();
			break;
		case 4:
			deleteuser();
			break;
		case 5:
			modifyuserdetails();
		      break;
		case 6:
			getall();
			break;
		case 7:
			getbyemail();
			break;
		case 8:
			System.exit(0);
			break;
			
		default:
			System.out.println("invalid operation");
			break;
		}
		
	}
	while(ch>0);
}

private static void registration() {
	
	try {
		Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		String sql="insert into registrationdetails(name,email,password) values(?,?,?)";
		pmst=conn.prepareStatement(sql);
		System.out.println("enter name:");
		pmst.setString(1,scr.next());
		System.out.println("enter mail:");
		pmst.setString(2,scr.next());
		System.out.println("enter password:");
		pmst.setString(3,scr.next());
		
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("data inserted");
		}
		else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}

}

private static void adduser() {
	
	try {
		Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		String sql="insert into registrationdetails(name,email,password) values(?,?,?)";
		pmst=conn.prepareStatement(sql);
		System.out.println("enter name:");
		pmst.setString(1,scr.next());
		System.out.println("enter mail:");
		pmst.setString(2,scr.next());
		System.out.println("enter password:");
		pmst.setString(3,scr.next());
		
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("data inserted");
		}
		else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}



private static void deleteuser() {
	try {
		Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("enter table name:");
		String sql="delete from "+scr.next()+" where id=?";
		pmst=conn.prepareStatement(sql);
		System.out.println("enter id:");
		pmst.setInt(1,scr.nextInt());
		
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("successfully deleted");
		}
		else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}



private static void modifyuserdetails() {
	try {
		Scanner scr= new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("enter table name:");
		String sql="update "+scr.next()+ " set id=?,name=?,password=?,email=? where id=?";
	    pmst=conn.prepareStatement(sql);
		System.out.println("enter id:");
		pmst.setInt(1,scr.nextInt());
		System.out.println("enter name:");
		pmst.setString(2, scr.next());
		System.out.println("enter password");
		pmst.setString(3, scr.next());
		System.out.println("enter email");
		pmst.setString(4, scr.next());
		System.out.println("provide id:");
		pmst.setInt(5,scr.nextInt());
		
		
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("updated successfully");
		}
		else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
		
		} 
	catch (Exception e) {
		e.printStackTrace();
	}	

	
}

private static void getall() {
	try {
		Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("enter table name:");
		String sql="select * from "+scr.next();
		pmst=conn.prepareStatement(sql);
		ResultSet rs=pmst.executeQuery();
		while(rs.next()) {
			System.out.println("id:"+rs.getInt("id"));
			System.out.println("name: "+rs.getString("name"));
			System.out.println("email: "+rs.getString("email"));
			System.out.println("password: "+rs.getString("password"));
		}
		conn.close();
		pmst.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}
	


private static void getbyemail() {
	try {
		Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("enter table name:");
		String sql="select * from "+scr.next()+" where email=?";
		pmst=conn.prepareStatement(sql);
		System.out.println("enter email:");
		pmst.setString(1, scr.next());
		ResultSet rs=pmst.executeQuery();
		while(rs.next()) {
			System.out.println("id:"+rs.getInt("id"));
			System.out.println("name: "+rs.getString("name"));
			System.out.println("email: "+rs.getString("email"));
			System.out.println("password: "+rs.getString("password"));
		}
		conn.close();
		pmst.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}

private static void login() {
	try {
		Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("enter email:");
		String email=scr.next();
		System.out.println("enter password:");
		String password=scr.next();
		String sql="select * from registrationdetails where email=? and password=?";
		pmst=conn.prepareStatement(sql);
		pmst.setString(1, email);
		pmst.setString(2, password);
		ResultSet rs=pmst.executeQuery();
		if(rs.next()) {
System.out.println("successfully login");
		}
		conn.close();
		pmst.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void getdetails() {
	System.out.println("cofeewebsite operations");
	System.out.println("__________________________");
	System.out.println("choose an option:");
	System.out.println("\t 1.login");
	System.out.println("\t 2.registration");
	System.out.println("\t 3.adduser");
	System.out.println("\t 4.deleteuser");
	System.out.println("\t 5.modifyuserdetails");
	System.out.println("\t 6.getalluserdetails");
	System.out.println("\t 7.getuserdetailsbyemails");
	System.out.println("\t 8.exit");
}
}
