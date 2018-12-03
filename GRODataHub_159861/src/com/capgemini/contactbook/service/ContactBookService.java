package com.capgemini.contactbook.service;

import java.sql.SQLException;

import com.capgemini.contactbook.exceptions.ContactBookException;
import com.capgemini.contactbook.exceptions.ContactNoNotValidateException;
import com.capgemini.contactbook.exceptions.DomainNotValidateException;
import com.capgemini.contactbook.exceptions.FirstNameNotValidateException;
import com.capgemini.contactbook.exceptions.LocationNotValidateException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookService {
	public int  addEnquiry(EnquiryBean enqry) throws ContactBookException, SQLException, ContactNoNotValidateException, FirstNameNotValidateException, LocationNotValidateException, DomainNotValidateException;
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException;
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException;
}
