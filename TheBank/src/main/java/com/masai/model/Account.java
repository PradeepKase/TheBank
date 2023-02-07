package com.masai.model;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Account{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountno;
	@NotNull
	@Size(min=3, max=20, message="min 3 and max 20 characters")
	private String accountHoldername;
	@NotNull
	@Size(max=35)
	private String address;
	@Email
	private String email;
	@Min(1000)
	private Integer amount;
	@Size(min=9, max=10)
	private String mobile;
	

	public Integer getAccountno() {
		return accountno;
	}
	public void setAccountno(Integer accountno) {
		this.accountno = accountno;
	}
	public String getAccountHoldername() {
		return accountHoldername;
	}
	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(Integer accountno,
			@NotNull @Size(min = 3, max = 20, message = "min 3 and max 20 characters") String accountHoldername,
			@NotNull @Size(max = 35) String address, @Email String email, @Min(1000) Integer amount,
			@Size(min = 10, max = 10) String mobile) {
		super();
		this.accountno = accountno;
		this.accountHoldername = accountHoldername;
		this.address = address;
		this.email = email;
		this.amount = amount;
		this.mobile = mobile;

	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", accountHoldername=" + accountHoldername + ", address=" + address
				+ ", email=" + email + ", amount=" + amount + ", mobile=" + mobile + "]";
	}
	
	
	
}