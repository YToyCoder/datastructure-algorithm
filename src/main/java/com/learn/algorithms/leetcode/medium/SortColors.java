package com.learn.algorithms.leetcode.medium;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 
 * 解体方法: 双指针
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {

  public void sortColors(int[] nums) {
    int zero = 0;
    while(zero < nums.length && nums[zero] == 0) zero++;
    int two = nums.length - 1;
    while(two >= 0 && nums[two] == 2) two--;
    for(int i=zero; i< two + 1; i++) {
      if(nums[i] == 0 && zero < two) {
        nums[i] = nums[zero];
        nums[zero] = 0;
        zero++;
      }else if(nums[i] == 2 && zero < two) {
        if(nums[two] != 2) {
          nums[i] = nums[two];
          nums[two] = 2;
          if(nums[i] == 0) i--;
        }else i--;
        two--;
      }
    }
  }
}
