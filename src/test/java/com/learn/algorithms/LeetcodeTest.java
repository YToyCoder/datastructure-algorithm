package com.learn.algorithms;

import static org.junit.Assert.assertArrayEquals;

import com.learn.algorithms.book.CountAndSay;
import com.learn.algorithms.book.LowerBound;
import com.learn.algorithms.book.RemoveElement;
import com.learn.algorithms.leetcode.easy.MinBitFlips;
import com.learn.algorithms.leetcode.easy.NextGreatestLetter;
import com.learn.algorithms.leetcode.easy.NumWays;
import com.learn.algorithms.leetcode.easy.NumberOfLines;
import com.learn.algorithms.leetcode.hard.RangeModule;
import com.learn.algorithms.leetcode.medium.ConvertTime;
import com.learn.algorithms.leetcode.medium.Divide;
import com.learn.algorithms.leetcode.medium.FourSum;
import com.learn.algorithms.leetcode.medium.Insert;
import com.learn.algorithms.leetcode.medium.Jump;
import com.learn.algorithms.leetcode.medium.MinDeletion;
import com.learn.algorithms.leetcode.medium.MinEatingSpeed;
import com.learn.algorithms.leetcode.medium.SortColors;
import com.learn.algorithms.leetcode.medium.WordFilter;

import org.junit.Test;

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

	public void testJump(){
		Jump code = new Jump();
		int res0 = code.jump(new int[]{1,1,1,1});
		assertEquals(3, res0);
		int res1 = code.jump(new int[]{2,3,1,1,4});
		assertEquals(2, res1);
		int res2 = code.jump(new int[]{2,3,0,1,4});
		assertEquals(2, res2);
		int res3 = code.jump(new int[]{1,2});
		assertEquals(1, res3);
		int res4 = code.jump(new int[]{0});
		assertEquals(0, res4);
		int res5 = code.jump(new int[]{3});
		assertEquals(0, res5);
		int res6 = code.jump(new int[]{2, 1});
		assertEquals(1, res6);
	}
	
	public void testDivide(){
		Divide code = new Divide();
		int res0 = code.divide(7, 3);
		assertEquals("7/3 = 2", 2, res0);
		int res1 = code.divide(7, -3);
		assertEquals("7/-3 = -2", -2, res1);
		int res2 = code.divide(-2147483648,-1);
		assertEquals("-2147483648/-1 = 2147483647", 2147483647, res2); 
		int res3 = code.divide(2147483647,3);
		assertEquals("2147483647/3", 715827882, res3);
	}
	
	public void testNumberOfLines(){
		NumberOfLines code = new NumberOfLines();
		int[] res1 = code.numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz");
		assertArrayEquals(new int[]{3,60}, res1);
		int[] res2 = code.numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa");
		assertArrayEquals(new int[]{2,4}, res2);
	}
	
	public void testInsert(){
		Insert code = new Insert();
	}
	
	public void testNumWays(){
		NumWays code = new NumWays();
		assertEquals("0", 1, code.numWays(0));
		assertEquals("1", 1, code.numWays(1));
		assertEquals("2", 2, code.numWays(2));
		assertEquals("44", 134903163, code.numWays(44));
		assertEquals("46", 971215059, code.numWays(46));
	}

	public void testMinEatingSpeed() {
		MinEatingSpeed code = new MinEatingSpeed();
		int ans = code.minEatingSpeed(new int[]{3,6,7,11}, 8);
		assertEquals("3 6 7 11 - 8", 4, ans);
		int ans1 = code.minEatingSpeed(new int[]{30,11,23,4,20}, 5);
		assertEquals(30, ans1);
	}
	
	public void testSortColors() {
		var code = new SortColors();
		var case1 = new int[] {2,1,2};
		code.sortColors(case1);
		assertArrayEquals("2, 1, 2", new int[]{1, 2, 2}, case1);
		var case2 = new int[] {2,0,1};
		code.sortColors(case2);
		assertArrayEquals("2, 0, 1", new int[]{0, 1, 2}, case2);
		var case3 = new int[]{0,2,2,2,0,2,1,1};
		code.sortColors(case3);
		assertArrayEquals("0,2,2,2,0,2,1,1", new int[]{0,0,1,1,2,2,2,2}, case3);
	}

	public void testRangeModule(){
		final var code = new RangeModule();
		code.addRange(10, 20);
		code.removeRange(14, 16);
		assertTrue("range(10, 14) is in it", code.queryRange(10, 14));
		Integer integer = code.map().get(16);
		System.out.println(integer);
	}

	public void testRangeModule2(){
		final var code = new RangeModule();
		code.addRange(6, 8);
		code.removeRange(7, 8);
		code.removeRange(8, 9);
		code.addRange(8, 9);
		code.removeRange(1, 3);
		code.addRange(1, 8);
		assertTrue("range(10, 14) is in it", code.queryRange(10, 14));
		Integer integer = code.map().get(16);
		System.out.println(integer);
	}

	@Test
	public void testFourSum() {
		final var code = new FourSum();
		final var res  = code.fourSum(new int[] {1,0,-1,0, -2, 2}, 0);
		System.out.println(res);
	}

	@Test
	public void testWordFilter() {
		final var code = new WordFilter(new String[]{"abbba", "abba"});
		assertEquals(1, 
		code.f("ab", "ba")
		);
	}
}
