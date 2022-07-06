package com.learn.ds;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.junit.Test;

import com.learn.ds.tree.BSTree;
import com.learn.ds.tree.RBTree;

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

  @Test
  public void rbTreeTest() {
    final var tree = new RBTree<Integer>();
    tree.insert(1);
    assertTrue("tree size should be 1", tree.size() == 1);
    assertTrue("tree should exists 1", tree.exists(1));
    tree.insert(2);
    assertTrue("tree size should be 2", tree.size() == 2);
    assertTrue("tree should exists 2", tree.exists(2));

    IntInterval.fromToBy(3, 10, 3).forEach(i -> {
      tree.insert(i);
    });
    assertTrue("tree size should be 5", tree.size() == 5);
//    tree
    tree.insert(3);
    /**
     *             2(b)
     *           /      \
     *          1(b)     6(b)
     *                 /    \
     *                3(r)   9(r)
     *
     *             2(b)
     *           /      \
     *          1(b)     9(b)
     *                 /    \
     *               3(r)   del(r)
     * case r r:
     *
     */
//    assertTrue("tree size should be 5", tree.size() == 5);
    tree.remove(6);
//    assertTrue("tree size should be 4", tree.size() == 4);
//    tree.insert(20);
    IntInterval.fromTo(11, 31).forEach(i -> {
      tree.insert(i);
    });
    assertTrue("tree size should be 4 + 21", tree.size() == 25);
    assertFalse("not exist 6", tree.exists(6));
    System.out.println("");
  }
}
