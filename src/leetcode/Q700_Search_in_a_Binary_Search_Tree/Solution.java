package leetcode.Q700_Search_in_a_Binary_Search_Tree;

/**
 * @author Gyumin Kim
 * @since 2019-03-12
 *
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
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

  private TreeNode searchBST(TreeNode root, int val) {
    if (root == null)   return null;

    if (root.val == val)    return root;
    else if (val < root.val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }
}