package leetcode.Q173_Binary_Search_Tree_Iterator;

import java.util.Stack;

/**
 * @author Gyumin Kim
 * @since 2019-03-11
 */
public class Solution {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
      pushAllLeft(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
      TreeNode tmp = stack.pop();
      pushAllLeft(tmp.right);
      return tmp.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    public void pushAllLeft(TreeNode node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */