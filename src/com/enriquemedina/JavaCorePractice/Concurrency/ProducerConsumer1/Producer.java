package com.enriquemedina.JavaCorePractice.Concurrency.ProducerConsumer1;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	final BlockingQueue<String> q;
	final int sizeLimit;
	
	Producer(BlockingQueue<String> q,int sizeLimit){
		this.q = q;
		this.sizeLimit = sizeLimit;
	}
	
	@Override
	public void run() {
		int i = 10000;
		while(i > 0) {
			try {
				if(q.size() < sizeLimit) {
					q.put(""+i--);
				}
				
				System.out.println("We have now put " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
