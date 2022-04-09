package com.learn.algorithms.leetcode.medium;

public class LongestPalindromicSubstring {
	
	public static  String apply1(String s) {
		int slen = s.length();
		int[] subLen = new int[slen];
		int maxLen = 1;
		int maxLenLoc = 0;
		for(int i=0; i<slen; i++) subLen[i] = 0;
		for(int i=0; i< slen; i++){
				for(int j=slen -1 ; j >= i; --j){
						if(isPalindrome(s,i,j)){
								subLen[i] = j - i + 1 > subLen[i] ? j-i+1 : subLen[i];
								if(subLen[i] == slen - i)break;
						}
				}
				if(subLen[i] > maxLen){
						maxLenLoc = i;
						maxLen = subLen[i];
				}
				if(subLen[i] == slen - i)break;
		}
		return s.substring(maxLenLoc,maxLenLoc + maxLen);

}

private static boolean isPalindrome(String s, int start, int end){
		if(start < end)
				while(start <= end){
						if(!s.substring(start, start+1).equals(s.substring(end,end + 1)))
								return false;
						start++;
						end--;
				}
		return true;
}
}
