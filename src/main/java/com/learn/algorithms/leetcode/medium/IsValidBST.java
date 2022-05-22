package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

import com.learn.utils.TreeNode;

// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

// 有效 二叉搜索树定义如下：

//     节点的左子树只包含 小于 当前节点的数。
//     节点的右子树只包含 大于 当前节点的数。
//     所有左子树和右子树自身必须也是二叉搜索树。

// 来源：力扣（LeetCode）
// 链接：https://leetcode.cn/problems/validate-binary-search-tree
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 二叉树中序遍历
public class IsValidBST {

  private long pre = Long.MIN_VALUE;
  
  public boolean isValidBST(TreeNode root) {
    if(Objects.isNull(root)) return true;
    if(!isValidBST(root.left)) return false;
    if(pre >= root.val) return false;
    pre = root.val;  
    return isValidBST(root.right);
  }
  
  
}
