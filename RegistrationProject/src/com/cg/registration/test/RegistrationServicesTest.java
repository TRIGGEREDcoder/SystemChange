package com.cg.registration.test;

import static org.junit.Assert.assertEquals;



import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;



import org.junit.Test;

import com.cg.registration.beans.Customer;
import com.cg.registration.dao.RegistrationDAO;
import com.cg.registration.exceptions.CustomerNotFoundException;
import com.cg.registration.exceptions.InvalidMobileNumberException;
import com.cg.registration.exceptions.RegistrationServicesDownException;
import com.cg.registration.services.RegistrationServices;
import com.cg.registration.services.RegistrationServicesImpl;

public class RegistrationServicesTest {

	private static RegistrationDAO mockRegistrationDao;
	private static RegistrationServices registrationServices;
	
	@BeforeClass
	public static void setUpTestEnv(){
		mockRegistrationDao =EasyMock.createMock(RegistrationDAO.class);
		registrationServices=new RegistrationServicesImpl(mockRegistrationDao);
}
	@Before
	public void setUpTestData() throws RegistrationServicesDownException{
		Customer customer1 = new Customer(101, 40, "john", "9123100545", 500, 400);
		
		Customer customer2 =new Customer(102, 20, "wilson","7631001610", 500, 450);
		Customer customer3 =new Customer(103, 20, "neelam","8083969915", 500, 450);
		EasyMock.expect(mockRegistrationDao.findOne(101)).andReturn(customer1);
		EasyMock.expect(mockRegistrationDao.findOne(102)).andReturn(customer2);
		EasyMock.expect(mockRegistrationDao.findOne(122)).andReturn(null);
		
		EasyMock.expect(mockRegistrationDao.save(customer3)).andReturn(customer3);
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void testGetCustomerDataForInvalidRegistrationId() throws RegistrationServicesDownException {
		
		EasyMock.verify(mockRegistrationDao.findOne(123));
	}
	
	@Test
	public void testGetCustomerDataForValidRegistrationId() throws RegistrationServicesDownException, CustomerNotFoundException{
		Customer expectedCustomer = new Customer(101, 40, "john", "9123100545", 500, 400);
		
		Customer actualCustomer = registrationServices.getCustomerDetails(101);
		
		EasyMock.verify(mockRegistrationDao.findOne(101));
		assertEquals(expectedCustomer, actualCustomer);
	}
	
	@Test
	public void testAcceptCustomerDetailsForValidData() throws RegistrationServicesDownException, InvalidMobileNumberException {
		int expectedRegistrationId = 101;
		Customer customer =new Customer( 40, "john", "9123100545", 500);
		
		int actualRegistrationId  = registrationServices.acceptCustomerDetails(customer);
		
		assertEquals(expectedRegistrationId, actualRegistrationId);
	}


	@AfterClass
	public static void tearDownTestEnv() {
		mockRegistrationDao=null;
		registrationServices=null;
	}
	
	}
