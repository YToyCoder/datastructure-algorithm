package com.learn.algorithms.leetcode.medium;

public class ConvertTime {

	public int convertTime(String current, String correct) {
		String[] curs = current.split(":");
		String[] cors = correct.split(":");
		int[] cursInt = new int[]{Integer.valueOf(curs[0]), Integer.valueOf(curs[1])};
		int[] corsInt = new int[]{Integer.valueOf(cors[0]), Integer.valueOf(cors[1])};
		int sixty = 0;
		if(cursInt[0] < corsInt[0]){
			sixty = corsInt[0] - cursInt[0] - (corsInt[1] < cursInt[1] ? 1 : 0);
		}
		int plus = corsInt[1] - cursInt[1];
		plus = plus < 0 ? plus + 60 : plus;
		int[] minus = new int[]{1, 5, 15};
		int last = 2;
		while(plus>0){
			// 1 5  15
			while(plus < minus[last]) last--;
			sixty++;
			plus -= minus[last];
		}
		return sixty;
	}
}
