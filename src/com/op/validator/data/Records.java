package com.op.validator.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="records")
public class Records {
	List<TxnRecord> record = new ArrayList();
	
	public Records() {	}

	public Records(List<TxnRecord> record) {
		this.record = record;
	}

	@XmlElement
	public List<TxnRecord> getRecord() {
		return record;
	}

	public void setRecord(List<TxnRecord> record) {
		this.record = record;
	}
}
