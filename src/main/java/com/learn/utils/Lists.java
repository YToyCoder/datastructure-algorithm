package com.learn.utils;

import java.util.List;

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
			sb.append(" ").append(i);
		}
		sb.append(" )");
		return sb.toString();
	}
}
