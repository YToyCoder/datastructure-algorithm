package com.learn.ds.BitMap;

import java.util.Arrays;
import java.util.Iterator;


public class BitMap implements Iterable<Byte> {
	/**
	 * 01234567890123456789
	 */
	private byte[] map;
	private int maxval;
	private static int DEFAULT_MAX_SIZE = 1 << 10;
	
	public BitMap(int maxval){
		this.maxval = maxval;
		map = new byte[maxval];
	}
	
	public BitMap(){
		this(DEFAULT_MAX_SIZE);
	}
	
	public void put(int val){
		rangeCheck(val);
		map[val] = 1;
	}

	public boolean exists(int val){
		rangeCheck(val);
		return map[val] == 1;
	}

	private void rangeCheck(int val){
		if(val >= maxval){
			expand();
		}
	}

	public static void sort(int[] arr){
		BitMap code = new BitMap();
		for(int item : arr)
			code.put(item);
		Iterator<Byte> iter = code.iterator();
		int count = 0;
		int countArr = 0;
		while(iter.hasNext()){
			byte item = iter.next();
			if(item == 1) arr[countArr++] = count;
			count++;
		}
	}

	private void expand(){
		int old = maxval;
		long expandsize = (long)old * 1 + old / 2;
		if(expandsize > Integer.MAX_VALUE) expandsize = Integer.MAX_VALUE;
		map = Arrays.copyOf(map, (int)expandsize);
	}

	@Override
	public Iterator<Byte> iterator() {
		return new BitMapIterator();
	}
	
	public class BitMapIterator implements Iterator<Byte>{
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < maxval;
		}

		@Override
		public Byte next() {
			return map[current++];
		}
	}
}
