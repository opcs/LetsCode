package com.op.xml.parse;

import java.util.List;

public class Company {
List<Staff> staffs;

public List<Staff> getStaffs() {
	return staffs;
}

public void setStaffs(List<Staff> staffs) {
	this.staffs = staffs;
}

public Company(List<Staff> staffs) {
	super();
	this.staffs = staffs;
}

}
