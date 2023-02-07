package com.masai.services;

import java.util.List;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.InsufficentBalanceException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;

public interface AccountServices {

	public Account createAccountService(Account account)throws AccountException;
	
	public Account findAccountbytherAcc_no(Integer accno)throws AccountException;
	
	public Account removeAccountByAcc_no(Integer accno)throws AccountException;
	
	public List<Account> ListOfAccounts()throws AccountException;
	
	public Account depositAmmount(Integer accno, Integer amount)throws AccountException;
	
	public Account withdrawAmount(Integer accno, Integer amount)throws AccountException,InsufficentBalanceException;
	
	public String transferAmount(AccountDTO dto)throws AccountException,InsufficentBalanceException;
	
}
