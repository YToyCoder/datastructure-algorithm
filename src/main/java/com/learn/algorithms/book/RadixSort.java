package com.learn.algorithms.book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
	public int[] sort(int[] source){
		int len = source.length;
		List<List<Integer>> buckets = new ArrayList<>();
		int[] sizes = new int[10];
		int max = source[0];
		for(int i=0; i<10; i++)
			buckets.add(new LinkedList<>());
		for(int i : source){
			List<Integer> bucket = buckets.get(i%10);
			sizes[i%10]++;
			bucket.add(i);
			if(max < i) max = i;
		}
		for(int i=1; i<=max; i = i*10){
			int bloc = 0;
			int onesize;
			for(List<Integer> one : buckets){
				onesize = sizes[bloc++];
				while(onesize > 0){
					int el = one.remove(0);
					int toadd = (el % (i * 100))/ (i * 10);
					buckets.get(toadd).add(el);
					onesize--;
				}
			}
			for(bloc = 0; bloc<10; bloc++)
				sizes[bloc] = buckets.get(bloc).size();
		}
		
		int bucketLoc = 0;
		List<Integer> bucket = buckets.get(bucketLoc);
		for(int i=0; i<len; i++){
			while(bucket.isEmpty())bucket = buckets.get(++bucketLoc);
			source[i] = bucket.remove(0);
		}
		return source;
	}
}
