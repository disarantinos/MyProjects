package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class EqualSumTest {
	LogicTest l=new LogicTest();
	@Test
	public void test00() {
		
		assertTrue(l.EqualSum(5, new int[] { 1, 2, 3 }));
	}
	
	@Test
	public void test01() {
		assertFalse(l.EqualSum(7, new int[] { 1, 2, 3 }));
	}
	
	@Test
	public void test02() {
		assertFalse(l.EqualSum(4, new int[] { 1, 2, 2 }));
	}
	
	@Test
	public void test03() {
		assertTrue(l.EqualSum(8, new int[] { 1, 2, 3,4 ,5 }));
	}
	
	@Test
	public void test04() {
		assertFalse(l.EqualSum(5, new int[] { 1, 2, 2,3 }));
	}
	
	
	@Test
	public void test05() {
		assertTrue(l.EqualSum(5, new int[] {  2, 2,1,3,4 }));
	}
	
	@Test
	public void test06() {
		assertFalse(l.EqualSum(0, new int[] { 0 }));
	}
	
	@Test
	public void test07() {
		assertFalse(l.EqualSum(3, new int[] { 1,2,2}));
	}

}
