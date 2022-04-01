package com.learn.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BusiestServers {

	public static void main(String[] args) {
		new BusiestServers().busiestServers(1, new int[]{1,2}, new int[]{3,4});
	}

	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		PriorityQueue<Integer> available = new PriorityQueue<>((a,  b) -> a - b);
		for(int i=0; i<k; i++)
			available.offer(i);
		PriorityQueue<int[]> buzy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int maxTask = 0;
		int[] task = new int[k];
		for(int i=0; i<arrival.length; i++){
			while(!buzy.isEmpty() && buzy.peek()[0] <= arrival[i]){
				int id = buzy.poll()[1];
				available.offer(i + ((id - i)%k + k)%k);
			}
			if(!available.isEmpty()){
				int server = available.poll()%k;
				task[server]++;
				buzy.offer(new int[] {arrival[i] + load[i], server});
				if(task[server] > maxTask)
					maxTask = task[server];
			}
		}
		List<Integer> res = new ArrayList<>();
		for(int t=0; t < k; ++t)
			if(task[t] == maxTask) res.add(t);
		return res;
	}

	public List<Integer> oldTimeOut(int k, int[] arrival, int[] load){
		int[] tasks = new int[k];
		int[] remainTime = new int[k];
		int arrivalTime, loadTime, machine;
		int maxTask = 0;
		for(int i=0; i<arrival.length; i++){
			arrivalTime = arrival[i];
			loadTime = load[i];
			machine = i % k;
			if(remainTime[machine] > arrivalTime)
				machine = machine == k - 1 ? 0 : machine + 1;
			while(remainTime[machine] > arrivalTime && machine != i % k){
				machine = machine == k - 1 ? 0 : machine + 1;
			}
			if(remainTime[machine] <= arrivalTime){
				tasks[machine] += 1;
				remainTime[machine] = arrivalTime + loadTime;
				if(tasks[machine] > maxTask)
					maxTask = tasks[machine];
			}
		}
		List<Integer> res = new ArrayList<>();
		for(int t=0; t < k; ++t)
			if(tasks[t] == maxTask) res.add(t);
		return res;
	}
}
