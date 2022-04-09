package com.learn.algorithms.leetcode.medium;

public class ZigzagConversion {
	
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * Runtime: 11 ms, faster than 47.05% of Java online submissions for Zigzag Conversion.
     * Memory Usage: 47.2 MB, less than 17.84% of Java online submissions for Zigzag Conversion.
     */
    public static String convert(String s, int numRows) {
			if(numRows == 1) return s;
			int gap = 2*numRows - 2;
			StringBuilder sb = new StringBuilder();
			int charLoc = 0;
			int charLoc2 = 0;
			int slen = s.length();
			for(int i=0; i<numRows; i++){
					charLoc = i;
					if(i==0 || i == numRows -1 ) {
							for(;charLoc < slen;charLoc += gap){
									sb.append(s.substring(charLoc,charLoc+1));
							}
					}else{
							charLoc2 = gap - i;
							for(; charLoc < slen || charLoc2 < slen; charLoc += gap, charLoc2 += gap){
									sb.append(s.substring(charLoc,charLoc+1));
									if(charLoc2 <slen)sb.append(s.substring(charLoc2,charLoc2+1));
							}
					}
			}
			return sb.toString();
	}

	/**
	 * Runtime: 5 ms, faster than 79.48% of Java online submissions for Zigzag Conversion.
	 * Memory Usage: 41.8 MB, less than 35.89% of Java online submissions for Zigzag Conversion.
	 */
	public static String convert2(String s, int numRows) {
			if(numRows == 1) return s;
			int gap = 2*numRows - 2;
			int charLoc = 0;
			int charLoc2 = 0;
			int slen = s.length();
			char[] originV = s.toCharArray();
			char[] innerV = new char[slen];
			int inputloc = 0;
			for(int i=0; i<numRows;i++){
					charLoc = i;
					charLoc2 = gap - i;
					for(;charLoc < slen || charLoc2 < slen; charLoc += gap, charLoc2 += gap){
							innerV[inputloc++] = originV[charLoc];
							if(i != 0 && i != numRows - 1 && charLoc2 < slen){
									innerV[inputloc++] = originV[charLoc2];
							}
					}
			}
			return new String(innerV);
	}
}
