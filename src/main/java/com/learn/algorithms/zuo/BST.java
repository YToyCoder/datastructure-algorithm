package com.learn.algorithms.zuo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BST {
  
  /**
   * *not tested*
   * 判断一棵树是否是搜索二叉树
   * @param root
   * @return
   */
  public static boolean isBST(BSTNode root){
    if(Objects.isNull(root)) return true;
    if(
      (Objects.nonNull(root.left) && root.key <= root.left.key) ||
      (Objects.nonNull(root.right) && root.key >= root.right.key)
    ) return false;
    if(!isBST(root.left)) return false;
    return isBST(root.right);
  }

  /**
   * 中序遍历插入list，list是一个升序的数组，再对list进行比较
   * @param root
   * @return
   */
  public static boolean isBST2(BSTNode root){
    if(Objects.isNull(root)) 
      return true;
    var list = new ArrayList<BSTNode>();
    walk(root, list);
    BSTNode pre = list.get(0);
    for(int i=1; i < list.size(); i++){
      if(pre.key >= list.get(i).key) 
        return false;
    }
    return true;
  }

  /**
   * 中序遍历 - 递归
   * 可以考虑采用循环实现
   * @param root
   * @param inOrderList
   */
  public static void walk(BSTNode root, List<BSTNode> inOrderList){
    if(Objects.isNull(root)) return;
    walk(root.left, inOrderList);
    inOrderList.add(root);
    walk(root.right, inOrderList);
  }

  /**
   * 是否是完全二叉树
   * 广度优先遍历
   * @param root
   * @return
   */
  public static boolean isCBT(BSTNode root){
    Queue<BSTNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      BSTNode node = queue.poll();
      if(
        (!hasTwoChild(node) && hasTwoChild(queue.peek())) || 
        (Objects.isNull(node.left) && Objects.nonNull(node.right))
      ) return false;
      if(Objects.nonNull(node.left)) 
        queue.add(node.left);
      if(Objects.nonNull(node.right)) 
        queue.add(node.right);
    }
    return true;
  }

  private static boolean hasTwoChild(BSTNode node){
    return Objects.nonNull(node) && Objects.nonNull(node.left) && Objects.nonNull(node.right);
  }


}
