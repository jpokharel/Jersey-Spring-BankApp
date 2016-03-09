package bankingapplication.application.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bankingapplication.application.dao.AccountDetailsDaoImpl;
import bankingapplication.application.dao.PlainJdbcConnection;
import bankingapplication.application.service.AccountDetailsService;

public class DataController {

	public static void main(String[] args) {

		
		AccountDetailsDaoImpl dao;
		@SuppressWarnings("bankingapplication.application.resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		dao = ctx.getBean("accountDetailsDaoImpl", AccountDetailsDaoImpl.class);

		System.out.println(dao.getAccountNumber(123));
		System.out.println(dao.getAccountName(123));

		/**
		 * Accessing the account details
		 */

		System.out.println("Account ID: " + dao.getAccountDetails(123).getAccountId() + " Account Name: "
				+ dao.getAccountDetails(123).getAccountName());
		
		
		System.out.println("Calling from Service Layer....");
		//AccountDetailsService accountDetailsService=new AccountDetailsService();
		AccountDetailsService serv=ctx.getBean("accountDetailsService",AccountDetailsService.class);
		System.out.println("No problem detected with the constructor of Service");
		System.out.println("Nane is: "+serv.getAccountName(123));
		
		// Calling the simple jdbc
		System.out.println("-------FROM PLAIN JDBC------------");
		//PlainJdbcConnection pjc=new PlainJdbcConnection();
		System.out.println(PlainJdbcConnection.returnNameOfAccount(123));
	}
}
