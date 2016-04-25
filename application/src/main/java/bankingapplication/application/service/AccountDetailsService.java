package bankingapplication.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankingapplication.application.dao.AccountDetailsDaoImpl;
import bankingapplication.application.model.Account;

@Service
public class AccountDetailsService {

	//@Autowired
	private AccountDetailsDaoImpl daoImpl; //=new AccountDetailsDaoImpl();

	public AccountDetailsDaoImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(AccountDetailsDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public Account getAccountDetails(int accountId) {
		if(accountId<1)
			return null;
		return daoImpl.getAccountDetails(accountId);
		
	}
	
	public String getAccountName(int accountId){
		
		//return "Arbitrary Name from Service";
		return daoImpl.getAccountName(accountId);
	}

}
