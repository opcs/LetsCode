package com.op.immutable;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class  Employee {
	private final int id;
	private final String name;
	private final List<String> projects;
	private final Date doj;
	
	public Employee(int id, String name, List<String> projects, Date doj) {
		this.name = name;
		this.projects = projects;
		this.doj=doj;
		this.id=id;
		
	}
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getProjects() {
		return Collections.unmodifiableList(projects);
	}

	public Date getDoj() {
		return new Date(doj.getTime());
	}
	
	

}
