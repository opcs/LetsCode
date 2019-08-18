package com.code.thread;

class Account{
static int counter=0;
	 synchronized static void showAccount(String accountName){
	     System.out.println("account "+accountName+" Holder Name "+Thread.currentThread().getName());
	     try{
	    	 for(int i=0;i<50;i++){
	    		 counter++;
	    		 System.out.println(Thread.currentThread().getName() + " - " + counter);
	    	 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	   }
	}

	class MyThread1 extends Thread{
	    public void run(){
	       Account.showAccount("saving");
	  }
	}

	class MyThread3 extends Thread{
	    public void run(){
	    	Account saving1 = new Account();
	    	saving1.showAccount("saving1");
	  }
	}
	
	class MyThread2 extends Thread{
	    public void run(){
	       Account.showAccount("current");
	    }
	}

	

	public class StaticSyncDemo{
	    public static void main(String t[]){
	       MyThread1 t1 = new MyThread1();
	       MyThread2 t2 = new MyThread2();
	       MyThread3 t3 = new MyThread3();
	      
	       t1.setName("T1");
	       t2.setName("T2");
	       t3.setName("T3");  
	       
	       t1.start();
	       t2.start();
	       t3.start();
	      
	    }
	}
