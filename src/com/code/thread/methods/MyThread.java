package com.code.thread.methods;

public class MyThread extends Thread{

	private String name;
	private InstanceMethodTest myobj;
	public MyThread(String name, InstanceMethodTest myobj) {
		this.name = name;
		this.myobj = myobj;
	}
	
	public MyThread(String name) {
		this.name = name;
	}
	
	public void run() {
		if(myobj!=null)
			myobj.foo(name);
		else if(name.equals("1")) StaticMethodTest.staticfoo(name);
		else if(name.equals("2")) StaticMethodTest.staticBar(name);
			
	}
	
	
}
