package com.capgemini.contactbook.ui;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.igate.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exceptions.InvalidInputException;
import com.capgemini.contactbook.util.ConnectionProvider;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;
import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.exceptions.ContactBookException;
import com.capgemini.contactbook.exceptions.ContactNoNotValidateException;
import com.capgemini.contactbook.exceptions.DomainNotValidateException;
import com.capgemini.contactbook.exceptions.FirstNameNotValidateException;
import com.capgemini.contactbook.exceptions.LocationNotValidateException;
import com.capgemini.contactbook.exceptions.ServicesDownException;
public class MainClass {
	private static Scanner reference;
	public static void main(String[] args) throws SQLException, ContactBookException, InvalidInputException, ContactNoNotValidateException, FirstNameNotValidateException, LocationNotValidateException, DomainNotValidateException {
		if (ConnectionProvider.getDBConnectionProvider() != null)
			System.out.println("Successfully Connected");
		else
			System.out.println("Not Connected");
		String fName,lName,pLocation,pDomain,contactNo;
		int choice;
		reference= new Scanner(System.in);
			System.out.println("**********Global Recruitments*********");
			System.out.println("Choose an operation");
			System.out.println("1. Enter Enquiry Details");
			System.out.println("2. Enter Enquiry details on Id");
			System.out.println("0. Exit");
			System.out.println("*************");
			System.out.print("Please enter a choice"+"  ");
			choice = reference.nextInt();
			switch(choice){
			case 1:
				try{
					System.out.println("*****************************");
					System.out.println("Enter First Name");
					fName = reference.next();
					if(fName==null)
						throw new InvalidInputException("Please enter your firstname");
					System.out.println("Enter Last Name");
					lName =reference.next();
					if(lName==null)
						throw new InvalidInputException("Please enter your lastname");
					System.out.println("Enter Contact number");
					contactNo=reference.next();
					if(contactNo.length()!=10)
						throw new InvalidInputException("Please enter valid input.");
					System.out.println("Enter Preferred Location");
					pLocation = reference.next();
					System.out.println("Enter Preferred Domain");
					pDomain =reference.next();
					System.out.println("******************************");
					EnquiryBean enquirybean1=new EnquiryBean(fName,lName,contactNo,pLocation,pDomain) ;
					ContactBookService services = new ContactBookServiceImpl();
					int enquiryId = services.addEnquiry(enquirybean1);
					System.out.println("Thank You " + enquirybean1.getfName()+" "+ lName + " your Unique enquiry id is " + enquiryId + " we will contact you shortly.");
					break;}
				catch(InputMismatchException e){
					System.out.println("Please enter valid input.");}
			case 2:
				System.out.println("*****************************");
				System.out.print("Enter the Enquiry no.");
				int enquiryNo=reference.nextInt();
				System.out.println("*****************************");
				EnquiryBean enquirybean2=new EnquiryBean(enquiryNo);
				ContactBookService services1 = new ContactBookServiceImpl();
				EnquiryBean enquiry=services1.getEnquiryDetails(enquiryNo);
				System.out.println("ID= " + enquiry.getEnqryId());
				System.out.println("First Name= " + enquiry.getfName());
				System.out.println("Last Name= " + enquiry.getlName());
				System.out.println("Contact No= " + enquiry.getContactNo());
				System.out.println("Preferred Domain= " + enquiry.getpDomain());
				System.out.println("Preferred Location= " + enquiry.getpLocation());
				break;	
			case 0:{
					System.out.println("Thank You for selecting us!!");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
					break;}
			default:
				break;			
			}		
		}
}