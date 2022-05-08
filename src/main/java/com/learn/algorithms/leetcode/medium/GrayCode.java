package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
//     每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
//     第一个整数是 0
//     一个整数在序列中出现 不超过一次
//     每对 相邻 整数的二进制表示 恰好一位不同 ，且
//     第一个 和 最后一个 整数的二进制表示 恰好一位不同
// 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/gray-code
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class GrayCode {

	/**
	 * 00000 
	 * 00001
	 * 00011 1
	 * 00010
	 * 00110 2
	 * 00111
	 * 00101
	 * 00100
	 * 01100 3
	 * 01110
	 * 01111
	 * 01101
	 * 01001
	 * 01000
	 * 11000 4
	 * 11100
	 */
	public List<Integer> grayCode(int n) {
		if(n == 1) return List.of(0b0, 0b01);
		List<Integer> codes = new ArrayList<>();
		codes.add(0b0);
		codes.add(0b01);
		int size, val;
		for(int i=1; i<n; i++){
			size = codes.size();
			for(int j=size; j > 0; j--){
				val = codes.get(j - 1);
				codes.add(val | 0b01 << i);
			}
		}
		return codes;
	}
}
