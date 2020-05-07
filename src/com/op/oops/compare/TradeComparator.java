package com.op.oops.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TradeComparator implements Comparator<Trade> {

	public static void main(String[] args) {
		List<Trade> trades=new ArrayList<>();
		trades.add(new Trade(2, "Dog"));
		trades.add(new Trade(1,"Parot"));
		trades.add(new Trade(2, "Cat"));
		
		//Collections.sort(trades);

	}

	@Override
	public int compare(Trade o1, Trade o2) {
		int result=0;
		Integer T1id=o1.getTradeId();
		Integer T2id=o2.getTradeId();
		result=T1id.compareTo(T2id);
		if(result==0) {
			result=o1.getTradeType().compareTo(o2.getTradeType());
		}
		
		return result;
	}


}
