package leetcode.Q144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

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

  /**
   * recursive
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    list.add(root.val);
    if (root.left != null) list.addAll(preorderTraversal(root.left));
    if (root.right!= null) list.addAll(preorderTraversal(root.right));

    return list;
  }

  /**
   * iterative
   */
  public List<Integer> preorderTraversal2(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode pointer = stack.pop();
      list.add(pointer.val);
      if (pointer.right != null) stack.push(pointer.right);
      if (pointer.left != null) stack.push(pointer.left);
    }

    return list;
  }
}
