package com.cg.registration.services;

import com.cg.registration.beans.Customer;
import com.cg.registration.exceptions.CustomerNotFoundException;
import com.cg.registration.exceptions.InvalidCustomerNameException;
import com.cg.registration.exceptions.InvalidMobileNumberException;
import com.cg.registration.exceptions.RegistrationServicesDownException;

public interface RegistrationServices {
int acceptCustomerDetails(Customer customer)throws RegistrationServicesDownException,InvalidMobileNumberException, InvalidCustomerNameException;
Customer getCustomerDetails(int registrationId)throws RegistrationServicesDownException,CustomerNotFoundException;
}
