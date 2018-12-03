package com.capgemini.contactbook.dao;

import java.sql.SQLException;

import com.capgemini.contactbook.exceptions.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookDao {
	public int addEnquiry(EnquiryBean enquirybean1) throws ContactBookException, SQLException;
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException, SQLException;

}
