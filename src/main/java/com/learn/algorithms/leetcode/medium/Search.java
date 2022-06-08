package com.learn.algorithms.leetcode.medium;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {

  public int search(int[] nums, int target) {
    return deepSearch(nums, 0, nums.length - 1, target);
  }

  private int deepSearch(int[] nums, int start, int end, int target) {
    if(nums[start] == target) return start;
    if(nums[end] == target) return end;
    if(start == end) return -1;
    if(start + 1 == end) 
      return nums[start] != target && nums[end] != target ? -1 : nums[start] == target ? start : end;  
    final int mid = start + (end - start) / 2;
    if(nums[start] < nums[mid]) {
      if(nums[start] <= target && target <= nums[mid]) return deepSearch(nums, start, mid, target);
      else {
        if(
          (nums[mid] < nums[end] && nums[mid] <= target && nums[end] >= target) || 
          (nums[mid] > nums[end] && ( nums[mid] <= target || nums[end] >= target ))
          ) return deepSearch(nums, mid, end, target);
        else return -1;
      }
    }else if(nums[start] <= target || target <= nums[mid]) return deepSearch(nums, start, mid, target);
    else if(nums[mid] <= target && target <= nums[end]) return deepSearch(nums, mid, end, target);
    return -1;
  }
}
