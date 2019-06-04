package com.enriquemedina.JavaCorePractice.Concurrency.core;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
	private static int counter = 0;
	private static Lock lock = new ReentrantLock(true);
	
	public static void increment() {
		try{
			lock.lock();
			for(int i = 0 ; i < 1000 ; i++) counter++;
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> increment());
		Thread t2 = new Thread(() -> increment());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Final counter value is " + counter);
	}
	
}
