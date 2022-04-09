package com.learn.algorithms.leetcode.hard;

public class ReachingPoint {

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if(sx == tx && sy == ty) return true;
		if(tx == ty) return false;
		while((sx != tx || sy != ty) && tx > 0 && ty > 0){
			if(tx > ty){
				tx = tx - ty;
			}else {
				ty = ty - tx;
			}
		}
		return sx == tx && sy == ty;
	}

	// 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
	// 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
	public boolean reachingPointsFast(int sx, int sy, int tx, int ty) {
		if(sx == tx && sy == ty) return true;
		if(tx == ty) return false;
		int temp;
		int maxOne = Math.max(sx, sy);
		while((sx != tx || sy != ty) && tx > 0 && ty > 0 && (tx > maxOne || ty > maxOne)){
			if(tx > ty){
				temp = tx - maxOne;
				tx = temp > ty ? temp % ty + maxOne : temp - ty + maxOne;
			}else {
				temp = ty - maxOne;
				ty = temp > tx ? temp % tx + maxOne : temp - tx + maxOne;
			}
		}
		return sx == tx && sy == ty;
	}
}
