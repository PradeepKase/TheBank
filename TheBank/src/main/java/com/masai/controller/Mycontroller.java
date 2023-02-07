package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.InsufficentBalanceException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;
import com.masai.services.AccountServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Thebank")
public class Mycontroller {

	@Autowired
	private AccountServices accountservices;
	
	@PostMapping("/Registeraccount")
	public ResponseEntity<Account> registerAccountHandler(@Valid @RequestBody Account account) throws AccountException{
	 	Account a= accountservices.createAccountService(account);
		return new ResponseEntity<Account>(a, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Find/{accno}")
	public ResponseEntity<Account> searchAccountByAccountnoHandler(@PathVariable("accno") Integer accno) throws AccountException{
		Account a= accountservices.findAccountbytherAcc_no(accno);
		return new ResponseEntity<Account>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("/DeletByAccNo/{accno}")
	public ResponseEntity<Account> deletAccounthandler(@PathVariable("accno") Integer accno) throws AccountException{
		Account a= accountservices.removeAccountByAcc_no(accno);
		return new ResponseEntity<Account>(a, HttpStatus.OK);
	}
	
	@GetMapping("/ListOfAccounts")
	public ResponseEntity<List<Account>>listOfAccounts() throws AccountException{
		List<Account> accounts= accountservices.ListOfAccounts();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	@PutMapping("/Depositamout/{accno}")
	public ResponseEntity<Account> dipositHandler(@PathVariable("accno") Integer accno, @RequestParam("amount") Integer amount) throws AccountException{
		Account account= accountservices.depositAmmount(accno, amount);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}
	
	@PutMapping("/Depositamout/{accno}/{amount}")
	public ResponseEntity<Account> withdrawHandler(@PathVariable("accno") Integer accno, @PathVariable("amount") Integer amount) throws AccountException, InsufficentBalanceException{
		Account account= accountservices.withdrawAmount(accno, amount);
		return new ResponseEntity<Account>(account,HttpStatus.CREATED);
	}
	
	@PutMapping("/transferAmount")
	public ResponseEntity<String> TransferHandler(@RequestBody AccountDTO dto) throws AccountException, InsufficentBalanceException{
		String str= accountservices.transferAmount(dto);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
}
