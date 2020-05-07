package com.op.oops.compare;

public class Trade {

	int tradeId;
	String tradeType;
	
	public Trade(int petid, String petType) {
		this.tradeId = petid;
		this.tradeType = petType;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
}
