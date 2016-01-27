package org.jiwan.bankingapp.restws.dto;

public class AccountBalanceDto {
	
	private long presentBalance;
	private long usableBalance;
	
	public long getPresentBalance() {
		return presentBalance;
	}
	public void setPresentBalance(long presentBalance) {
		this.presentBalance = presentBalance;
	}
	public long getUsableBalance() {
		return usableBalance;
	}
	public void setUsableBalance(long usableBalance) {
		this.usableBalance = usableBalance;
	}

}
