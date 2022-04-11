package com.learn.ds;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import com.learn.ds.BitMap.BitMap;

import org.junit.Test;

public class TestBitmap {
	
	@Test
	public void test1(){
		int[] source = new int[]{2,4,9,8,10};
		int[] copy = Arrays.copyOf(source, source.length);
		BitMap.sort(source);
		Arrays.sort(copy);
		assertArrayEquals(source, copy);
	}
}
