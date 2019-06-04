package com.enriquemedina.JavaCorePractice.Concurrency.core;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorConsumerProducer {
	public static void main(String args[]) throws InterruptedException {
		ExecutorService consExec = Executors.newCachedThreadPool();
		Stack<Integer> stack = new Stack<>();
		Producer2 p = new Producer2(stack);
		Thread t2 = new Thread(p);
		t2.start();
		for(int i = 0 ; i < 100 ; i++) {
			consExec.execute(new Consumer2(stack));
		}
		
		t2.join();
	}
}

class Consumer2 implements Runnable{
	private Stack<Integer> stack;
	
	Consumer2(Stack<Integer> stack){
		this.stack = stack;
	}
	@Override
	public void run() {
		while(!stack.isEmpty()) {
			try {
				Thread.sleep(10);
				Integer i = stack.pop();
				System.out.println(Thread.currentThread().getName() + "received " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(EmptyStackException e) {
				
			}
			
		}
		
	}
	
}

class Producer2 implements Runnable{
	private Stack<Integer> stack;
	
	Producer2(Stack<Integer> stack){
		this.stack = stack;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 1000; i++) {
			stack.add(i);
		}
		
	}
	
}