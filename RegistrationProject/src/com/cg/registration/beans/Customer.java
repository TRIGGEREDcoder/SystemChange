package com.cg.registration.beans;

public class Customer {
private int registrationId,age;
private String customerName,mobileNo;
private double registrationFees,actualRegFeesPaid;
public Customer() {
	super();
}

public Customer(int age, String customerName, String mobileNo, double registrationFees) {
	super();
	this.age = age;
	this.customerName = customerName;
	this.mobileNo = mobileNo;
	this.registrationFees = registrationFees;
}

public Customer(int registrationId, int age, String customerName, String mobileNo, double registrationFees,
		double actualRegFeesPaid) {
	super();
	this.registrationId = registrationId;
	this.age = age;
	this.customerName = customerName;
	this.mobileNo = mobileNo;
	this.registrationFees = registrationFees;
	this.actualRegFeesPaid = actualRegFeesPaid;
}

public int getRegistrationId() {
	return registrationId;
}
public void setRegistrationId(int registrationId) {
	this.registrationId = registrationId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public double getRegistrationFees() {
	return registrationFees;
}
public void setRegistrationFees(double registrationFees) {
	this.registrationFees = registrationFees;
}
public double getActualRegFeesPaid() {
	return actualRegFeesPaid;
}
public void setActualRegFeesPaid(double actualRegFeesPaid) {
	this.actualRegFeesPaid = actualRegFeesPaid;
}

@Override
public String toString() {
	return "Customer [registrationId=" + registrationId + ", age=" + age + ", customerName=" + customerName
			+ ", mobileNo=" + mobileNo + ", registrationFees=" + registrationFees + ", actualRegFeesPaid="
			+ actualRegFeesPaid + "]";
}


}
