package com.capgemini.contactbook.service;

import java.sql.SQLException;
import java.util.regex.Pattern;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exceptions.ContactBookException;
import com.capgemini.contactbook.exceptions.ContactNoNotValidateException;
import com.capgemini.contactbook.exceptions.DomainNotValidateException;
import com.capgemini.contactbook.exceptions.FirstNameNotValidateException;
import com.capgemini.contactbook.exceptions.LocationNotValidateException;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookServiceImpl implements ContactBookService{
	ContactBookDao dao=new ContactBookDaoImpl();
	@Override
	public int addEnquiry(EnquiryBean enquirybean1) throws ContactBookException, SQLException ,ContactNoNotValidateException, FirstNameNotValidateException, LocationNotValidateException, DomainNotValidateException{
		if(Pattern.matches("[1-9][0-9]{9}",enquirybean1.getContactNo())==false)
			throw new ContactNoNotValidateException();
		if(enquirybean1.getfName()==null)
			throw new FirstNameNotValidateException();
		if(enquirybean1.getpLocation()==null)
			throw new LocationNotValidateException();
		if(enquirybean1.getpDomain()==null)
			throw new DomainNotValidateException();
		int enquiryID=dao.addEnquiry(enquirybean1);
		return enquiryID;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID)throws ContactBookException {
		EnquiryBean enquiryBean = null;
		try {
			enquiryBean = dao.getEnquiryDetails(EnquiryID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enquiryBean;
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enquiry)
			throws ContactBookException {
		String contactNo=enquiry.getContactNo();
		boolean c=ValidatecontactNo(contactNo);
		String fName=enquiry.getfName();
		boolean d=ValidateFirstName(fName);
		String lName=enquiry.getlName();
		boolean e=ValidateLastName(lName);
		String pLocation=enquiry.getpLocation();
		boolean f=ValidatePLocation(pLocation);
		String pDomain=enquiry.getpDomain();
		boolean t=ValidatePDomain(pDomain);
		if(c==true&&d==true&&e==true&&f==true&&t==true)
			return true;
		else
			return false;
	}
	public boolean ValidatecontactNo(String contactNo){
		boolean c;
		if(contactNo.length()==10)
			return true;
		else
			return false;
	}
	public boolean ValidateFirstName(String fName){
		if(fName.length()==0)
			return false;
		else
			return true;
	}
	public boolean ValidateLastName(String lName){
		if(lName.length()==0)
			return false;
		else
			return true;
	}
	public boolean ValidatePLocation(String pLocation){
		if(pLocation.length()==0)
			return false;
		else
			return true;

	}
	public boolean ValidatePDomain(String pDomain){
		if(pDomain.length()==0)
			return false;
		else
			return true;
	}
}

