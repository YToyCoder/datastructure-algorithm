package com.learn.ds;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.learn.ds.tree.BSTree;

public class TreeTest {

  @Test
  public void BSTreeTest(){
    final var tree = new BSTree<Integer, String>();
    final var ints = new int[]{15, 9,8 ,10 , 20, 32, 46, 1};
    for(int i : ints){
      tree.put(i, Integer.toString(i));
    }
    /**
     *                  15
     *                 / \
     *                9  20
     *               / \   \
     *              8   10  32
     *             /         \
     *            1           46
     */
    assertTrue("BSTree size should be 8", tree.size() == 8);

    tree.remove(1);

    /**
     *                  15
     *                 / \
     *                9  20
     *               / \   \
     *              8   10  32
     *                       \
     *                       46
     */

     assertTrue("BSTree size should be 7", tree.size() == 7);
     tree.remove(9);
     tree.remove(15);
     assertTrue("BSTree size should be 5", tree.size() == 5);
  }
}
