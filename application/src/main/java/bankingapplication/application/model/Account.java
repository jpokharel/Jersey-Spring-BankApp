package bankingapplication.application.model;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * It seems that it is the general practice to Serialize the models.
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;
	private String accountName;

	public Account() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String accountName) {
		// super();
		this.accountId = accountId;
		this.accountName = accountName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
