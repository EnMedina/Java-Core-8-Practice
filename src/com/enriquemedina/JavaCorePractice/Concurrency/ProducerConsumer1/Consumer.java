package com.enriquemedina.JavaCorePractice.Concurrency.ProducerConsumer1;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<String> q;
	
	Consumer(BlockingQueue<String> q){
		this.q = q;
	}

	@Override
	public void run() {
		while(true) {
			try {
				String s = q.take();
				System.out.println("We have consumed" + s);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
