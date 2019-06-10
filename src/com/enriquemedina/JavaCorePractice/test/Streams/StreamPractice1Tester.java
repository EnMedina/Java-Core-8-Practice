package com.enriquemedina.JavaCorePractice.test.Streams;

import static org.junit.Assert.assertEquals;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.enriquemedina.JavaCorePractice.Streams.StreamPractice1;

public class StreamPractice1Tester {
	List<String> list = new ArrayList<>();
	StreamPractice1 streamPractice = new StreamPractice1();
	
	@Before
	public void cleanList() {
		list.clear();
	}
	
	@Test
	public void convertToUpperCaseTest1() {
		
		list.add("lowercase");
		list.add("camelCase");
		list.add("MoXiToCaSe");
		list.add("UPPERCASE");
		
		List<String> expectedList = new ArrayList<>();
		for(int i = 0 ; i < list.size() ; i++) {
			expectedList.add(list.get(i).toUpperCase());
		}
		
		assertEquals(expectedList,streamPractice.convertToUpperCase(list));
	}
	
	@Test
	public void filterOnly4LettersOrLessTest1() {
		
	}
	
	@Test
	public void flattenStreamTest1(){
		List<List<String>> list2D = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
		List<String> expected = asList("Viktor","Farcic","John","Doe","Third");
		assertEquals(expected, streamPractice.flattenMultiDimensional(list2D));
	}
	
	@Test
	public void maxNumber() {
		List<Integer> myList = asList(1,3,7,3452,134,756745,1423543,7856);
		assertEquals(1423543,streamPractice.oldestFromCollection(myList));
		
	}
}
