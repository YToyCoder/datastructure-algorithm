package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
	// 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		int last = 1;
		for(int i=1; i<= rowIndex; i++){
			last = 1;
			for(int j=1; j<= i; j++){
				if(j == i){
					res.add(1);
				}else{
					int temp = res.get(j);
					res.set(j, last + temp);
					last = temp;
				}
			}
		}
		return res;
	}
}
