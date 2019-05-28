package com.enriquemedina.java.core.concurrency;
import java.util.ArrayList;
import java.util.List;

public class NewProducerConsumer {
	static List<Integer> list = new ArrayList<>();
	final static int BOTTOM = 0;
	final static int LIMIT  = 5;
	static int currVal = 0;
	static Object lock = new Object();
	static boolean stopper = false;
	
	
	public static void produce() throws InterruptedException{
		synchronized(lock) {
			while(!stopper){
				if(list.size() == LIMIT) {
					System.out.println("There's now a full list");
					lock.notify();
					lock.wait();
				}else {
					list.add(currVal);
					currVal++;
					
				}
				Thread.sleep(100);
			}
			lock.notify();
		}
		
	}
	
	public static void consume() throws InterruptedException {
		Thread.sleep(1000);
		
		synchronized(lock) {
			while(!stopper){
				if(list.size() == BOTTOM) {
					System.out.println("There's now an empty list");
					lock.notify();
					lock.wait();
				}
				else {
					list.remove(0);
					
				}
				Thread.sleep(100);
			}
			lock.notify();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				NewProducerConsumer.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				NewProducerConsumer.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}); 
		
		t1.start();
		t2.start();
		Thread.sleep(10000);
		stopper = true;
		t1.join();
		t2.join();
		System.out.println("The two threads have died");
		
	}
}

