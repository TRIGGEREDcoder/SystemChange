package com.capgemini.contactbook.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.capgemini.contactbook.exceptions.ContactBookException;
import com.capgemini.contactbook.util.ConnectionProvider;
import com.igate.contactbook.bean.EnquiryBean;
public class ContactBookDaoImpl implements ContactBookDao{
	private Connection conn = new ConnectionProvider().getDBConnectionProvider();
	@Override
	public int addEnquiry(EnquiryBean enquiry) throws ContactBookException, SQLException {
		try{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO enquiry(enqryid,firstName,lastName,contactNo,domain,city)"
					+ "VALUES(enquiries.nextval,?,?,?,?,?)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);		
			pstmt1.setString(1, enquiry.getfName());
			pstmt1.setString(2,  enquiry.getlName());
			pstmt1.setString(3, enquiry.getContactNo());
			pstmt1.setString(4, enquiry.getpDomain());
			pstmt1.setString(5, enquiry.getpLocation());
			pstmt1.executeUpdate();
			conn.commit();
			PreparedStatement pstmt2 = conn.prepareStatement("SELECT MAX(enqryid) FROM enquiry");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int enquiryId= rs.getInt(1);
			return enquiryId;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.setAutoCommit(true);
		}
	}
	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID)throws ContactBookException, SQLException {	
		try {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM enquiry WHERE enqryid=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, EnquiryID);
			ResultSet enqObtained = pstmt2.executeQuery();
			if(enqObtained.next()){
				int enquiryID=enqObtained.getInt("enqryid");
				String fName = enqObtained.getString("firstname");
				String lName = enqObtained.getString("lastname");
				String contactNo = enqObtained.getString("contactno");
				String pDomain = enqObtained.getString("domain");
				String pLocation = enqObtained.getString("city");
				EnquiryBean enquirybean1=new EnquiryBean(enquiryID,fName,lName,contactNo,pDomain,pLocation);
				return enquirybean1;
			}
		} catch (SQLException e) {
			try {
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			conn.rollback();
		}finally{
			conn.setAutoCommit(true);
		}
		return null;
	}
}