package com.enriquemedina.JavaCorePractice.test.Streams;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.enriquemedina.JavaCorePractice.Streams.StreamPractice1;

public class StreamPractice1Tester {
	@Test
	public void convertToUpperCaseTest1() {
		List<String> list = new ArrayList<>();
		list.add("lowercase");
		list.add("camelCase");
		list.add("MoXiToCaSe");
		list.add("UPPERCASE");
		
		List<String> expectedList = new ArrayList<>();
		for(int i = 0 ; i < list.size() ; i++) {
			expectedList.add(list.get(i).toUpperCase());
		}
		StreamPractice1 streamPractice = new StreamPractice1();
		assertEquals(expectedList,streamPractice.convertToUpperCase(list));
	}
	
	@Test
	public void filterOnly4LettersOrLessTest1() {
		
	}
}
