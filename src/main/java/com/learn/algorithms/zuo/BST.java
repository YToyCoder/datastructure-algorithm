package com.learn.algorithms.zuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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


  /**
   * 判断二叉树是否是平衡树
   * @param node
   * @return
   */
  public static boolean isBalanced(BSTNode node){
    return checkIfBalance(node).isBalanced;
  }

  public static BalanceResult checkIfBalance(BSTNode node){
    if(Objects.isNull(node)) 
      return new BalanceResult(true, 0);
    BalanceResult leftResult = checkIfBalance(node.left);
    BalanceResult rightResult = checkIfBalance(node.right);
    int height = Math.max(leftResult.height, rightResult.height) + 1;
    boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.height - rightResult.height) < 2;
    return new BalanceResult(isBalanced, height);
  }

  static class BalanceResult{

    public boolean isBalanced;
    public int height;

    public BalanceResult(boolean isBalanced, int height){
      this.isBalanced= isBalanced;
      this.height = height;
    }

  }

  /**
   *找到两个节点的公共最低祖先
   * @return
   */
  public static BSTNode lowestCommonAncestor(BSTNode root, BSTNode a, BSTNode b){
    if(Objects.isNull(a) || Objects.isNull(b) || Objects.isNull(root)) return null;
    Map<BSTNode,BSTNode> fatherMap = new HashMap<>();
    fatherMap.put(root, root);
    setFatherMap(root, fatherMap);
    List<BSTNode> a2rootList = new ArrayList<>();
    List<BSTNode> b2rootList = new ArrayList<>();

    a2rootList.add(a);
    while(!Objects.equals(a, fatherMap.get(a))){
      a = fatherMap.get(a);
      a2rootList.add(a);
    }
    while(!Objects.equals(b, fatherMap.get(b))){
      b = fatherMap.get(b);
      b2rootList.add(b);
    }
    final int minWalkLen = Math.min(a2rootList.size(), b2rootList.size());
    for(int i=0; i < minWalkLen; i++){
      if(Objects.equals(a2rootList.get(i), b2rootList.get(i))) return a2rootList.get(i);
    }
    return null;
  }

  private static void setFatherMap(BSTNode root, Map<BSTNode, BSTNode> fatherMap) {
    if(Objects.isNull(root)) return;
    if(Objects.nonNull(root.right)) fatherMap.put(root.right, root);
    if(Objects.nonNull(root.left)) fatherMap.put(root.left, root);
    setFatherMap(root.left, fatherMap);
    setFatherMap(root.right, fatherMap);
  }

  //version 2
  public static BSTNode lowestCommonAncestor2(BSTNode root, BSTNode a, BSTNode b){
    if(
      Objects.isNull(root) || 
      Objects.equals(root, a) ||
      Objects.equals(root, b)
    ) return root;
    BSTNode left = lowestCommonAncestor(root.left, a, b);
    BSTNode right = lowestCommonAncestor(root.right, a, b);
    if(Objects.nonNull(left) && Objects.nonNull(right)) return root;
    return Objects.isNull(left) ? right : left;
  }

}
