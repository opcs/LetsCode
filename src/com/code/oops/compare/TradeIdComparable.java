package com.code.oops.compare;

public class TradeIdComparable implements Comparable<Trade>{

	Integer tradeId;
	String tradeType;
	
	public TradeIdComparable(Trade trade) {
		this.tradeId = trade.getTradeId();
		this.tradeType = trade.getTradeType();
	}


	@Override
	public int compareTo(Trade o) {
		Trade trade2=o;
		return this.tradeId.compareTo(trade2.getTradeId());
	}

}
