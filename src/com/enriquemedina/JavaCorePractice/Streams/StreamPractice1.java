package com.enriquemedina.JavaCorePractice.Streams;

import java.util.List;
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
}
