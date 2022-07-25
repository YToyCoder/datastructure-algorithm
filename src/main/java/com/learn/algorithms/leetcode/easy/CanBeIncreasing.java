package com.learn.algorithms.leetcode.easy;


/*

给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。

数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/remove-one-element-to-make-the-array-strictly-increasing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

public class CanBeIncreasing {
  

    public boolean canBeIncreasing(int[] nums) {
      boolean hasDoneRm = false;
      for(int i=1; i<nums.length; i++){
        if(nums[i] <= nums[i - 1]){
          if(hasDoneRm) return false;
          // two case 

          /**
           * 1 remove i - 1
           */

           /**
            * 2 remove i 
            */
          if(
            // !(
            //   i == 1 || 
            //   i == nums.length - 1 || 
            //   (i != 1 && nums[i - 2] < nums[i]) || 
            //   (i != nums.length - 1 && nums[i - 1] < nums[i + 1])
            // )
            i != 1 && 
            nums[i - 2] >= nums[i] && 
            i != nums.length - 1 && 
            nums[i - 1] >= nums[i + 1]
          ) return false;

          hasDoneRm = true;
        }
      }
      return true;
    }
  
}
