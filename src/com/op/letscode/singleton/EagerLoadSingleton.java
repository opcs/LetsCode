package com.op.letscode.singleton;

public class EagerLoadSingleton {

	private static EagerLoadSingleton instance;
	
	static{
		synchronized(EagerLoadSingleton.class){
			if(instance==null){
				instance=new EagerLoadSingleton();
			}
		}
		
	}
}
