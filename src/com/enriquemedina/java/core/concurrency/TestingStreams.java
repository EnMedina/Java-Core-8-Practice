package com.enriquemedina.java.core.concurrency;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestingStreams {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Enrique");
		for(int i = 0 ; i < 1000 ; i++) {
			list.add("Name"+i);
		}
		
		Stream<String> stream = list.parallelStream();
		
		// Trying with parallel processing
		long start = System.currentTimeMillis();
		stream.forEach(i -> processData());
		System.out.println("Time processing parallel : " +( System.currentTimeMillis() - start));
		
		// Trying with sequential processing
		stream = list.stream();
		start = System.currentTimeMillis();
		stream.forEach(i -> processData());
		System.out.println("Time processing sequential : " +( System.currentTimeMillis() - start));			
	}
	
	
	public static void processData() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
