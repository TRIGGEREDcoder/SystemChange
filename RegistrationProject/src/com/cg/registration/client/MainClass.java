package com.cg.registration.client;

import java.sql.Connection;
import java.util.Scanner;

import com.cg.payroll.util.ConnectionProvider;
import com.cg.registration.beans.Customer;
import com.cg.registration.exceptions.CustomerNotFoundException;
import com.cg.registration.exceptions.InvalidCustomerNameException;
import com.cg.registration.exceptions.InvalidMobileNumberException;
import com.cg.registration.exceptions.RegistrationServicesDownException;
import com.cg.registration.services.RegistrationServices;
import com.cg.registration.services.RegistrationServicesImpl;

public class MainClass {
	
	public static void main(String args[]) throws RegistrationServicesDownException, InvalidMobileNumberException, CustomerNotFoundException, InvalidCustomerNameException {
		Connection conn=ConnectionProvider.getDBConnection();
		if(conn!=null)
			System.out.println("connected");
		else
			System.out.println("not connected");
		
		RegistrationServices registrationServices=new RegistrationServicesImpl();
		Customer customer=new Customer();
		Scanner sc=new Scanner(System.in);
		String s="yes";
		
		while(s.equalsIgnoreCase("yes")){
			System.out.println("1)CustomerRegistration ");
			System.out.println("2)Print Customer Details");
			System.out.println("3)Exit");
			System.out.println("Enter Your Choice");
			int choice= sc.nextInt();
			
			switch(choice){
				case 1:
			System.out.println("Enter the name of the customer");
			String s1=sc.next();
			customer.setCustomerName(s1);
			System.out.println("Enter customer phone number");
			String l=sc.next();
			customer.setMobileNo(l);
			System.out.println("enter registration fees");
			 double n2=sc.nextDouble();
			 customer.setRegistrationFees(n2);
			System.out.println("Enter age");
			int age=sc.nextInt();
			customer.setAge(age);
			
			int registrationId=registrationServices.acceptCustomerDetails(customer);
			System.out.println("Reg ID: "+registrationId);
			System.out.println("Congrats!! Registered in game");
			
			
			
			break;
				case 2:
					System.out.println("Enter registrationId:");
					int registrationId2=sc.nextInt();
					customer=registrationServices.getCustomerDetails(registrationId2);
					System.out.println(customer.toString());
					break;
					
				case 3:
					break;
					
			default:
				System.out.println("Invalid Input");
				break;
			}
		System.out.println("Do you want to continue?(yes/no)");
		
		s=sc.next();
		
		}
	}
}

