package assignment07;

import static org.junit.Assert.*;
import java.util.Comparator;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSearchTree {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void basicFunctionality() {
		SearchTree<Integer> tree = new SearchTree<>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}, false);
		
		Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (Integer val : values){
			tree.add(val);
		}
		
		Integer removed = tree.removeReference(values[6]);
		assertEquals(removed, values[6]);
		
		Integer test = tree.removeReference(removed);
		assertEquals(test, null);
	}
	
//	@Test
//	public void testAVL(){
//		SearchTree<Integer> tree = new SearchTree<>(new Comparator<Integer>(){
//			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2);
//			}
//		}, true);
//		
//		Integer[] values = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		for (Integer val : values){
//			tree.add(val);
//		}
//		
//		tree.checkStructure();
//	}

	@Test
	public void ensureAVLBehavior(){
		SearchTree<Integer> tree = new SearchTree<>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}, true);
		
		Integer a = 6;
		Integer b = 8;
		Integer c = 9;
		//Integer d = 1;
		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		
		tree.checkStructure();
	}
	
	@Test 
	public void stressTest(){
		 Random r = new Random(2);
	     Integer[] result = new Integer[50];
	     for (int i = 0; i < 50; i++)
	    	 result[i] = r.nextInt(90)+10;
	     
	     SearchTree<Integer> tree = new SearchTree<>(new Comparator<Integer>(){
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			}, true);
	     
	     for (Integer val : result){
	    	 tree.add(val);
	    	 System.out.println(val + " added");
	     }
	     
	     tree.checkStructure();
	}
}
