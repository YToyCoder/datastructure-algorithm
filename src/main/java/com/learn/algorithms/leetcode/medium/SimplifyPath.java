package com.learn.algorithms.leetcode.medium;

import java.util.Objects;
import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> store = new Stack<>();
		int index =  -1;
		path = path.substring(1);
		String substring = "";
		while(!path.isEmpty()){
			index = path.indexOf("/");
			if(index == 0){
				path = path.substring(1);
			}else{
				if(index == -1){
					substring = path;
					index = path.length() - 1;
				}else substring = path.substring(0, index);
				if( !Objects.equals(substring, ".") && !Objects.equals(substring, "..")){
					store.add(substring);
				}else{
					if(Objects.equals(substring, "..") && store.size() > 0){
						store.pop();
					}
				}
				path = path.substring(index + 1);
			}
		}
		if(store.isEmpty()) return "/";
		StringBuilder sb = new StringBuilder();
		while(!store.isEmpty()){
			sb.insert(0, store.pop()).insert(0, "/");
		}
		return sb.toString();
	}
}
