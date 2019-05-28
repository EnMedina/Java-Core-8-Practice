package com.enriquemedina.java.core.concurrency;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducerLock {
	public static void main(String[] args) {
		WorkerClass w = new WorkerClass();
		Thread t1 = new Thread(() -> w.produce());
		Thread t2 = new Thread(() -> w.consume());
		
		t1.start();
		t2.start();
	}
	
}
 class WorkerClass{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void produce() {
		try {
			lock.lock();
			System.out.println("Producer method");
			condition.signal();
			condition.await();
			System.out.println("Producer again");
			condition.signal();
		} catch (InterruptedException e) {}
		finally {lock.unlock();}
	}
	
	public void consume() {
		
		try {
			lock.lock();
			Thread.sleep(2000);
			System.out.println("Consumer method");
			condition.signal();
			condition.await();
			condition.signal();
		} catch (InterruptedException e) {}
		finally {lock.unlock();}
		
		System.out.println("Consumer again");
		
	}
 }