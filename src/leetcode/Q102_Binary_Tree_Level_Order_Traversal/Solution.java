package leetcode.Q102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Gyumin Kim
 * @since 2019-02-09
 */
public class Solution {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<List<Integer>> list = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
      int i = 0;
      int size = queue.size();

      List<Integer> integerList = new ArrayList<>();
      while (i < size) {
        TreeNode node = queue.removeFirst();
        integerList.add(node.val);
        if (node.left != null)  queue.addLast(node.left);
        if (node.right != null)  queue.addLast(node.right);
        i++;
      }
      list.add(integerList);
    }

    return list;
  }
}
