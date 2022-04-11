package com.learn.utils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lists {
	
	private Lists(){}

	public static <T> String listToString(List<T> list){
		StringBuilder stringBuilder = new StringBuilder("[");
		if(list.isEmpty()) return stringBuilder.append("]").toString();
		stringBuilder.append(list.get(0));
		for(int i=1; i<list.size(); ++i)
			stringBuilder.append(",").append(list.get(i));
		return stringBuilder.append("]").toString();
	}
	
	public static String intArrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder("(");
		for(int i : arr){
			sb.append(" ").append(Integer.toString(i));
		}
		sb.append(" )");
		return sb.toString();
	}
	
	public static boolean contains(List<List<Integer>> collection, int[][] arrs){
		if(collection.size() != arrs.length) return false;
		for(int[] item : arrs){
			Predicate<List<Integer>> predicate = input -> {
				if(input.size() != item.length) return false;
				for(int i : item){
					if(!input.contains(i)){
						return false;
					}
					if(!input.remove(Integer.valueOf(i))){
						return false;
					}
				}
				return input.isEmpty();
			};
			collection = collection.stream().filter(each -> !predicate.test(each)).collect(Collectors.toList());
		}
		return collection.isEmpty();
	}
}
