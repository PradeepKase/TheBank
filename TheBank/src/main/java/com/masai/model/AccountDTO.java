package com.masai.model;

public class AccountDTO {
private Integer sourceAcc_no;
private Integer destAcc_no;
private Integer amount;

public Integer getSourceAcc_no() {
	return sourceAcc_no;
}
public void setSourceAcc_no(Integer sourceAcc_no) {
	this.sourceAcc_no = sourceAcc_no;
}
public Integer getDestAcc_no() {
	return destAcc_no;
}
public void setDestAcc_no(Integer destAcc_no) {
	this.destAcc_no = destAcc_no;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
public AccountDTO() {
	// TODO Auto-generated constructor stub
}

public AccountDTO(Integer sourceAcc_no, Integer destAcc_no, Integer amount) {
	super();
	this.sourceAcc_no = sourceAcc_no;
	this.destAcc_no = destAcc_no;
	this.amount = amount;
}

}
