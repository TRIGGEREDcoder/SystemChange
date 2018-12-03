package com.cg.registration.dao;

import com.cg.registration.beans.Customer;
import com.cg.registration.exceptions.CustomerNotFoundException;
import com.cg.registration.exceptions.RegistrationServicesDownException;

public interface RegistrationDAO {
Customer save(Customer customer)throws RegistrationServicesDownException;
Customer findOne(int registrationId)throws RegistrationServicesDownException;
}
