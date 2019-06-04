package com.enriquemedina.JavaCorePractice.Concurrency.core;

public class ThreadOrder {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Texample("Thread 1"));
		Thread t2 = new Thread(new Texample("Thread 2"));
		
		t1.start();
		try {
			t1.join();
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Hello from Thread 3");
		
	}

}

class Texample implements Runnable{
	private String threadText;
	
	Texample(String threadText){
		this.threadText = threadText;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("Hello from " + threadText);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
