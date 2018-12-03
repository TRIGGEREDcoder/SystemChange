package com.cg.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.payroll.util.ConnectionProvider;
import com.cg.registration.beans.Customer;
import com.cg.registration.exceptions.CustomerNotFoundException;
import com.cg.registration.exceptions.RegistrationServicesDownException;

public class RegistrationDAOImpl implements RegistrationDAO{
	private Connection conn=ConnectionProvider.getDBConnection();
	private static final Logger logger=Logger.getLogger(RegistrationDAOImpl.class);
	@Override
	public Customer save(Customer customer) throws RegistrationServicesDownException {
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO Registration(registrationId ,\r\n" + 
					"customerName ,\r\n" + 
					"mobileno ,\r\n" + 
					"registrationfees ,\r\n" + 
					"age ,\r\n" + 
					"actualregfeespaid)VALUES(seq_registrationid.nextval,?,?,?,?,?)");//sequence.naextval 1st argument
			pstmt.setString(1,customer.getCustomerName());
			pstmt.setString(2,customer.getMobileNo());
			pstmt.setDouble(3,customer.getRegistrationFees());
			pstmt.setInt(4,customer.getAge());
			pstmt.setDouble(5,customer.getActualRegFeesPaid());
			pstmt.executeUpdate();
			
			PreparedStatement pstmt2=conn.prepareStatement("select max(registrationId) from Registration");
			ResultSet rs=pstmt2.executeQuery();
			rs.next();//always open
			int registrationId=rs.getInt(1);
			customer.setRegistrationId(registrationId);
			conn.commit();
			
			return customer;
			
		} catch (SQLException e) {
			logger.error(e.getMessage()+" "+e.getCause()+" "+e.getErrorCode());
			e.printStackTrace();
			
			throw new RegistrationServicesDownException();
		}
	
		
	}

	@Override
	public Customer findOne(int registrationId) throws RegistrationServicesDownException {
		try {
			PreparedStatement pstmt1=conn.prepareStatement("select *  from Registration where registrationId="+registrationId);
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next()) {
				String customerName=rs.getString("customerName");
				String mobileNo=rs.getString("mobileno");
				Double registrationFees=rs.getDouble("registrationfees");
				int age=rs.getInt("age");
				Double actualRegFeesPaid=rs.getDouble("actualregfeespaid");
				Customer customer=new Customer(registrationId, age, customerName, mobileNo, registrationFees, actualRegFeesPaid);
				return customer;
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage()+" "+e.getCause()+" "+e.getErrorCode());
			e.printStackTrace();
			throw new RegistrationServicesDownException();
		}
		return null;
	}

}
