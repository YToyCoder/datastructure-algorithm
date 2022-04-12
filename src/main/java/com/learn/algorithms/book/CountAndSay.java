package com.learn.algorithms.book;

public class CountAndSay {
	public String countAndSay(int n){
		if(n == 1) return "1";
		String res = "1";
		for(int i=1; i<n ; i++){
			res = nextString(res);
		}
		return res;
	}
	
	private String nextString(String old){
		StringBuilder next = new StringBuilder();
		int cnt = 1;
		for(int i=0; i<old.length(); i++){
			if(i + 1 < old.length() && old.charAt(i) == old.charAt(i + 1)){
				cnt++;
			}else{
				next.append(cnt).append(old.charAt(i));
				cnt = 1;
			}
		}
		return next.toString();
	}
}
