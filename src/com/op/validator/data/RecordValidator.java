package com.op.validator.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecordValidator {
	
	private static final double EPSILON=0.001;
	 
	 public static String validate(Records records) {
		  List<TxnRecord> txnRecords=records.getRecord() ;
	        Set<String> references = new HashSet();
	        StringBuilder message  = new StringBuilder();
	        double difference;
	        boolean result;
	        if(txnRecords!=null)
	       for(TxnRecord record:txnRecords) {
	    	   
	    	   if(!references.contains(record)) {
	    		   references.add(record.getReference());
	    		    difference = record.getStartBalance()+record.getMutation()-record.getEndBalance();
	    		    result = Math.abs(difference)<EPSILON;
	    		   
	    		   if(!result) {
	    			   prepareMessage(message, record);
	    		   }
	    	   }
	    	   else {
	    		   prepareMessage(message, record);
	    	   }
	       }
			return message.toString();
	 }

	private static void prepareMessage(StringBuilder message, TxnRecord record) {
		message.append(record.getReference()).append(" - ").append(record.getDescription()).append(System.lineSeparator());
	}
}


