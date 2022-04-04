package com.learn.algorithms;

import com.learn.algorithms.leetcode.book.CountAndSay;
import com.learn.algorithms.leetcode.book.LowerBound;
import com.learn.algorithms.leetcode.book.RemoveElement;
import com.learn.algorithms.leetcode.easy.MinBitFlips;
import com.learn.algorithms.leetcode.easy.NextGreatestLetter;
import com.learn.algorithms.leetcode.medium.ConvertTime;
import com.learn.algorithms.leetcode.medium.MinDeletion;

import junit.framework.TestCase;

public class LeetcodeTest extends TestCase {
	
	public LeetcodeTest(String name){
		super(name);
	}
	
	public void testCountAndSay(){
		CountAndSay code = new CountAndSay();
		String res1 = code.countAndSay(1);
		assertEquals("1", res1);
		String res2 = code.countAndSay(2);
		assertEquals("11", res2);
		String res3 = code.countAndSay(3);
		assertEquals("21", res3);
		String res4 = code.countAndSay(4);
		assertEquals("1211", res4);
		String res5 = code.countAndSay(6);
		assertEquals("312211", res5);
	}
	
	public void testRemoveElement(){
		RemoveElement code = new RemoveElement();
		int res1 = code.removeElement(new int[]{3,2,2,3}, 3);
		assertEquals(2, res1);
	}
	

	public void testLowerBound(){
		LowerBound code = new LowerBound();
		int res1 = code.lowerBound(new int[]{1,1,2,2,3,4}, 3);
		assertEquals(3, res1);
		int res2 = code.lowerBound(new int[]{1,1,2,2,3,4}, 0);
		assertEquals("{1,1,2,2,3,4},0", -1, res2);
		int res3 = code.lowerBound(new int[]{1,1,2,2,3,4}, -1);
		assertEquals("{1,1,2,2,3,4},-1",-1, res3);
		int res4 = code.lowerBound(new int[]{1,1,2,2,3,4}, 1);
		assertEquals("{1,1,2,2,3,4},1",-1, res4);
		int res5 = code.lowerBound(new int[]{0,1,2,2,3,4}, 1);
		assertEquals("{0,1,2,2,3,4},1", 0, res5);
		int res6 = code.lowerBound(new int[]{-4,-4,2,2,3,4}, -1);
		assertEquals("{-4,-4,2,2,3,4},0", 1, res6);
	}
	
	public void testNextGreatestLetter(){
		NextGreatestLetter code = new NextGreatestLetter();
		char res1 = code.nextGreatestLetter(new char[]{'c','f','j'}, 'd');
		assertEquals("输入: [c f j], d", 'f', res1);
	}
	
	public void testMinBitFlips() {
		MinBitFlips code = new MinBitFlips();
		int res1 = code.minBitFlips(10, 7);
		assertEquals(3, res1);
		int res2 = code.minBitFlips(3, 4);
		assertEquals(3, res2);
	}
	
	public void testMinDeletion(){
		MinDeletion code = new MinDeletion();
		int res1 = code.minDeletion(new int[]{1,1,2,3,5});
		assertEquals(1, res1);
		int res2 = code.minDeletion(new int[]{1,1,2,2,3,3});
		assertEquals(2, res2);
	}
	
	public void testConvertTime(){
		ConvertTime code = new ConvertTime();
		int res1 = code.convertTime("02:30", "04:35");
		assertEquals(3, res1);
		int res2 = code.convertTime("11:00", "11:01");
		assertEquals(1, res2);
	}
}
