package com.op.singleton;

public class DoubleLockingSingleton {

	private DoubleLockingSingleton instance;
	
	DoubleLockingSingleton getInstance(){
		if(instance==null){
			synchronized(DoubleLockingSingleton.class){
				if(instance==null){
					instance = new DoubleLockingSingleton();
				}
			}
		}
		return instance;
	}
}
