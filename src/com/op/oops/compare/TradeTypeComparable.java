package com.op.oops.compare;

public class TradeTypeComparable implements Comparable<Trade>{

	int tradeId;
	String tradeType;
	
	public TradeTypeComparable(Trade trade) {
		this.tradeId = trade.getTradeId();
		this.tradeType = trade.getTradeType();
	}


	@Override
	public int compareTo(Trade o) {
		Trade trade2=o;
		return this.tradeType.compareTo(trade2.tradeType);
	}

}
