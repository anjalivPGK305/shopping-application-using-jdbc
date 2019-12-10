package shoppingapplication;

import java.sql.SQLException;
import java.util.Scanner;

public class Case1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Case1 c=new Case1();//declaring the main class
		c.choice();//calling the choice method
		ConnectionManager con= new ConnectionManager();//declaring the connectionmanager class

	}

	void choice() throws ClassNotFoundException, SQLException {//defining choice method
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("1)AdminLogin\n2)AgentLogin\n3)Exit\n");
		System.out.println("Enter the choice");
		int n= s.nextInt();
		switch(n)
		{
		case 1:Admin ad= new Admin();//declaring admin class
		ad.admindetail();//calling admindetail method
		break;
		case 2:Agent ag= new Agent();//declaring agent method
		ag.agentdetail();//calling agentdetail method
		break;
		case 3:System.exit(0);
		}
		
		
		
	}

}
