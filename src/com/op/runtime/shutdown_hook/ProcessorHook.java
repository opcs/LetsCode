package com.op.runtime.shutdown_hook;

/**
 * @author opcs
 * logging state when the shutdown hook started and if it was not finished already, then send an alert, log only here
 */
public class ProcessorHook extends Thread {

	@Override
	public void run(){
		System.out.println("Status="+FilesProcessor.status);
		System.out.println("FileName="+FilesProcessor.fileName);
		if(!FilesProcessor.status.equals("FINISHED")){
			System.out.println("Seems some error, sending alert");
		}
		
	}
}

