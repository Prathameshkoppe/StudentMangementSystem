package StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentOperation {
	
	
	private static String StudentName;
	private static int StudId;
	private static int Balance;
	private static int fees;
	private static String course;
	
	
	private static Connection conn;
	private static Statement stmt;
static ResultSet rs;
	private static String sql;
	
	
	public static void courseEnroll() throws SQLException {
		Scanner sc=new Scanner(System.in);
		
		conn=StudentConnection.getConnection();
		stmt=conn.createStatement();
		System.out.println("Enter Your Coustomer ID");
		StudId=sc.nextInt();
		
		System.out.println("Choose the Course");
		System.out.println("1.Java");
		System.out.println("2.Python");
		System.out.println("3.JavaScript");
		System.out.println("4.HTML");
		int Choice=sc.nextInt();
		switch(Choice) {
		case 1:
			course="Java";
			fees=40000;
			Balance=fees;
			break;
		case 2:course="Python";
		fees=35000;
		Balance=fees;
			break;
		case 3:course="JavaScript";
		fees=37000;
		Balance=fees;
			break;
		case 4:course="HTML";
		fees=20000;
		Balance=fees;
			break;
			
		}
		
		sql = "update studentmanagementsystem set Fees='"+fees+"', CourseEnrolled='"+course+"',BalanceFees='"+Balance+"' WHERE StudentId = "+StudId;
		int i=stmt.executeUpdate(sql);
		
		if(i>0) {
			System.out.println("Course Enrolld Succesfully");
		}else {System.out.println("Course not enrolled");
		
		
	}
	
	
	}


	public static void ShowStatus() throws SQLException {
		Scanner sc=new Scanner(System.in);
		conn=StudentConnection.getConnection();
		stmt=conn.createStatement();
		System.out.println("Enter the Student ID");
		StudId=sc.nextInt();
		
		sql="select * from studentmanagementsystem where StudentId='"+StudId+"'";
		
		rs=stmt.executeQuery(sql);
		if(rs.next()) {
			System.out.println("StudentId \t StudentName \t Fees \t CourseEnrolled \t BalanceFees");
			System.out.println("_________________________________________________________________________________");
			
			
			StudId=rs.getInt("StudentId");
			StudentName=rs.getString("StudentName");
			fees=rs.getInt("Fees");
			course=rs.getString("CourseEnrolled");
			Balance=rs.getInt("BalanceFees");
			
			System.out.println(StudId +"\t\t"+ StudentName +"\t\t"+ fees +" \t\t"+ course +"\t\t"+ Balance);
		}else {
		
		System.out.println("Student Id does not Exist please try again");
		
		
	}
}


	public static void ragisterStudent() throws SQLException {
		Scanner sc=new Scanner(System.in);
		conn=StudentConnection.getConnection();
		stmt=conn.createStatement();
		System.out.println("Enter the name of Student");
		StudentName=sc.next();
		
		sql="insert into studentmanagementsystem (StudentName,Fees,CourseEnrolled,BalanceFees) values('"+StudentName+"',00,'',00)";
		
int i =stmt.executeUpdate(sql);

String s="select StudentId from studentmanagementsystem Where StudentName='"+StudentName+"'";
rs=stmt.executeQuery(s);
while(rs.next()) {
	StudId=rs.getInt("StudentId");
}
	if(i >0) {
		System.out.println("Student Ragisterd Successfully");
		System.out.println("Your Student Id is :"+StudId);
	}else {
		System.out.println("Student Not ragistered ,please try again");
	}
	}


	public static void payFees() throws SQLException {
		Scanner sc=new Scanner (System.in);
		conn=StudentConnection.getConnection();//connection 
		
		stmt=conn.createStatement();//statement
	
		System.out.println("Enter your StudentID");
		StudId=sc.nextInt();
		String s="Select fees,BalanceFees from studentmanagementsystem where StudentId="+StudId;//query
		rs=stmt.executeQuery(s);//
		while(rs.next()) {
			fees=rs.getInt("Fees");
			Balance=rs.getInt("BalanceFees");
			
		}
		System.out.println("Enter Ammount to pay");
		int Ammount =sc.nextInt();
		//fees=rs.getInt("Fees");
		//Balance=rs.getInt("BalanceFees");
		if(Ammount <= fees && Ammount>0) {
			Balance=fees-Ammount; 
			System.out.println("Fee Paid ");
			System.out.println("Your Current Balance Fees:"+Balance);
			
		}else {
			System.out.println("Plese fill valid ammount Which is Upto " + Balance);
			
			
			sql="update studentmanagementsystem set BalanceFees='"+Balance+"' where StudentId='"+StudId+"'";
			int i=stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("Transaction Sucessfull");
				System.out.println("Your Remaining Balance Fees are :"+Balance);
			}
			else {
				System.out.println("Transaction Failed,Please try again");
			}
		}
		
	}


	public static void CheckBalance() throws SQLException {
		Scanner sc=new Scanner (System.in);
		conn=StudentConnection.getConnection();
		stmt=conn.createStatement();
		System.out.println("Enter your Student Id");
		StudId=sc.nextInt();
		sql="select BalanceFees from studentmanagementsystem where StudentId="+StudId+"";
		
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			Balance=rs.getInt("BalanceFees");
		}
		
		
		System.out.println("Your Current Balance Fees Are:"+Balance);
		
		
	}


	public static void exit() {
		System.out.println("your program is terminated");
		System.exit(0);
		
	}
}



