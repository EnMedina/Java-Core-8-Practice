package com.enriquemedina.JavaCorePractice.Streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice1 {
	
	
	public List<String> convertToUpperCase(List<String> list){
		Stream<String> stream = list.stream();
		
		return stream.map(String::toUpperCase).collect(Collectors.toList());
	}
	
	public List<String> filterLess4Characters(List<String> list){
		Stream<String> stream = list.stream();
		
		return stream.filter( n -> n.length() > 4).collect(Collectors.toList());
	}
	
	public List<String> flattenMultiDimensional(List<List<String>> list){
		
		List<String> collected =  list.stream().flatMap(p -> p.stream()).collect(Collectors.toList());
		System.out.println(collected.toString()); 
		return collected;
	}
	
	public int oldestFromCollection(List<Integer> l) {
		Comparator<Integer> c = new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1-o2;
			}
		};
		
		return l.stream().max(c).get();
		

	}
	
	
	
	
}
