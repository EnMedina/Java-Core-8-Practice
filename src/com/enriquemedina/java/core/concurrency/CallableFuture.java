package com.enriquemedina.java.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableWorker implements Callable<String>{
	String id;
	
	CallableWorker(String id){
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return id;
	}
	
}

public class CallableFuture {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<String>> list = new ArrayList<>();
		
		for(int i = 0 ; i < 5 ; i++) {
			Future<String> future = executorService.submit(new CallableWorker("" + (i+1)));
			list.add(future);
		}
		
		for(Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch(Exception e) {}
		}
	}
	
	
}
