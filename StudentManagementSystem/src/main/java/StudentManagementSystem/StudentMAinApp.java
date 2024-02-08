package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentMAinApp {
	
	public static void main(String[] args) throws SQLException {
		for(;;) {
		Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println();
	System.out.println();
		System.out.println("---------------------------Menu--------------------------");
		System.out.println("1.Show Status");
		System.out.println("2.Ragister Student");
		System.out.println("3.Enroll Course");
		System.out.println("4.Show Balance Fees");
		System.out.println("5.Pay Fees");
		System.out.println("6.Exit");
	
		
		int ch=  sc.nextInt();
		
		
		switch(ch) {
		case 1:StudentOperation.ShowStatus();
			
			break;
			
		case 2:StudentOperation.ragisterStudent();
			break;
			
		case 3:StudentOperation.courseEnroll();;
			break;
			
		case 4:StudentOperation.CheckBalance();
			break;
			
		case 5: StudentOperation.payFees();
			break;
		
		
		case 6:StudentOperation.exit();
			break;
			
		default :System.out.println("Enter Valid Choice");
		}
	}
	}
}

