package com.learn.algorithms.leetcode.hard;

public class MedianofTwoSortedArrays {
    /** Description:
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     * @date 2021-11-13
     * Result:
     * Runtime: 2 ms, faster than 99.89% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.7 MB, less than 37.66% of Java online submissions for Median of Two Sorted Arrays.
     */
    public static double apply1(int[] nums1, int[] nums2){
			boolean oddSize = (nums1.length + nums2.length)%2 == 0;
			int medianLoc = (nums1.length + nums2.length)/2;
			int n1loc = 0;int n2loc = 0;
			int lowerBoudV =  (int)Math.pow(10,6) + 1;
			int curV = lowerBoudV ;
			int preV = lowerBoudV;
			for(int i=0; i<=medianLoc; i++){
					preV=curV;
					int n1V = n1loc < nums1.length ? nums1[n1loc] : lowerBoudV;
					int n2V = n2loc < nums2.length ? nums2[n2loc] : lowerBoudV;
					curV = Math.min(n1V,n2V);
					if( n1V > n2V ) n2loc++;
					else n1loc++;
			}
			return oddSize ? (preV + curV)/2.0 : curV;
	}
}
