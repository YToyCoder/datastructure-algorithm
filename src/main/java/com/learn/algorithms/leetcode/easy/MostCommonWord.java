package com.learn.algorithms.leetcode.easy;

import java.util.*;

public class MostCommonWord {

	/**
	 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
		题目保证至少有一个词不在禁用列表中，而且答案唯一。
		禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

		来源：力扣（LeetCode）
		链接：https://leetcode-cn.com/problems/most-common-word
		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String,Integer> map = new HashMap<>();
		int most = -1;
		String mostVal = "";

		String[] splits = paragraph.split("[!?',;. ]{1,}");
		boolean isIn = false;
		for(String str : splits){
			str = str.toLowerCase();
			isIn = false;
			for(String ban : banned){
				if(Objects.equals(ban, str)){
					isIn = true;
				}
			}
			if(!isIn){
				Integer count = 0;
				if(Objects.nonNull(count = map.get(str))){
					if(++count > most){
						most = count;
						mostVal = str;
					} 
					map.put(str, count);
				}else{
					if(most == -1) {
						most = 1;
						mostVal = str;
					}
					map.put(str, 1);
				}
			}
		}

		return  mostVal;
	}
}
