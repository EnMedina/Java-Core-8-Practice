package com.enriquemedina.JavaCorePractice.Concurrency.ProducerConsumer1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MainApp {
	public static void main(String[] args) {
		BlockingQueue<String> q = new LinkedBlockingDeque<>();
		
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		Thread t1 = new Thread(p,"Producer");
		Thread t2 = new Thread(c,"Consumer");
		
		t1.start();
		t2.start();
	}
}
