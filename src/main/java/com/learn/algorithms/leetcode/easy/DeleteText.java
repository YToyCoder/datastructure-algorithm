package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class DeleteText {
	
	public String deleteText(String article, int index) {
		if(Objects.equals(article.charAt(index), ' ')) return article;
		int len = article.length();
		int front = 0;
		int back = -1;
		for(int i=0; i<len; i++){
			if(i < index && Objects.equals(article.charAt(i), ' ')){
				front = i;
			}else if(i > index && Objects.equals(article.charAt(i), ' ')){
				back = i;
				break;
			}
		}
		return (article.substring(0, front) + (back != -1 ?  article.substring(back, len) : "") ).trim() ;
	}
}
