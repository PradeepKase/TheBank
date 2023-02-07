package com.masai.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exceptions.AccountException;
import com.masai.exceptions.InsufficentBalanceException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;
import com.masai.repository.AccountDAO;

@Service
public class AccountServiceImpl implements AccountServices{

	@Autowired
	private AccountDAO adao;
	
	@Override
	public Account createAccountService(Account account) throws AccountException {
		// TODO Auto-generated method stub
		Account acount= adao.save(account);
		return acount;
	}

	@Override
	public Account findAccountbytherAcc_no(Integer accno) throws AccountException {
		// TODO Auto-generated method stub
//		Optional<Account> account = adao.findById(accno)
//		if(account.isEmpty()) {
//			throw new AccountException("account not found wiht"+ accno);
//		}
//		return account.get();
		
		//functional way
		return adao.findById(accno).orElseThrow(()->new AccountException("account not found wiht" + accno));
	}

	@Override
	public Account removeAccountByAcc_no(Integer accno) throws AccountException {
		// TODO Auto-generated method stub
		Optional<Account>account= adao.findById(accno);
		if(account.isPresent()) {
			adao.deleteById(accno);
			return account.get();
		}
		else {
			throw new AccountException("account not found wiht" + accno);
		}
	}

	@Override
	public List<Account> ListOfAccounts()throws AccountException {
		// TODO Auto-generated method stub
		List<Account>list= adao.findAll();
		if(!list.isEmpty()) {
			return list;	
		}
		else {
			throw new AccountException("there are no accounts");
		}
		
	}

	@Override
	public Account depositAmmount(Integer accno, Integer amount) throws AccountException {
		// TODO Auto-generated method stub
		Account ac= adao.findById(accno).orElseThrow(()->new AccountException("Account not found"));
		ac.setAmount(ac.getAmount()+amount);
		return adao.save(ac);
	}

	@Override
	public Account withdrawAmount(Integer accno, Integer amount) throws AccountException, InsufficentBalanceException {
		// TODO Auto-generated method stub
		Account ac= adao.findById(accno).orElseThrow(()->new AccountException("Account not found"));
		if(ac.getAmount()<amount) {
			throw new InsufficentBalanceException("you have less amount");
		}
		else{
			ac.setAmount(ac.getAmount()-amount);
			return adao.save(ac);
		}
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficentBalanceException {
		// TODO Auto-generated method stub
		Account withdraw= withdrawAmount(dto.getSourceAcc_no(), dto.getAmount());
		if(withdraw.getAmount()<0) {
			throw new InsufficentBalanceException("insufficient balance");
		}
		Account deposit= depositAmmount(dto.getDestAcc_no(),  dto.getAmount());
		return "Trsnfer Succesfull";
	}
	
	
	
	
	
}
