package shoppingapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Addprod {

	ConnectionManager con= new ConnectionManager();
	public void productdetail() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("1)Addproduct\n2)Display\n3)Remove\n4)Update\n5)Exit\n");
		System.out.println("Enter the choice");
		int ch= s.nextInt();
		switch(ch)
		{
		case 1: System.out.println("Enter the product ID:");
		int proid= s.nextInt();
		System.out.println("Enter the product name:");
		String proname= s.next();
		System.out.println("Enter the minsellquantity:");
		int quantity= s.nextInt();
		System.out.println("Enter the price:");
		int price= s.nextInt();
		PreparedStatement st= (PreparedStatement) con.getConnection().prepareStatement("insert into Addproduct(Product_ID,Product_Name,Quantity,Price) values(?,?,?,?);");
		st.setInt(1, proid);
		st.setString(2, proname);
		st.setInt(3, quantity);
		st.setInt(4, price);
		st.executeUpdate();
		System.out.println("Product added successfully");
		Addprod prod= new Addprod();
		prod.productdetail();
		break;
		case 2: Statement s1= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r= s1.executeQuery("select * from Addproduct");//for display
		while(r.next())
		{
			System.out.println("##########################\n");
			System.out.println("Product ID->"+r.getInt(1));
			System.out.println("Product Name->"+r.getString(2));
			System.out.println("Quantity->"+r.getInt(3));
			System.out.println("Price->"+r.getInt(4));
			System.out.println("##########################");
		}
		Addprod prod1= new Addprod();
		prod1.productdetail();
		break;
		case 3: System.out.println("Enter the ID to delete:");
		int del= s.nextInt();
		PreparedStatement st1= (PreparedStatement) con.getConnection().prepareStatement("delete from Addproduct where Product_ID=?");
		st1.setInt(1, del);
		st1.executeUpdate();
		System.out.println("Successfully deleted");
		Addprod prod2= new Addprod();
		prod2.productdetail();
		break;
		case 4:
		Statement s2= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r1= s2.executeQuery("select * from Addproduct");//for display
		while(r1.next())
		{
			System.out.println("##########List of ID's#########\n");
			System.out.println("Product ID->"+r1.getInt(1));
			System.out.println("Product Name->"+r1.getString(2));
			System.out.println("******************************\n");
		}
		Statement s3= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r3= s3.executeQuery("select * from Addproduct");//for display
		
		int qu=0,p=0,u=0;
		System.out.println("Do you want to update quantity:(yes/no)");
		String str=s.next();
		if(str.contentEquals("yes"))
		{
		System.out.println("Enter the ID");
		int number= s.nextInt();
		System.out.println("Enter the Add quantity");
		int addquant= s.nextInt();
		while(r3.next()) {
			if(number==r3.getInt(1))
			{
				qu=r3.getInt(3);
			}
		}
		
		PreparedStatement st2= (PreparedStatement) con.getConnection().prepareStatement("Update Addproduct SET Quantity=? where Product_ID=?");
		int upquant= qu+addquant;
		st2.setInt(1, upquant);
		st2.setInt(2, number);
		st2.executeUpdate();
		System.out.println("Quantity Update successful");
		}
		Statement s4= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r4= s3.executeQuery("select * from Addproduct");//for display
		System.out.println("Do you want to update price:(yes/no)");
		String str1=s.next();
		if(str1.contentEquals("yes"))
		{
			System.out.println("Enter the ID");
			int number1= s.nextInt();
			System.out.println("Enter the Add price");
			int addprice= s.nextInt();
			while(r4.next()) {
				if(number1==r4.getInt(1))
				{
					p=r4.getInt(4);
				}
			}
				PreparedStatement st3= (PreparedStatement) con.getConnection().prepareStatement("Update Addproduct SET Price=? where Product_ID=?");
				int upprice= p+addprice;
				st3.setInt(1, upprice);
				st3.setInt(2, number1);
				st3.executeUpdate();
				System.out.println("Price Update successful");
			
		}
		Statement s5= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r5= s5.executeQuery("select * from Addproduct");//for display
		System.out.println("Do you want to update username:(yes/no)");
		String str3=s.next();
		if(str3.contentEquals("yes"))
		{
			System.out.println("Enter the ID");
			int number2= s.nextInt();
			System.out.println("Enter the Add username");
			String adduser= s.next();
			while(r4.next()) {
				if(number2==r4.getInt(1))
				{
					u=r5.getInt(2);
				}
			}
				PreparedStatement st4= (PreparedStatement) con.getConnection().prepareStatement("Update Addproduct SET Product_Name=? where Product_ID=?");
				
				st4.setString(1, adduser);
				st4.setInt(2, number2);
				st4.executeUpdate();
				System.out.println("Username Update successful");
			
		}
		Addprod prod3= new Addprod();
		prod3.productdetail();
		
		break;
		case 5:System.out.println("Process will be completed");
		Case1 c=new Case1();
		c.choice();
		break;
		
		
		
	}
	}


}
