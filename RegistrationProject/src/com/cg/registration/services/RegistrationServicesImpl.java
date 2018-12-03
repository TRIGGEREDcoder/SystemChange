package com.cg.registration.services;

import java.util.regex.Pattern;

import com.cg.registration.beans.Customer;
import com.cg.registration.dao.RegistrationDAO;
import com.cg.registration.dao.RegistrationDAOImpl;
import com.cg.registration.exceptions.CustomerNotFoundException;
import com.cg.registration.exceptions.InvalidCustomerNameException;
import com.cg.registration.exceptions.InvalidMobileNumberException;
import com.cg.registration.exceptions.RegistrationServicesDownException;



public class RegistrationServicesImpl implements RegistrationServices{
	
	
	RegistrationDAO registrationDao=new RegistrationDAOImpl();
	
	
	public RegistrationServicesImpl() {
		super();
	
	}

	public RegistrationServicesImpl(RegistrationDAO registrationDao) {
		super();
		this.registrationDao = registrationDao;
	}

	@Override
	public int acceptCustomerDetails(Customer customer)
			throws RegistrationServicesDownException, InvalidMobileNumberException, InvalidCustomerNameException {
		String mobileNo=customer.getMobileNo();
		String customerName=customer.getCustomerName();
		if(customerName.equals(null))
			throw new InvalidCustomerNameException();
		if(!Pattern.matches("[a-zA-Z]{3,}",customerName))
			throw new InvalidCustomerNameException();
		int age=customer.getAge();
		double registrationFees=customer.getRegistrationFees();
		if(mobileNo.length()!=10)
			throw new InvalidMobileNumberException();
		double commission=0;
		if(age>=0 && age<18)
			commission=0;
		else if(age<25)
			commission=0.10*registrationFees;
		else if(age<50)
			commission=0.20*registrationFees;
		else 
			commission=0.30*registrationFees;
		
		customer.setActualRegFeesPaid(registrationFees-commission);
		Customer customer2=registrationDao.save(customer);
		if(customer!=null)
		return customer.getRegistrationId();
		else
		throw new RegistrationServicesDownException();
		
	}

	@Override
	public Customer getCustomerDetails(int registrationId)
			throws RegistrationServicesDownException, CustomerNotFoundException {
	Customer customer=registrationDao.findOne(registrationId);
		if(customer==null)
			throw new CustomerNotFoundException();
		else
			return customer;
	}

}
