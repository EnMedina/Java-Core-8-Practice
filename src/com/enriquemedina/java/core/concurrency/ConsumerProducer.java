package com.enriquemedina.java.core.concurrency;
import java.util.Stack;

public class ConsumerProducer {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Producer p = new Producer(stack);
		p.start();
		long t = System.currentTimeMillis();
		
		Consumer[] consumers = new Consumer[10];
		for(int i = 0 ; i < 10 ; i++) {
			consumers[i] = new Consumer(stack);
		}
		

		for(int i = 0 ; i < 10 ; i++) {
			consumers[i].start();
		}
		try {
			p.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The time it took was " + (System.currentTimeMillis() - t));
	}	
}

class Producer extends Thread{
	private Stack<String> stack;
	
	Producer(Stack<String> stack){
		this.stack = stack;
	}
	
	public void run() {
		for(int i = 0 ; i < 1000 ; i++) {
			stack.add("Name" + i);

		}
	}
}

class Consumer extends Thread{
	private Stack<String> stack;
	
	Consumer(Stack<String> stack){
		this.stack = stack;
	}
	
	public void run() {
			while(!stack.isEmpty()) {
			
			String s = stack.pop();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "received string " + s);
			}
		
	}
	
	
	
}